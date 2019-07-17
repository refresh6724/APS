import java.util.Scanner;
 
public class Solution_D3_5215_햄버거다이어트 { // 제출일 : 2019-07-17 10:55
    //전체 점수
    static void selectSource(int num, int[] scoreArr, int[] calArr, int score, int cal, int calLimit) {
        if( num != -1) {
            cal = cal + calArr[num];
            score = score + scoreArr[num];
            if (score > maxScore) {
                maxScore = score;
            }
        }
        for(int i=1, size=scoreArr.length; num+i<size; i++) {
            if(cal + calArr[num+i] > calLimit) {
                 
            } else {
                selectSource(num+i, scoreArr, calArr, score, cal, calLimit);
            }   
        }               
    }
    static int maxScore = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int totalTestCase = Integer.parseInt(scan.next());      
        for(int test = 1; test<=totalTestCase; test++) {
            maxScore = 0;
            int numSource = scan.nextInt();
            int calLimit = scan.nextInt();
            int[] scoreArr = new int[numSource];
            int[] calArr = new int[numSource];      
            for(int i=0; i<numSource; i++) {
                scoreArr[i] = scan.nextInt();
                calArr[i] = scan.nextInt();
            }
             
            int cal = 0;
            int score = 0;
            selectSource(-1, scoreArr, calArr, score, cal, calLimit);       
             
            System.out.printf("#%d %d\n",test,maxScore);
        }       
    }
}