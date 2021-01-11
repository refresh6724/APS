import java.util.Scanner;

public class Main_JO_543_자가진단3 { // 제출일 2021-01-11 22:02

	public static void main(String[] args) throws Exception {

		// 하나의 정수를 입력받아 1부터 입력받은 정수까지의 짝수를 차례대로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= end; i += 2) {
			sb.append(i).append(' ');
		}
		System.out.println(sb.toString().trim());

	}
}