import java.util.Scanner;

public class Main_JO_634_자가진단2 { // 제출일 2021-01-12 22:45

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아서 n줄만큼 다음과 같이 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());

	}
}