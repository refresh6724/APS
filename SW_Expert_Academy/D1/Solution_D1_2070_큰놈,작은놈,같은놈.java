import java.util.Scanner;

public class Solution_D1_2070_큰놈,작은놈,같은놈 { // 제출일 2019-07-18 15:33

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//2개의 수를 입력 받아 등호 출력
			int a= sc.nextInt();
			int b= sc.nextInt();
			if(a<b) {
				System.out.println("#"+t+" <");
			} else if (a==b) {
				System.out.println("#"+t+" =");
			} else if (a>b) {
				System.out.println("#"+t+" >");
			}						
		}
	}
}
