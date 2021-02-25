import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1707_달팽이사각형 { // 제출일 2021-02-25 23:13

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		fill();
		sb.append(print());

		bw.write(sb.toString());
		bw.flush();
	}

	private static void fill() {
		int num = 1;
		int nr = 0;
		int nc = 0;
		int dir = 0;

		while (num <= n * n) {
			arr[nr][nc] = num++;
			switch (dir) {
			case 0:// right
				if (nc + 1 < n && arr[nr][nc + 1] == 0) {
					nc += 1;
				} else {
					nr += 1;
					dir = 1;
				}
				break;
			case 1:// down
				if (nr + 1 < n && arr[nr + 1][nc] == 0) {
					nr += 1;
				} else {
					nc -= 1;
					dir = 2;
				}

				break;
			case 2: // left
				if (nc - 1 >= 0 && arr[nr][nc - 1] == 0) {
					nc -= 1;
				} else {
					nr -= 1;
					dir = 3;
				}
				break;
			case 3: // up
				if (nr - 1 >= 0 && arr[nr - 1][nc] == 0) {
					nr -= 1;
				} else {
					nc += 1;
					dir = 0;
				}
				break;
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