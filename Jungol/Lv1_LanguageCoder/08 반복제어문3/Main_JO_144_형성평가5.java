import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_144_형성평가5 { // 제출일 2021-01-13 23:26

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		// 주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.
		// 3
		//     *
		//   ***
		// *****
		// 4 1
		// 2 3
		// 0 5

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i) * 2; j++) {
				sb.append(' ');
			}
			for (int j = 0; j < (i * 2) - 1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}