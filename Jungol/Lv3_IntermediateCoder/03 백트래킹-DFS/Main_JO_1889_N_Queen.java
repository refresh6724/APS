import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1889_N_Queen { // 제출일 2021-05-14 23:45

	static int n, ans, nr, nc;
	static int[][] map;
	static boolean[] check, rightup, rightdown;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		check = new boolean[n];
		rightup = new boolean[(n << 1) - 1];
		rightdown = new boolean[(n << 1) - 1];
		solution_dfs_1d(0);
//		map = new int[n][n];
//		solution_dfs_2d(0);
		System.out.println(ans);
	}

	/**
	 * n * n 체스판에서 n개의 queen을 놓는 방법의 수를 리턴
	 * 
	 * @param n 1 이상 13 이하의 정수
	 * @return 경우의 수
	 */
	private static void solution_dfs_1d(int row) {
		if (row == n) {
			ans++;
			return;
		}

		for (int col = 0; col < n; col++) {
			int a = row - col + n - 1;
			int b = row + col;
			if (!check[col] && !rightup[a] && !rightdown[b]) {
				check[col] = rightup[a] = rightdown[b] = true;
				solution_dfs_1d(row + 1);
				check[col] = rightup[a] = rightdown[b] = false;
			}
		}
	}

	/**
	 * n * n 체스판에서 n개의 queen을 놓는 방법의 수를 리턴
	 * 
	 * @param n 1 이상 13 이하의 정수
	 * @return 경우의 수
	 */
	private static void solution_dfs_2d(int row) {
		if (row == n) {
			ans++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (map[row][col] == 0) {
				spread(row, col);
				solution_dfs_2d(row + 1);
				despread(row, col);
			}
		}
	}

	private static void despread(int row, int col) {
		nr = row;
		nc = col;
		map[nr][nc]--;
		for (int i = 0; i < 8; i++) {
			nr = row + dr[i];
			nc = col + dc[i];
			while (true) {
				if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
					break;
				}
				map[nr][nc]--;
				nr += dr[i];
				nc += dc[i];
			}
		}

	}

	private static void spread(int row, int col) {
		nr = row;
		nc = col;
		map[nr][nc]++;
		for (int i = 0; i < 8; i++) {
			nr = row + dr[i];
			nc = col + dc[i];
			while (true) {
				if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
					break;
				}
				map[nr][nc]++;
				nr += dr[i];
				nc += dc[i];
			}
		}

	}

}