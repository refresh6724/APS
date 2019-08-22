import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_D0_2383_점심식사시간 { // 제출일 2019-08-22 12:10
 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    static int N; // 맵 크기 제한
    static int step1L; // 첫번째 계단 길이
    static int step1LX;
    static int step1LY;
    static int step2L; // 두번째 계단 길이
    static int step2LX;
    static int step2LY;
    static int num;
 
    static class Person {
        int count;
        int x;
        int y;
        int dist1;
        int dist2;
        int save1;
        int save2;
 
        Person() {
        }
 
        Person(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
        }
 
        void reset() {
            this.dist1 = save1;
            this.dist2 = save2;
        }
    }
 
    static ArrayList<Person> list = new ArrayList<>(10); // 최대 10명
    static int people;
    static int answer;
 
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
 
    public static void main(String[] args) throws Exception {
        sc.init();
        // 테스트케이스
        int TC = sc.nextInt();
 
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            boolean is2 = false;
            int tmp = 0;
            list.clear();
            num = 1; // 사람을 1번부터
            // 입력
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    tmp = sc.nextInt();
                    if (tmp == 1) { // 사람
                        list.add(new Person(num++, row, col));
                    } else if (tmp > 1) { // 계단
                        if (is2) {
                            step2L = tmp;
                            step2LX = row;
                            step2LY = col;
                        } else {
                            step1L = tmp;
                            step1LX = row;
                            step1LY = col;
                            is2 = true;
                        }
                    } // else continue;
                }
            } // 입력 종료
 
            // 각 사람으로부터 계단까지 거리계산
            Person p = null;
            for (int i = 0; i < list.size(); i++) {
                p = list.get(i);
                p.save1 = Math.abs(step1LX - p.x) + Math.abs(step1LY - p.y);
                p.save2 = Math.abs(step2LX - p.x) + Math.abs(step2LY - p.y);
            }
 
            people = list.size();
            Arrays.fill(select, false); // 선택 초기화
            answer = Integer.MAX_VALUE;
            dfs(0); // 계단 선택
            bw.write(String.format("#%d %d\n", tc, answer));
            bw.flush();
        }
    }
 
    static boolean[] select = new boolean[10]; // 10명의 선택 기본 1=false 2=true
    static ArrayList<Person> move1;// 이동 리스트
    static Queue<Person> wait1;// 대기 큐
    static ArrayList<Person> step1; // 계단 리스트
    static ArrayList<Person> move2;// 이동 리스트
    static Queue<Person> wait2;// 대기 큐
    static ArrayList<Person> step2; // 계단 리스트
 
    static void dfs(int idx) {
        if (idx == people) {
            // dist 복구
            for (int i = 0; i < list.size(); i++) {
                list.get(i).reset();
            }
            calc();
            return;
        }
        dfs(idx + 1); // idx번 사람은 1번 계단을 선택
        select[idx] = true;
        dfs(idx + 1); // 2번 계단을 선택
        select[idx] = false;
    }
 
    static void calc() {
        //System.out.println("*******************************************");
        //System.out.println(Arrays.toString(select));
 
        answer = Integer.min(answer, getTime());
    }
 
    static int getTime() {
        int time = 0;
        move1 = new ArrayList<>();
        wait1 = new LinkedList<>();
        step1 = new ArrayList<>(3);
        // 1번 계단을 선택한 사람을 move 리스트에 넣는다
        move2 = new ArrayList<>();
        wait2 = new LinkedList<>();
        step2 = new ArrayList<>(3);
        // 2번 계단을 선택한 사람을 move 리스트에 넣는다
        for (int i = 0; i < people; i++) {
            if (!select[i])
                move1.add(list.get(i));
            else
                move2.add(list.get(i));
        }
        // 셋 중 하나라도 isEmpty가 아니면 계속 진행
        while (!step1.isEmpty() || !move1.isEmpty() || !wait1.isEmpty() || !step2.isEmpty() || !move2.isEmpty()
                || !wait2.isEmpty()) {
            time++;
            //System.out.printf("%d분 후\n", time);
            // move 리스트 전체 -1
 
            for (int i = 0; i < move1.size(); i++) {
                if (--move1.get(i).dist1 == 0) {
                    //System.out.printf("%d번이 1번 계단 입구 도착\n", move1.get(i).count);
                } else if (move1.get(i).dist1 == -1) {
                    move1.get(i).dist1 = step1L+1;
                    if (step1.size() == 3) {
                        wait1.add(move1.get(i));
                    } else {
                        step1.add(move1.get(i));
                    }
                    move1.remove(i--);
                }
            } // move1 끝
 
            for (int i = 0; i < move2.size(); i++) {
                if (--move2.get(i).dist2 == 0) {
                    //System.out.printf("%d번이 2번 계단 입구 도착\n", move2.get(i).count);
                } else if (move2.get(i).dist2 == -1) {
                    move2.get(i).dist2 = step2L+1;
                    if (step2.size() == 3) {
                        wait2.add(move2.get(i));
                    } else {
                        step2.add(move2.get(i));
                    }
                    move2.remove(i--);
                }
            } // move2 끝
 
            // 계단 감소
            for (int i = 0; i < step1.size(); i++) {
                if (--step1.get(i).dist1 == step1L) {
                    //System.out.printf("%d번이 1번 계단을 내려가기 시작\n", step1.get(i).count);
                } else if (step1.get(i).dist1 == 0) {
                    //System.out.printf("%d번이 이동 완료\n", step1.get(i).count);
                    step1.remove(i--);
                } else {
                    //System.out.printf("%d번이 이동 중\n", step1.get(i).count);
                }
            }
 
            // 계단 감소
            for (int i = 0; i < step2.size(); i++) {
                if (--step2.get(i).dist2 == step2L) {
                    //System.out.printf("%d번이 2번 계단을 내려가기 시작\n", step2.get(i).count);
                } else if (step2.get(i).dist2 == 0) {
                    //System.out.printf("%d번이 이동 완료\n", step2.get(i).count);
                    step2.remove(i--);
                } else {
                    //System.out.printf("%d번이 이동 중\n", step2.get(i).count);
                }
            }
 
            // step 크기가 3이 될때까지 큐에서 빼서 넣는다
            // 큐가 비어있거나 혹은 step이 3이 되면 break한다
            while (step1.size() != 3 && !wait1.isEmpty()) {
                wait1.peek().dist1--;
                //System.out.printf("%d번이 1번 계단을 내려가기 시작\n", wait1.peek().count);
                step1.add(wait1.poll());
            }
            while (step2.size() != 3 && !wait2.isEmpty()) {
                wait2.peek().dist2--;
                //System.out.printf("%d번이 2번 계단을 내려가기 시작\n", wait2.peek().count);
                step2.add(wait2.poll());
            }
        }
        return time;
    }
 
}