import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_D5_1247_최적경로_순열재귀 { // 제출일 2019-08-22 00:27 // 26,700 kb 1,896 ms
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer;
    static int N;
    static int[] start;
    static int[] end;
    static int[][] xy;
    static int[] visited;
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        sc.init();
        // 테스트케이스
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            // N명의 고객을 방문하고 집으로
            N = sc.nextInt(); // 고객 2명이상 10명 이하
            // 회사 위치, 집 위치, 고객 N명 위치
            start = new int[2];
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end = new int[2];
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
            xy = new int[N][2];
            for (int i = 0; i < N; i++) {
                xy[i][0] = sc.nextInt();
                xy[i][1] = sc.nextInt();
            }
 
            answer = 10000000;
            visited = new int[N];
            permutation(0, 0);
 
            bw.write(String.format("#%d %d\n", tc, answer));
            bw.flush();
        }
 
    }
/*
 
10
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
7
22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83
8
30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63
9
3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
10
26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96
10
46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63
10
94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3
10
32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86
 
 
#1 200
#2 304
#3 265
#4 307
#5 306
#6 366
#7 256
#8 399
#9 343
#10 391
 
 */
    private static void permutation(int idx, int cnt) {
        if (idx == N) { // 마지막까지 정해졌다면
            //System.out.println(Arrays.toString(visited));
            int sum = 0;
            //start에서 0번까지 
            sum = Math.abs(xy[visited[0]][0]-start[0]) + Math.abs(xy[visited[0]][1]-start[1]);
            //0번에서 N-1까지
            for (int i = 1; i < N; i++) {
                sum += Math.abs(xy[visited[i]][0]-xy[visited[i-1]][0]) + Math.abs(xy[visited[i]][1]-xy[visited[i-1]][1]);
            }
            //N-1에서 1까지
            sum += Math.abs(end[0] - xy[visited[N-1]][0]) + Math.abs(end[1] - xy[visited[N-1]][1]);
             
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((cnt & (1 << i)) == 0) { // i번째 원소를 사용중이면 i번째 비트 1을 반환하므로 0일때 사용중이지 않는 것이다
                visited[idx] = i;
                permutation(idx + 1, cnt | (1 << i));
            }
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