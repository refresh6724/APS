import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1523_별삼각형1 { // 제출일 2021-02-20 22:16

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n < 1 || n > 100 || m < 1 || m > 3) {
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
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		case 2:
			for (int i = n; i >= 1; i--) {
				for (int j = 0; j < i; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		case 3:
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < n - i; j++) {
					sb.append(' ');
				}
				for (int j = 0; j < 2 * i - 1; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			break;
		}
		return sb.toString();
	}

}
