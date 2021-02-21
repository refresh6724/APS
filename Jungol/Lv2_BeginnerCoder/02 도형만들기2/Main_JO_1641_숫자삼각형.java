import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1641_숫자삼각형 { // 제출일 2021-02-21 21:40

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n % 2 == 0 || n < 1 || n > 100 || m < 1 || m > 3) {
			sb.append("INPUT ERROR!");
		} else {
			sb.append(triangle(n, m));
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static String triangle(int n, int m) {
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], -1);
		}
		int num = 1;
		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					// right
					for (int j = 0; j < i + 1; j++) {
						arr[i][j] = num++;
					}
				} else {
					// left
					for (int j = i; j >= 0; j--) {
						arr[i][j] = num++;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				sb.append(arr[i][0]);
				for (int j = 1; j < n; j++) {
					if (arr[i][j] == -1) {
						break;
					}
					sb.append(' ').append(arr[i][j]);
				}
				sb.append('\n');
			}
			break;
		case 2:
			// 0 9개 1 7개 2 5개 3 3개 4 1개
			// 0 001 00002 00003 0000004
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i * 2; j++) {
					sb.append(' ');
				}
				sb.append(i);
				for (int j = 0; j < 2 * (n - i - 1); j++) {
					sb.append(' ').append(i);
				}
				sb.append('\n');
			}
			break;
		case 3:
			// 1 2 3 4 5
			// 2 1 0 1 2
			// 1 2 3 2 1
			for (int row = 1; row <= n; row++) {
				for (int col = 1; col <= (n / 2 + 1) - Math.abs(row - (n / 2 + 1)); col++) {
					arr[row - 1][col - 1] = col;
				}
			}
			for (int i = 0; i < n; i++) {
				sb.append(arr[i][0]);
				for (int j = 1; j < n; j++) {
					if (arr[i][j] == -1) {
						break;
					}
					sb.append(' ').append(arr[i][j]);
				}
				sb.append('\n');
			}
			break;
		}
		return sb.toString();
	}

}
