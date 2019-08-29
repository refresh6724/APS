import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
class Atom {
    int num;
    int x;
    int y;
 
    public Atom(int num, int x, int y) {
        super();
        this.num = num;     
        this.x = x;
        this.y = y;
    }
 
}
 
class Contact implements Comparable<Contact> {
    int time;
    int a;
    int b;
 
    public Contact(int time, int a, int b) {
        super();
        this.time = time;
        this.a = a;
        this.b = b;
    }
 
    @Override
    public int compareTo(Contact c) {
        return time - c.time;
    }
 
}
 
public class Solution_D0_5648_원자소멸시뮬레이션 { // 제출일 2019-08-29 12:22
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    static int answer;
    static int N;
    static int[] visited;
    static int[] energy;
 
    public static void main(String args[]) throws Exception {
 
        sc.init();
        // 테스트케이스
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            answer = 0;
            N = sc.nextInt(); // 원자의 개수
            visited = new int[N + 1]; // 방문시간으로 바꿈
            energy = new int[N + 1];
            List<Atom> up = new ArrayList<Atom>(N >> 2);
            List<Atom> down = new ArrayList<Atom>(N >> 2);
            List<Atom> left = new ArrayList<Atom>(N >> 2);
            List<Atom> right = new ArrayList<Atom>(N >> 2);
            // 좌표 -1000 ~ 1000 : 2001개 좌표
            // 변환 0 ~ 2000 : 2001개 좌표
            // 변환 0 ~ 4000 : 4001개 좌표
            // 원좌표 + 1000) *2
            for (int i = 1; i <= N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                energy[i] = sc.nextInt();
                switch (c) { // 상하좌우 0123
                case 0:
                    up.add(new Atom(i, (b + 1000) * 2, (a + 1000) * 2));
                    break;
                case 1:
                    down.add(new Atom(i, (b + 1000) * 2, (a + 1000) * 2));
                    break;
                case 2:
                    left.add(new Atom(i, (b + 1000) * 2, (a + 1000) * 2));
                    break;
                case 3:
                    right.add(new Atom(i, (b + 1000) * 2, (a + 1000) * 2));
                    break;
                }
            }
 
            List<Contact> list = new LinkedList<Contact>();
            // 각 리스트에 대해 다른 리스트와 접촉 가능성이 있다면 업데이트
            Atom u, d, l, r;
            // up
            for (int i = 0; i < up.size(); i++) {
                u = up.get(i);
                // down 과 만날 수 있나?
                for (int j = 0; j < down.size(); j++) {
                    d = down.get(j);
                    if (u.x < d.x && u.y == d.y) {
                        // 열이 같고 위 아래가 마주칠 수 있다면
                        list.add(new Contact((d.x - u.x) >> 1, u.num, d.num));
                    }
                }
                // right
                for (int j = 0; j < right.size(); j++) {
                    r = right.get(j);
                    if (r.x > u.x && u.y > r.y) {
                        if (r.x - u.x == u.y - r.y) {
                            list.add(new Contact(r.x - u.x, u.num, r.num));
                        }
                    }
                }
                // left
                for (int j = 0; j < left.size(); j++) {
                    l = left.get(j);
                    if (l.y > u.y && l.x > u.x) {
                        if (l.y - u.y == l.x - u.x) {
                            list.add(new Contact(l.y - u.y, u.num, l.num));
                        }
                    }
                }
            }
            // down
            for (int i = 0; i < down.size(); i++) {
                d = down.get(i);
                // right
                for (int j = 0; j < right.size(); j++) {
                    r = right.get(j);
                    if (d.x > r.x && d.y > r.y) {
                        if (d.x - r.x == d.y - r.y) {
                            list.add(new Contact(d.x - r.x, d.num, r.num));
                        }
                    }
                }
                // left
                for (int j = 0; j < left.size(); j++) {
                    l = left.get(j);
                    if (d.x > l.x && l.y > d.y) {
                        if (d.x - l.x == l.y - d.y) {
                            list.add(new Contact(l.y - d.y, d.num, l.num));
                        }
                    }
                }
            }
            // right
            for (int i = 0; i < right.size(); i++) {
                r = right.get(i);
                // left
                for (int j = 0; j < left.size(); j++) {
                    l = left.get(j);
                    if (l.y > r.y && l.x == r.x) {
                        // 행이 같고 좌우가
                        list.add(new Contact((l.y - r.y) >> 1, l.num, r.num));
                    }
                }
            }
 
            // list를 시간에 따라 정렬
            Collections.sort(list);
 
            // 리스트의 앞부터 visited 체크
            // 에너지 더하기
            // 3개가 부딪힐때를 고려하지 못했음
            // 시간이 같고 둘 중 하나가 이전과 같다면 세번째도 지우기
 
            int time = 0;
            for (int i = 0; i < list.size(); i++) {
                int A = list.get(i).a;
                int B = list.get(i).b;
                if (list.get(i).time != time) { // 이전 시간과 다르다면
                    time = list.get(i).time; // 시간을 갱신하고
                    if (visited[A] == 0 && visited[B] == 0) {
                        visited[A] = time;
                        answer += energy[A];
                        visited[B] = time;
                        answer += energy[B];
                        // System.out.print(String.format("%d %d\n", A, B));
                    } else
                        continue;
                } else { // 시간이 같다면
                    if (visited[A] == 0 && visited[B] == 0) {
                        visited[A] = time;
                        answer += energy[A];
                        visited[B] = time;
                        answer += energy[B];
                    } else if (visited[A] == time && visited[B] == 0) {
                        visited[B] = time;
                        answer += energy[B];
                    } else if (visited[B] == time && visited[A] == 0) {
                        visited[A] = time;
                        answer += energy[A];
                    } else
                        continue;
                }
            }
            /*
             * File file = new File("out.txt"); FileWriter fw = new FileWriter(file);
             * //System.out.println(list.toString()); // 15
             * //System.out.println(Arrays.toString(visited)); // 16
             * fw.write(list.toString()); fw.close();
             */
 
            // 표준출력(화면)으로 답안을 출력합니다.
            bw.write(String.format("#%d %d\n", tc, answer));
            bw.flush();
        }
 
    }
 
    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;
 
        static void init() throws Exception {
            // System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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