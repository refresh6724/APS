import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1339_문자삼각형2 { // 제출일 2021-02-19 23:11

	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n / 2 + 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], ' ');
		}

		if (n % 2 == 0 || n < 1 || n > 99) {
			sb.append("INPUT ERROR");
		} else {
			char ch = 'A';
			for (int i = n / 2, cnt = 0; i >= 0; i--, cnt += 2) {
				arr[i][i] = ch++;
				if (ch > 'Z') {
					ch = 'A';
				}
				for (int j = 1; j <= cnt; j++) {
					arr[i + j][i] = ch++;
					if (ch > 'Z') {
						ch = 'A';
					}
				}
			}

			for (int i = 0; i < n; i++) {
				sb.append(arr[i][0]);
				for (int j = 1; j <= n / 2; j++) {
					if (arr[i][j] == ' ') {
						break;
					}
					sb.append(' ').append(arr[i][j]);
				}
				sb.append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}