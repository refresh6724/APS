import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_149_형성평가A { // 제출일 2021-01-14 23:08

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		//
		// 3
		// 1 3 5
		// 7 9 1
		// 3 5 7

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int row = 0; row < n; row++) {
			sb.append(num);
			num += 2;
			if (num == 11) {
				num -= 10;
			}
			for (int i = 1; i < n; i++) {
				sb.append(' ');
				sb.append(num);
				num += 2;
				if (num == 11) {
					num -= 10;
				}
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
}