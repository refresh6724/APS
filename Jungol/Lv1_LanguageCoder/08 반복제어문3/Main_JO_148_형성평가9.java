import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_148_형성평가9 { // 제출일 2021-01-14 22:51

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		//
		// 3
		// #
		// # #
		// # # #
		//   # #
		//     #

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 상단
		for (int row = 1; row < n; row++) {
			for (int i = 1; i < row * 2; i++) {
				if (i % 2 == 0) {
					sb.append(' ');
				} else {
					sb.append('#');
				}
			}
			sb.append('\n');
		}

		// 중단
		for (int i = 1; i < n * 2; i++) {
			if (i % 2 == 0) {
				sb.append(' ');
			} else {
				sb.append('#');
			}
		}
		sb.append('\n');

		// 하단
		for (int row = n - 1; row >= 1; row--) {
			for (int i = 0; i < (n - row) * 2; i++) {
				sb.append(' ');
			}
			for (int i = row * 2 - 1; i >= 1; i--) {
				if (i % 2 == 0) {
					sb.append(' ');
				} else {
					sb.append('#');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
}