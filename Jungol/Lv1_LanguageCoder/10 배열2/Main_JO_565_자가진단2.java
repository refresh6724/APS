import java.util.Scanner;

public class Main_JO_565_자가진단2 { // 제출일 2021-01-18 23:25

	public static void main(String[] args) {

		// 100 미만의 양의 정수들이 주어진다.
		// 입력받다가 0 이 입력되면 마지막에 입력된 0 을 제외하고
		// 그 때까지 입력된 정수의 십의 자리 숫자가 각각 몇 개인지
		// 작은 수부터 출력하는 프로그램을 작성하시오. (0개인 숫자는 출력하지 않는다.)

		Scanner sc = new Scanner(System.in);
		int[] ten = new int[10];
		int input = sc.nextInt();

		while (input != 0) {
			ten[input / 10]++;
			input = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			if (ten[i] > 0) {
				sb.append(String.format("%d : %d\n", i, ten[i]));
			}
		}
		System.out.println(sb.toString());

	}

}