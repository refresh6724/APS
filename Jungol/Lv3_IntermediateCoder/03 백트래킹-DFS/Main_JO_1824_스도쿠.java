import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1824_스도쿠 { // 제출일 2021-05-17 23:25

	static int n;
	static int[][] map;
	static boolean[][] garo, sero, sect;
	static boolean find;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = 9;
		map = new int[n][n];
		garo = new boolean[n][n + 1];
		sero = new boolean[n][n + 1];
		sect = new boolean[n][n + 1];
		find = false;

		int a = 0;
		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++) {
				a = Integer.parseInt(st.nextToken());
				map[row][col] = a;
				garo[row][a] = true;
			}
		}
		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {
				sero[col][map[row][col]] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int s = (i / 3) * 3 + (j / 3);
				sect[s][map[i][j]] = true;
			}
		}
	}

	private static void go() {
		dfs(0, 0);
	}

	private static void dfs(int row, int col) {
		if (find) {
			return;
		}
		if (row == n) {
			find = true;
			return;
		}
		if (col == n) {
			dfs(row + 1, 0);
			return;
		}

		if (map[row][col] != 0) {
			dfs(row, col + 1);
			return;
		} else {
			int idx = (row / 3) * 3 + (col / 3);
			for (int num = 1; num <= n; num++) {
				if (!garo[row][num] && !sero[col][num] && !sect[idx][num]) {
					garo[row][num] = sero[col][num] = sect[idx][num] = true;
					map[row][col] = num;
					dfs(row, col + 1);
					if (find) {
						return;
					}
					map[row][col] = 0;
					garo[row][num] = sero[col][num] = sect[idx][num] = false;
				}
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(map[i][0]);
			for (int j = 1; j < n; j++) {
				sb.append(' ').append(map[i][j]);
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}