import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_545_자가진단5 { // 제출일 2021-01-11 22:03

	public static void main(String[] args) throws Exception {

		// 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int three = 0;
		int five = 0;

		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num % 3 == 0) {
				three++;
			}
			if (num % 5 == 0) {
				five++;
			}
		}
		System.out.println(String.format("Multiples of 3 : %d", three));
		System.out.println(String.format("Multiples of 5 : %d", five));

	}
}