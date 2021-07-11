import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
// 1차 시도 TLE(20) / 147,240 kb / max : 2907 ms / mean : 1080 ms
public class Main { // 제출일 2021-07-11 23:59
 
    static int n, k;
    static int[] parent, color;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());// 노드 개수 5 이상 10만 이하
        k = Integer.parseInt(st.nextToken());// 연산 개수 1 이상 30만 이하
        // 연산 1이면 paint, 2면 move, 3이면 count
        // n개의 노드로 구성된 트리
        // 0번 노드가 루트, 나머지 1~n-1번 노드의 부모는 0번, 모든 에지의 색깔은 0
        // 또한, paint와 count 연산 시 a번 노드와 b번 노드사이의 최단경로의 길이는 항상 1,000 이하이다.
        // 모든 count 연산에 대해 결과값을 출력
 
        // LCA를 응용해서 최단거리를 구한다면 nlogn + 쿼리당 logn 10만*400 + 30만*400 = 1억??
        // move 한번이면 lca를 다시 그려야 한다
 
        int r, a, b, c;
        parent = new int[n];
        color = new int[n];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (r == 1) {
                c = Integer.parseInt(st.nextToken());
                paint(a, b, c);
            } else if (r == 2) {
                move(a, b);
            } else if (r == 3) {
                sb.append(count(a, b)).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
 
    }
 
    private static int count(int a, int b) {
        if (a == b) {
            return 1;
        }
        Set<Integer> colorSet = new HashSet<Integer>();
        visited = new boolean[n];
        int keep = a;
        int cnt = 0;
 
        // a를 위로 올라가며 visited 체크
        while (a != 0 && cnt < 1000) {
            visited[a] = true;
            a = parent[a];
            cnt++;
        }
        cnt = 0;
        // b를 위로 올라가며 a와 lca 찾기
        while (b != 0 && cnt < 1000) {
            colorSet.add(color[b]);
            if (visited[b]) {
                break;
            }
            b = parent[b];
            cnt++;
        }
        // lca를 찾았다면 a를 다시 위로 올라가며 색칠
        while (keep != 0 && keep != b) {
            colorSet.add(color[keep]);
            keep = parent[keep];
        }
 
        return colorSet.size();
    }
 
    private static void move(int a, int b) {
        parent[a] = b;
    }
 
    private static void paint(int a, int b, int c) {
        if (a == b) {
            return;
        }
        visited = new boolean[n];
        int keep = a;
        int cnt = 0;
        // a를 위로 올라가며 visited 체크
        // 0은 칠하지 않고 숫자를 세지도 않는다
        while (a != 0 && cnt < 1000) {
            visited[a] = true;
            a = parent[a];
            cnt++;
        }
        cnt = 0;
        // b를 위로 올라가며 a와 lca 찾기
        while (b != 0 && cnt < 1000) {
            color[b] = c;
            if (visited[b]) {
                break;
            }
            b = parent[b];
            cnt++;
        }
        // lca를 찾았다면 a를 다시 위로 올라가며 색칠
        while (keep != 0 && keep != b) {
            color[keep] = c;
            keep = parent[keep];
        }
        return;
    }
 
}