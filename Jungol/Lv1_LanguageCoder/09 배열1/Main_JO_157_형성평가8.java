import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_157_형성평가8 { // 제출일 2021-01-17 18:51

	public static void main(String[] args) {

		// 100 개 이하의 정수를 입력받다가 0 이 입력되면
		// 그 때까지 입력된 정수 중 5의 배수의 개수와 합계 평균을 출력하는 프로그램을 작성하시오.
		// 평균은 소수점 이하 1자리까지 출력한다.

		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int cnt = 0;
		int input = sc.nextInt();
		while (input != 0) {
			if (input % 5 == 0) {
				cnt++;
				sum += input;
			}
			input = sc.nextInt();
		}
		System.out.println(String.format("Multiples of 5 : %d", cnt));
		System.out.println(String.format("sum : %d", sum));
		System.out.println(String.format("avg : %.1f", (double) sum / cnt));

	}

}