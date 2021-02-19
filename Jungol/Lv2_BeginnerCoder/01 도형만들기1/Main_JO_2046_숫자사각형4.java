import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2046_숫자사각형4 { // 제출일 2021-02-19 22:49

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		sb.append(func(n, m));

		bw.write(sb.toString());
		bw.flush();
	}

	private static String func(int n, int m) {
		int[][] arr = new int[n][n];
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = i + 1;
				}
			}
		} else if (m == 2) {
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < n; j++) {
						arr[i][j] = j + 1;
					}
				} else {
					for (int j = 0; j < n; j++) {
						arr[i][j] = n - j;
					}
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = (i + 1) * (j + 1);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < n; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}