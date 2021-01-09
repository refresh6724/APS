import java.util.Scanner;

public class Main_JO_134_형성평가5 { // 제출일 2021-01-09 23:12

	public static void main(String[] args) throws Exception {

		// 10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력

		Scanner sc = new Scanner(System.in);
		int odd = 0;
		int even = 0;
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (num % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println(String.format("even : %d", even));
		System.out.println(String.format("odd : %d", odd));
	}
}