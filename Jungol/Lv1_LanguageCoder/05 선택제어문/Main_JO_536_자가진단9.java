import java.util.Scanner;

public class Main_JO_536_자가진단9 { // 제출일 2021-01-06 23:28

	public static void main(String[] args) {

		// 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		System.out.println((a < b && a < c) ? a : (b < c) ? b : c);

	}
}