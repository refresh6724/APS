import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2071_파스칼삼각형 { // 제출일 2021-02-24 23:32

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 30이하 자연수
		int m = Integer.parseInt(st.nextToken()); // 3종류

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}

		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				sb.append(arr[i][0]);
				for (int j = 1; j < n; j++) {
					if (arr[i][j] == 0) {
						break;
					}
					sb.append(' ').append(arr[i][j]);
				}
				sb.append('\n');
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					sb.append(' ');
				}
				sb.append(arr[n - 1 - i][0]);
				for (int j = 1; j < n; j++) {
					if (arr[n - 1 - i][j] == 0) {
						break;
					}
					sb.append(' ').append(arr[n - 1 - i][j]);
				}
				sb.append('\n');
			}
			break;
		case 3:
			for (int col = n - 1; col >= 0; col--) {
				sb.append(arr[n - 1][col]);
				for (int row = n - 2; row >= 0; row--) {
					if (arr[row][col] == 0) {
						break;
					}
					sb.append(' ').append(arr[row][col]);
				}
				sb.append('\n');
			}
			break;
		}

		bw.write(sb.toString());
		bw.flush();
	}

}