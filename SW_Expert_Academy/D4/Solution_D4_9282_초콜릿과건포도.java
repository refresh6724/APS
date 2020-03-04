import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9282_초콜릿과건포도 { // 제출일 2020-03-04 15:18

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static int[][] map;
	static int[][][][] memo;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n + 1][m + 1];
			memo = new int[n + 1][m + 1][n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					for (int k = 0; k <= n; k++) {
						Arrays.fill(memo[i][j][k], Integer.MAX_VALUE);
					}
					memo[i][j][1][1] = 0;
				}
			}

			answer = dfs(1, 1, n, m);

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int dfs(int r, int c, int h, int w) {

		// 재귀 종료
		if (memo[r][c][h][w] != Integer.MAX_VALUE) {
			return memo[r][c][h][w];
		}

		int sum = 0;
		for (int i = r; i < r + h; i++) {
			for (int j = c; j < c + w; j++) {
				sum += map[i][j];
			}
		}

		// 큰 조각을 위 아래로 나누는 경우
		for (int i = 1; i < h; i++) {
			int up = dfs2(r, c, i, w);
			int down = dfs2(r + i, c, h - i, w);
			int price = sum + up + down;
			memo[r][c][h][w] = Math.min(memo[r][c][h][w], price);
		}

		// 큰 조각을 좌우로 나누는 경우
		for (int i = 1; i < w; i++) {
			int left = dfs2(r, c, h, i);
			int right = dfs2(r, c + i, h, w - i);
			int price = sum + left + right;
			memo[r][c][h][w] = Math.min(memo[r][c][h][w], price);
		}

		// 다음 재귀 호출
		return memo[r][c][h][w];
	}

	private static int dfs2(int r, int c, int h, int w) {
		return (memo[r][c][h][w] == Integer.MAX_VALUE) ? dfs(r, c, h, w) : memo[r][c][h][w];
	}

}
