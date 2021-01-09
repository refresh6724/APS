import java.util.Scanner;

public class Main_JO_133_형성평가4 { // 제출일 2021-01-09 23:09

	public static void main(String[] args) throws Exception {

		// 100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sc.nextInt();
		}
		System.out.println(String.format("%.2f", (double) sum / n));
	}
}