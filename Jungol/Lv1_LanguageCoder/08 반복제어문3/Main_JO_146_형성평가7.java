import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_146_형성평가7 { // 제출일 2021-01-14 22:06

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		//
		// 3
		// A B C
		// D E 0
		// F 1 2

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		char start = 'A';
		int num = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= (n - i) * 2; j++) {
				if (j % 2 == 0) {
					sb.append(start++);
				} else {
					sb.append(' ');
				}
			}
			for (int j = 0; j < (i - 1) * 2; j++) {
				if (j % 2 == 0) {
					sb.append(' ');
				} else {
					sb.append(num++);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}