import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_1495_대각선지그재그 { // 제출일 2021-02-27 20:15

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine()); // 1 ~ 100 사이의 정수
		arr = new int[n][n];

		fill();

		bw.write(print());
		bw.flush();
	}

	private static void fill() {
		int row = 0;
		int col = 0;
		int dir = 0; // 0 : 좌하 1 : 우상
		int num = 1;

		// 좌하 방향으로 시작 1-1 좌하 1-2 하 1-3 우
		// 우상 방향으로 시작 2-1 우상 2-2 우 1-4 하

		while (num <= n * n) {
			arr[row][col] = num++;
			if (dir == 0) {
				if (row + 1 < n && col - 1 >= 0) {
					row += 1;
					col -= 1;
				} else if (row + 1 < n) {
					row += 1;
					dir = 1;
				} else {
					col += 1;
					dir = 1;
				}
			} else {
				if (row - 1 >= 0 && col + 1 < n) {
					row -= 1;
					col += 1;
				} else if (col + 1 < n) {
					col += 1;
					dir = 0;
				} else {
					row += 1;
					dir = 0;
				}
			}
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
