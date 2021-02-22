import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1337_달팽이삼각형 { // 제출일 2021-02-22 22:39

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], -1);
		}

		int nr = 0;
		int nc = 0;
		int k = 0;
		int dir = 0; // rightdown / left / up
		while (arr[nr][nc] == -1) {
			arr[nr][nc] = k;
			k += 1;
			k %= 10;
			if (dir == 0) { // rightdown
				if (nr + 1 < n && nc + 1 < n && arr[nr + 1][nc + 1] == -1) {
					nr += 1;
					nc += 1;
				} else if (nc - 1 >= 0 && arr[nr][nc - 1] == -1) {
					nc -= 1;
					dir = 1;
				} else {
					break;
				}
			} else if (dir == 1) { // left
				if (nc - 1 >= 0 && arr[nr][nc - 1] == -1) {
					nc -= 1;
				} else if (nr - 1 >= 0 && arr[nr - 1][nc] == -1) {
					nr -= 1;
					dir = 2;
				} else {
					break;
				}
			} else { // up
				if (nr - 1 >= 0 && arr[nr - 1][nc] == -1) {
					nr -= 1;
				} else if (nr + 1 < n && nc + 1 < n && arr[nr + 1][nc + 1] == -1) {
					nr += 1;
					nc += 1;
					dir = 0;
				} else {
					break;
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

		bw.write(sb.toString());
		bw.flush();
	}
}