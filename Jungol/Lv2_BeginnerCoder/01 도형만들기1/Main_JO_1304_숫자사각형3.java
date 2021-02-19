import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1304_숫자사각형3 { // 제출일 2021-02-19 22:44

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int a = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[j][i] = a++;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < n; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}