import java.util.Scanner;

public class Main_JO_535_자가진단8 { // 제출일 2021-01-06 23:26

	public static void main(String[] args) {

		// 4.5 이하의 평점을 입력받아 그 값에 따라 다음과 같이 출력
		// 단 입력은 0이상 4.5 이하이다.
		// 4.0 이상 : "scholarship"
		// 3.0 이상 : "next semester"
		// 2.0 이상 : "seasonal semester"
		// 2.0 미만 : "retake"

		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();

		switch ((int) a) {
		case 4:
			System.out.println("scholarship");
			break;
		case 3:
			System.out.println("next semester");
			break;
		case 2:
			System.out.println("seasonal semester");
			break;
		default:
			System.out.println("retake");
			break;
		}

	}
}