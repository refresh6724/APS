import java.util.Scanner;

public class Main_JO_561_자가진단7 { // 제출일 2021-01-15 23:33

	public static void main(String[] args) {

		// 10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오.
		// (입력되는 정수의 범위는 1이상 10,000 미만이다. 만약 해당하는 수가 없을 때에는 100 을 출력한다.)

		int min = 10001;
		int max = 0;

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (num < 100) {
				max = Math.max(max, num);
			} else {
				min = Math.min(min, num);
			}
		}
		System.out.println(String.format("%d %d", (max == 0) ? 100 : max, (min == 10001) ? 100 : min));
	}

}