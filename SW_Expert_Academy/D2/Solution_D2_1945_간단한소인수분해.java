import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해 { 제출일 2019-12-30 21:52

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t=1; t<=T; t++) {
			int testNum = scan.nextInt();
			
			// 주어진 수를 2,3,5,7,11을 약수로하는 소인수분해를 했을때 a, b, c, d, e를 구하라
			
			int a=0, b=0, c=0, d=0, e=0;
			
			while(testNum%2==0) {
				testNum/=2;
				a++;
			}
			while(testNum%3==0) {
				testNum/=3;
				b++;
			}
			while(testNum%5==0) {
				testNum/=5;
				c++;
			}
			while(testNum%7==0) {
				testNum/=7;
				d++;
			}
			while(testNum%11==0) {
				testNum/=11;
				e++;
			}
			
			System.out.printf("#%d %d %d %d %d %d\n", t,a,b,c,d,e);
		}
			
	}

}
