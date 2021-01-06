import java.util.Scanner;

public class Main_JO_532_자가진단5 { // 제출일 2021-01-06 23:14

	public static void main(String[] args) {

		// 두 개의 실수를 입력받아 모두 4.0 이상이면 "A",
		// 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력

		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		double b = scan.nextDouble();

		if (a >= 4.0 && b >= 4.0) {
			System.out.println("A");
		} else if (a >= 3.0 && b >= 3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
	}
}