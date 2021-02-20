import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1719_별삼각형2 { // 제출일 2021-02-20 23:13

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n % 2 == 0 || n < 1 || n > 100 || m < 1 || m > 4) {
			sb.append("INPUT ERROR!");
		} else {
			sb.append(star(n, m));
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static String star(int n, int m) {
		StringBuilder sb = new StringBuilder();
		switch (m) {
		case 1:
			// 1 2 3 2 1
			for (int i = 1; i <= n / 2; i++) {
				for (int j = 0; j < i; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			for (int i = n / 2 + 1; i <= n; i++) {
				for (int j = 0; j < n + 1 - i; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		case 2:
			// 2 1 0 1 2
			// 1 2 3 2 1
			for (int i = 1; i <= n; i++) {
				int space = Math.abs(i - (n / 2 + 1));
				for (int j = 0; j < space; j++) {
					sb.append(' ');
				}
				for (int j = 0; j < (n / 2 + 1) - space; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		case 3:
			// 1 2 3 4 5 i
			// 2 1 0 1 2 j = Math.abs(i-3)
			// 0 1 2 1 0 k = 2 - j
			// 2 1 0 1 2
			// 5 3 1 3 5 l = 2j + 1
			for (int i = 1; i <= n; i++) {
				int j = Math.abs(i - (n / 2 + 1));
				for (int j2 = 0; j2 < n / 2 - j; j2++) {
					sb.append(' ');
				}
				for (int j2 = 0; j2 < 2 * j + 1; j2++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		case 4:
			// 1 2 3 4 5 i
			// 0 1 2 2 2 j = Math.min(i-1, n/2)
			// 3 2 1 2 3 k = Math.abs(i - (n/2+1)) + 1
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < Math.min(i - 1, n / 2); j++) {
					sb.append(' ');
				}
				for (int j = 0; j < Math.abs(i - (n / 2 + 1)) + 1; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		}
		return sb.toString();
	}

}
