import java.util.Scanner;

public class Main_JO_562_자가진단8 { // 제출일 2021-01-15 23:36

	public static void main(String[] args) {

		// 10개의 정수를 입력받아 배열에 저장한 후 짝수 번째 입력된 값의 합과 홀수 번째 입력된 값의 평균을 출력하는 프로그램을 작성하시오.
		// 평균은 반올림하여 소수첫째자리까지 출력한다

		int[] num = new int[10];
		int odd = 0;
		int even = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
			if (i % 2 == 0) {
				odd += num[i];
			} else {
				even += num[i];
			}
		}
		System.out.println(String.format("sum : %d", even));
		System.out.println(String.format("avg : %.1f", (double) odd / 5));

	}

}