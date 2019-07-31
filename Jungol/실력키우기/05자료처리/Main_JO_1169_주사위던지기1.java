import java.util.Scanner;
 
/*
  
주사위를 던진 횟수 N과 출력형식 M을 입력 받아서 M의 값에 따라 각각 아래와 같이 출력하는 프로그램을 작성하시오.
  
M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
  
* 중복의 예
1 1 2 와 중복 : 1 2 1, 2 1 1
1 2 3 과 중복 : 1 3 2, 2 1 3, 2 3 1, 3 1 2
 
 */
public class Main {
     
    static int N;
    static int M;
    static int[] dices; 
    static int bit = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dices = new int[N];
     
        switch(M) {
        case 1:
            rollAll(0);
            break;
        case 2:
            rollDiff(0, 1);
            break;
        case 3: 
            rollPermutation(0);
            break;
        }
        System.out.println(sb);
    }
    static void rollAll(int index) {
        // 주사위를 N번 던져 나올 수 있는 모든 경우
        if(index == N) {
            for (int i = 0; i < N-1; i++) {
                sb.append(dices[i]).append(" ");
            }
            sb.append(dices[N-1]).append("\n");
            return;
        }       
        for (int i = 1; i <= 6; i++) {
            dices[index] = i;
            rollAll(index+1);
        }   
    }
     
    static void rollCombination(int index, int dice) {
        // 중복 없이, 1 2 3 과 중복 : 1 3 2, 2 1 3, 2 3 1, 3 1 2
        // 종료조건
        if(index == N) {
            for (int i = 0; i < N-1; i++) {
                sb.append(dices[i]).append(" ");
            }
            sb.append(dices[N-1]).append("\n");
            return;
        }
        if(dice == 7) {
            return;
        }
        dices[index] = dice;
        rollCombination(index+1, dice+1);
        rollCombination(index, dice+1); // 이대로 넘겨서 덮어쓰기
         
    }
     
    static void rollDiff(int index, int dice) {
        // 서로 다른 조합(원소 중복 허용)
        // 종료조건
        if(index == N) {
            for (int i = 0; i < N-1; i++) {
                sb.append(dices[i]).append(" ");
            }
            sb.append(dices[N-1]).append("\n");
            return;
        }
        if(dice == 7) {
            return;
        }
        dices[index] = dice;
        rollDiff(index+1, dice);        
        rollDiff(index, dice+1);
         
    }
     
    static void rollPermutation(int index) {
        // 서로 다른 조합(원소 중복 허용)
        // 종료조건
        if(index == N) {
            for (int i = 0; i < N-1; i++) {
                sb.append(dices[i]).append(" ");
            }
            sb.append(dices[N-1]).append("\n");
            return;
        }
        for(int i=1; i<=6; i++) {
            if((bit & (1<<i)) != (1<<i)) { // 미방문시에만
                dices[index] = i;
                bit |= (1<<i);
                rollPermutation(index+1);
                bit ^= (1<<i);
            }
        }
    }
     
     
}