import java.util.Scanner;

public class Main_BOJ_2445_별찍기8 { // 제출일 2020-02-15 23:19
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = n << 1;

		StringBuilder sb = new StringBuilder();

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= max; col++) {
				if (row >= col || max - row < col) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		for (int row = n - 1; row > 0; row--) {
			for (int col = 1; col <= max; col++) {
				if (row >= col || max - row < col) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}