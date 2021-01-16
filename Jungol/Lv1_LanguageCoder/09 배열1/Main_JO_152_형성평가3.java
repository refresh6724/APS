import java.util.Scanner;

public class Main_JO_152_형성평가3 { // 제출일 2021-01-16 23:51

	public static void main(String[] args) {

		// 10개의 정수를 입력받아 홀수 번째 입력받은 정수의 합과 짝수 번째 입력받은 정수의 합을 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int odd = 0;
		int even = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) {
				even += sc.nextInt();
			} else {
				odd += sc.nextInt();
			}
		}
		System.out.println(String.format("odd : %d", odd));
		System.out.println(String.format("even : %d", even));
	}

}