import java.util.Scanner;

public class Main_JO_528_자가진단1 { // 제출일 2021-01-06 23:04

	public static void main(String[] args) {

		// 정수를 입력받아 첫 줄에 입력 받은 숫자를 출력하고
		// 둘째 줄에 음수이면 “minus” 라고 출력하는 프로그램을 작성하시오.
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println(a);
		if (a < 0) {
			System.out.println("minus");
		}
	}
}