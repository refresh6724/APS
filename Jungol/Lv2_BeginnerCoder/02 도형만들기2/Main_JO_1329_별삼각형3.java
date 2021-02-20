import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1329_별삼각형3 { // 제출일 2021-02-20 23:19

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		if (n % 2 == 0 || n < 1 || n > 100) {
			sb.append("INPUT ERROR!");
		} else {
			// 1 2 3 4 5 6 7 i
			// 3 2 1 0 1 2 3 j = Math.abs(i-4)
			// 0 1 2 3 2 1 0 k = 3 - j
			// 1 3 5 7 5 3 1 l = 2k + 1
			for (int i = 1; i <= n; i++) {
				int j = Math.abs(i - (n / 2 + 1));
				int k = n / 2 - j;
				for (int i2 = 0; i2 < k; i2++) {
					sb.append(' ');
				}
				for (int i2 = 0; i2 < 2 * k + 1; i2++) {
					sb.append('*');
				}
				sb.append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}
