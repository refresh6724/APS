import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
    static class Node implements Comparable<Node> {
        int low;
        int high;
 
        public Node(int low, int high) {
            super();
            this.low = low;
            this.high = high;
        }
 
        @Override
        public int compareTo(Node o) {
            return o.low - low; // 온도가 높은 것부터 정렬
        }
 
    }
 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    static int answer;
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        sc.init();
        int N = sc.nextInt(); // 1이상 100이하 화학물질의 개수
        List<Node> list = new LinkedList<Node>();
        for (int i = 0; i < N; i++) {
            list.add(new Node(sc.nextInt(), sc.nextInt()));
            // -270 이상 10000이하 범위이내의 두 값
        }
        Collections.sort(list);
        boolean[] visited = new boolean[N];
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp = list.get(i).low;
                for (int j = i + 1; j < N; j++) {
                    if (!visited[j] && list.get(j).low <= temp && list.get(j).high >= temp) {
                        visited[j] = true;
                    }
                }
                answer++;
            }
        }
 
        bw.write(String.format("%d", answer));
        bw.flush();
 
    }
 
    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;
 
        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(" ");
        }
 
        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }
 
        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
 
        }
 
        static int nextInt() {
            return Integer.parseInt(next());
        }
 
        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}