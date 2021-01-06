import java.util.Scanner;

public class Main_JO_530_자가진단3 { // 제출일 2021-01-06 23:10

	public static void main(String[] args) {

		// 나이를 입력받아 20살 이상이면 "adult"라고 출력
		// 그렇지 않으면 몇 년후에 성인이 되는지를 "○ years later"라는 메시지를 출력

		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();

		if (age >= 20) {
			System.out.println("adult");
		} else {
			System.out.println(String.format("%d years later", 20 - age));
		}
	}
}