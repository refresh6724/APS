import java.util.Scanner;

public class Main_JO_135_형성평가6 { // 제출일 2021-01-10 23:07

	public static void main(String[] args) throws Exception {

		// 두 개의 정수를 입력받아 두 정수 사이(두 정수를 포함)에
		// 3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 첫째자리까지 출력한다.)

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		int cnt = 0;
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
				cnt++;
			}
		}

		System.out.println(String.format("sum : %d", sum));
		System.out.println(String.format("avg : %.1f", (double) sum / cnt));
	}
}