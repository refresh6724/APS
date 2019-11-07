import java.util.Scanner;

public class Solution_D1_2029_몫과나머지출력하기 { // 제출일 2019-11-07 17:38 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("#%d %d %d\n", i, a / b, a % b);
		}
	}
}
