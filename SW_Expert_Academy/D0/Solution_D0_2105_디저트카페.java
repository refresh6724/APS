import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 이전 216ms => 이후 122ms
public class Solution_D0_2105_디저트카페 { // 제출일 2020-03-07 21:55
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int answer;
	static int N;
	static int r, c;

	static int[][] map;

	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 시작지점 col : 1 ~ N-2
			int limit = N - 2;
			for (int row = 0; row < limit; row++) {
				for (int col = 1; col <= limit; col++) {
					r = row;
					c = col; // 시작 지점 기록
					boolean[] visited = new boolean[101];
					go(row + 1, col + 1, 1, 1, visited);
				}
			}
			if (answer == 0)
				answer = -1;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void go(int row, int col, int dir, int visit, boolean[] visited) {
		if (visited[map[row][col]])
			return;
		if (row < r)
			return;
		if (dir == 3 && visit < (answer >> 1)) {
			return;
		}
		// 시작지점에서 dfs
		// 무조건 오른쪽 부터 시계방향 p1,2,3,4
		if (visit != 1 && row == r && col == c) { // 무사히 도착했다면
			if (answer < visit) {
				answer = visit;
			}
			return;
		}

		if (dir == 1) { // 우측으로 더 갈 수 있다면 더 보내고 없으면 꺾기
			if (row + 1 < N) {
				visited[map[row][col]] = true;
				if (col + 1 < N) {
					go(row + 1, col + 1, 1, visit + 1, visited);
				}
				if (col - 1 >= 0) {
					go(row + 1, col - 1, 2, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		} else if (dir == 2) {
			if (col - 1 >= 0) {
				visited[map[row][col]] = true;
				if (row + 1 < N) {
					go(row + 1, col - 1, 2, visit + 1, visited);
				}
				if (row - 1 >= 0) {
					go(row - 1, col - 1, 3, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		} else if (dir == 3) {
			if (row - 1 >= 0) {
				visited[map[row][col]] = true;
				if (col + 1 < N) {
					go(row - 1, col + 1, 4, visit + 1, visited);
				}
				if (col - 1 >= 0) {
					go(row - 1, col - 1, 3, visit + 1, visited);
				}
				visited[map[row][col]] = false;

			}
		} else if (dir == 4) {
			if (col + 1 < N) {
				visited[map[row][col]] = true;
				if (row + 1 < N) {
					go(row + 1, col + 1, 1, visit + 1, visited);
				}
				if (row - 1 >= 0) {
					go(row - 1, col + 1, 4, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		}
	}
}
