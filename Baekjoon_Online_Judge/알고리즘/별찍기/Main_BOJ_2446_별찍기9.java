import java.util.Scanner;

public class Main_BOJ_2446_별찍기9 { // 제출일 2020-02-16 01:18
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = (n << 1) - 1;
		int repeat = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			repeat = max - (i << 1);
			for (int j = 0; j < repeat; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			repeat = max - (i << 1);
			for (int j = 0; j < repeat; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}