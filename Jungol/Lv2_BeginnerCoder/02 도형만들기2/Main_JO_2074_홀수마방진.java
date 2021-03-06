import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_2074_홀수마방진 { // 제출일 2021-02-27 20:02

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine()); // 2 ~ 100 사이의 홀수
		arr = new int[n][n];

		fill();

		bw.write(print());
		bw.flush();
	}

	private static void fill() {
		int row = 0;
		int col = n / 2;
		int num = 1;

		while (num <= n * n) {
			arr[row][col] = num;
			if (num % n == 0) {
				row += 1;
			} else {
				if (row == 0) {
					row = n - 1;
				} else {
					row -= 1;
				}
				if (col == 0) {
					col = n - 1;
				} else {
					col -= 1;
				}
			}
			num += 1;
		}
	}

	private static String print() {
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
