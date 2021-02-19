import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1338_문자삼각형1 { // 제출일 2021-02-19 22:59

	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], ' ');
		}

		int row = 0;
		int col = n - 1;
		char ch = 'A';
		while (row != n - 1 || col != n - 1) {
			arr[row][col] = ch++;
			if (ch > 'Z') {
				ch = 'A';
			}

			row++;
			col--;
			if (row == n) {
				row = col + 2;
				col = n - 1;
			}
		}
		arr[row][col] = ch;

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