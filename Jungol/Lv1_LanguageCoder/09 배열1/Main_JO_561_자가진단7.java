import java.util.Scanner;
 
public class Main {
    static int a, b = 0; // 출력예정값
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    /*
     * 10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오.
        (입력되는 정수의 범위는 1이상 10,000 미만이다. 만약 해당하는 수가 없을 때에는 100 을 출력한다.)
        입력 예) 88 123 659 15 443 1 99 313 105 48
        출력 예) 99 105
        Hint ) 
        100 미만의 수로 입력 가능한 범위는 1~99, 100 이상의 수로 입력 가능한 범위는 100~9999 이다. 
        입력값보다 큰수(작은수)를 초기값으로 정하고 작업이 끝난 후 초기값이 그대로 있다면 해당하는 수가 없는 것이다.
     */
        Scanner scan = new Scanner(System.in);
        //int[] lowerThanHundread = new int[10];
        //int[] higherThanHundread = new int[10];
         
        //첫번째 입력
        int temp = scan.nextInt();
         
        if(temp>=100) {
            b = temp;
        } else {
            a = temp;
        }
        for(int i=0; i<9; i++) {
            temp = scan.nextInt();
            // 입력값이 100보다 크다면 b와 비교 작다면 a와 비교
            if(temp>=100) {
                if(b == 0) {
                    b = temp;
                } else if (b>temp) {
                    b = temp; // temp가 더 작으면 바꾼다
                } // temp가 100보다 크면서 b보다 크면 의미가 없다
                 
            } else { // temp가 100미만인 경우
                if(a==0) {
                    a=temp;
                } else if (a<temp) {
                    a = temp;
                }
                 
            }       
        }
        if(a == 0) a = 100;
        if(b == 0) b = 100;
        System.out.println(a+" "+b);
         
         
    }
 
}