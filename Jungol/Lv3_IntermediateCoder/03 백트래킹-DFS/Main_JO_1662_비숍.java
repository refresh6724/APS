import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 착안점  : 체스 비숍의 특징에 착안해 n을 절반으로 나누어 두번 푼다 O(2^(n*n)) => O(2^(n/2 * n/2 + 1)) => 2^26 = 67,108,864 
public class Main_JO_1662_비숍 { // 제출일 2021-05-18 20:53

	static int n, color, black, white;
	static int[][] map;
	static boolean[] rightup, rightdown;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		rightup = new boolean[n << 1];
		rightdown = new boolean[n << 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void go() {
		color = 0;
		dfs(0, 0, 0);
		color = 1;
		dfs(0, 1, 0);
	}

	private static void dfs(int row, int col, int cnt) {

		if (row == n) {
			if (color == 0) {
				black = Math.max(black, cnt);
			} else {
				white = Math.max(white, cnt);
			}
			return;
		}

		if (col >= n) {
			dfs(row + 1, (col % 2 == 0) ? 1 : 0, cnt);
			return;
		}

		if (map[row][col] == 1 && !rightup[row + col] && !rightdown[n - 1 - row + col]) {
//			map[row][col] = 2;
			rightup[row + col] = rightdown[n - 1 - row + col] = true;
			dfs(row, col + 2, cnt + 1);
//			map[row][col] = 1;
			rightup[row + col] = rightdown[n - 1 - row + col] = false;
		}
		dfs(row, col + 2, cnt);
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(black + white);
		bw.write(sb.toString());
		bw.flush();
	}

}