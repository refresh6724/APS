import java.util.Scanner;
 
/*
 * 자연수 N과 M을 입력 받아서 주사위를 N번 던져서 나온 눈의 합이 M이 나올 수 있는 모든 경우를 출력하는 프로그램을 작성하시오
 * 첫 줄에 주사위를 던진 횟수 N(2<=7) 과 눈의 합 M(1<=40)이 들어온다.
 * 주사위를 던진 횟수의 합이 M이 되는 경우를 모두 출력한다
 * 입력 예) 3 10  3번던져 10이 나오는 경우
 * 출력 예) 1 3 6
 *          1 4 5 ...
 * 
 * 
 */
public class Main {
     
    static int N;
    static int M;
    static int[] dices;
    static int sum;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dices = new int[N];
        sum = 0;
        roll(0); // sum을 매개변수로 주면 stackoverflow 발생
    }
    static void roll(int index) {
        if(index == N) {
            if(sum == M) { 
                for (int i = 0; i < N-1; i++) {
                    System.out.print(dices[i]+" ");
                }
                System.out.print(dices[N-1]+"\n");
            }
            return;
        }               
        for(int i=1; i<=6; i++) {
            sum += i;
            dices[index] = i;
            roll(index+1);  
            sum -= i;
        }       
    }
}