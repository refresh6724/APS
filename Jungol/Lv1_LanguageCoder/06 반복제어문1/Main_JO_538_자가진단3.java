import java.util.Scanner;

public class Main_JO_538_자가진단3 { // 제출일 2021-01-07 21:09

	public static void main(String[] args) {

		// 한 개의 정수를 입력받아 양수(positive integer)인지 음수(negative number)인지 출력하는 작업을 반복
		// 0이 입력되면 종료
		Scanner sc = new Scanner(System.in);
		int num = 1;
		while (num != 0) {
			System.out.print("number? ");
			num = sc.nextInt();
			if (num > 0) {
				System.out.println("positive integer");
			} else if (num < 0) {
				System.out.println("negative integer");
			}
		}
	}
}