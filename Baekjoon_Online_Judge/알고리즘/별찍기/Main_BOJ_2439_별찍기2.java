import java.util.Scanner;

public class Main_BOJ_2439_별찍기2 { // 제출일 2020-02-08 23:46
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				sb.append(" ");
			}
			for (int j = n - 1 - i; j < n; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}