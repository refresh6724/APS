import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
 
    static int answer1;
    static int answer2;
    static int N;
    static int R;
    static int C;
 
    static class Time { // implements Comparator<Time>
        int s;
        int e;
 
        public Time(int s, int e) {
            super();
            this.s = s;
            this.e = e;
        }
 
        public int getS() {
            return s;
        }
 
        public void setS(int s) {
            this.s = s;
        }
 
        public int getE() {
            return e;
        }
 
        public void setE(int e) {
            this.e = e;
        }       
 
        @Override
        public String toString() {
            return "Time [s=" + s + ", e=" + e + "]";
        }
 
    }
 
    static class comparator implements Comparator<Time> {
 
        @Override
        public int compare(Time o1, Time o2) {
 
            int c1 = o1.s - o2.s; // 오름차순
            int c2 = o2.e - o1.e; // 내림차순
 
            if (c1 == 0) {
                return ((c2 == 0) ? c1 : c2);
            } else {
                return c1;
            }
        }
        // 문자열이면 compareTo
    }
 
    public static void main(String[] args) throws Exception {       
        sc.init();
        N = sc.nextInt();// 1만이하 자연수
 
//      System.out.println(Integer.MAX_VALUE);
//      System.out.println((1<<31) -1);
 
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Time(a, b));
        }
 
        // 한명이상의 학생이 머물렀던 가장 긴 시간
        answer1 = 0;
        // 학생이 한 명도 머물지 않았던 가장 긴 시간
        answer2 = 0;
 
//      list.sort(Comparator.comparing(Time::getS));
        Collections.sort(list, new comparator());
        // 시작시간이 빠르면서 종료시간은 느린 순으로 재배열
         
        //System.out.println(list);
         
        // 1부터 시작해서 시간 세기
        int person =0;
        int blank =0;
         
        Time pre = new Time(0, 0);
        for (int i = 0; i < N; i++) {
            Time cur = list.get(i);
             
            // 현재 시간의 시작시간이 이전 시간과 같다면 종료시간은 정렬 조건에 의해 같거나 짧으므로 무시할 수 있다.
            if(cur.s == pre.s) {
                //System.out.println("case1 " + pre + " " + cur);
                continue;
            } else if(cur.e > pre.e){ // 다른경우는 현재의 시작시간이 이전시간보다 큰 경우밖에 없다
                // 이 쪽은 두 경우 3 5 -> 4 7 또는    3 5 -> 10 13
                if(cur.s > pre.e) { //   3 5 -> 10 13
                    //System.out.println("case2 " + pre + " " + cur);
                    blank = Math.max(cur.s-pre.e, blank);
                    person = cur.e-cur.s;
                    answer1 = Math.max(answer1, person);
                } else { //  3 5 -> 4 7
                    //System.out.println("case3 " + pre + " " + cur);
                    person += cur.e-pre.e;
                    answer1 = Math.max(answer1, person);                    
                }           
                 
            } else { // 과거가 3 6 현재의 시간이 4 6 일 경우 이쪽으로 빠지게 되는데 역시 의미가 없다
                //System.out.println("case4 " + pre + " " + cur);
                continue;               
            }
             
            // 모든 계산이 끝나면 다음을 위해
            pre = cur;          
        }
         
        System.out.println(answer1 + " " + blank);
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