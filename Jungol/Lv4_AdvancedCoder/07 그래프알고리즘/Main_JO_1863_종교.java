import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer;
 
    static int[] parents;
 
    static void make() { // make set : 모든 원소를 개별적인 집합으로 생성
        Arrays.fill(parents, -1);
    }
 
    static int find(int a) {
        if (parents[a] < 0)
            return a; // 자신이 루트이면 자신 리턴
        return parents[a] = find(parents[a]);
    }
 
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;
        parents[bRoot] = aRoot;
        return true;
    }
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        sc.init();
 
        int n = sc.nextInt();
        parents = new int[n + 1]; // 1~50000명
        make();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
 
        // 0을 제외하고 -1의 숫자를 세고
        // 남은 수의 종류를 센다
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            if(parents[i] == -1) {
                answer++;
            } else {
                //map.put(parents[i], 1);
            }
        }
        System.out.println(answer);
        //answer += map.size();
        //System.out.println(answer);
         
        //bw.write(String.format("%d", answer));
        //bw.flush();
 
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