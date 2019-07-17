import java.util.Scanner;
 
public class Solution_D3_1289_원재의메모리복구하기 { // 제출일 : 2019-07-17 09:43
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        // 전체 테스트 케이스를 받는다
        int totalTestCase = Integer.parseInt(scan.next());
         
        for(int test = 1; test<=totalTestCase; test++) {
            String str = scan.next(); 
            int exchange = 0;
            if(str.startsWith("1")) {
                exchange += 1;
            }
            for(int index = 0, strLength = str.length(); index<strLength-1; index++) {
                if(str.charAt(index) != str.charAt(index+1))
                    exchange += 1;
            }
            System.out.printf("#%d %d\n",test,exchange);        
        }       
    }
}