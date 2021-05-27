import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 제출일 2020-09-09 01:30

	static final int HOME = 0;
	static final int INF = 100000000;
	static int N;
	static int[][] map;
	static int[][] cost;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); // 각 행렬 성분 1백만 이하
			}
		}
		cost = new int[N][1 << N];

		int visited = 0;
		int now, cnt;
		System.out.println(go(visited | (1 << HOME), now = 0, cnt = 0));
	}

	private static int go(int visited, int now, int cnt) {

		if (cnt == N - 1) { // 이 때 visited == (1<<N)-1
			if (map[now][HOME] == 0) { // 길이 없다면
				return INF;
			} else {
				return map[now][HOME];
			}
		}

		if (cost[now][visited] == 0) { // 아직 해당 경로를 탐색하지 않았다면
			cost[now][visited] = INF; // 해당 경로의 길이를 일단 최댓값으로 두고
		} else {
			return cost[now][visited]; // 방문한 적이 있다면 그 값을 반환
		}

		for (int next = 0; next < N; next++) {
			if (map[now][next] != 0 && (visited & (1 << next)) != (1 << next)) {
				// 아직 방문하지 않은 다음 정점에 대하여
				// 기존값과 새로운 길로 갔을 때 값 중 작은 쪽을 저장한다
				cost[now][visited] = Math.min(cost[now][visited],
						map[now][next] + go(visited | (1 << next), next, cnt + 1));
			}
		}
		return cost[now][visited];
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}