import java.util.Scanner;

public class Main_JO_544_자가진단4 { // 제출일 2021-01-11 22:02

	public static void main(String[] args) throws Exception {

		// 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int sum = 0;
		for (int i = start; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

	}
}