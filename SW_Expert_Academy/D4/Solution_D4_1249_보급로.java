import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution { // 제출일 2019-10-07 17:22 
	static class Coord implements Comparable<Coord> {
		int r;
		int c;
		int time;

		public Coord(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Coord o) {
			// TODO Auto-generated method stub
			return this.time - o.time; // 오름차순
		}
	}

	static int N;
	static int inf = 10 * 100 * 100;
	static int[][] map;
	static int[][] dp;
	static PriorityQueue<Coord> pq;
	static Coord coord;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		testcase: for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j] - 48;
					dp[i][j] = inf;
				}
			}
			dp[0][0] = 0;
			pq = new PriorityQueue<Coord>();
			pq.add(new Coord(0, 0, 0));
			while (!pq.isEmpty()) {
				coord = pq.poll();
				int r = coord.r;
				int c = coord.c;
				int time = coord.time;
				if (r == N - 1 && c == N - 1) { // 가장 먼저 도착지점에 도착하는 순간 가장 짧은 경로이다
					System.out.println(String.format("#%d %d", tc, time));
					continue testcase;
				}
				if (dp[r][c] < time)
					continue;
				if (r - 1 >= 0 && dp[r - 1][c] > dp[r][c] + map[r - 1][c]) {
					dp[r - 1][c] = dp[r][c] + map[r - 1][c];
					pq.add(new Coord(r - 1, c, time + map[r - 1][c]));
				}
				if (r + 1 < N && dp[r + 1][c] > dp[r][c] + map[r + 1][c]) {
					dp[r + 1][c] = dp[r][c] + map[r + 1][c];
					pq.add(new Coord(r + 1, c, time + map[r + 1][c]));
				}
				if (c - 1 >= 0 && dp[r][c - 1] > dp[r][c] + map[r][c - 1]) {
					dp[r][c - 1] = dp[r][c] + map[r][c - 1];
					pq.add(new Coord(r, c - 1, time + map[r][c - 1]));
				}
				if (c + 1 < N && dp[r][c + 1] > dp[r][c] + map[r][c + 1]) {
					dp[r][c + 1] = dp[r][c] + map[r][c + 1];
					pq.add(new Coord(r, c + 1, time + map[r][c + 1]));
				}
			}
		}
	}
}
