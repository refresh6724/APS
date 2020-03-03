import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 { // 제출일 2020-03-03 14:01
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int R, C;
	static char[][] map;
	static int ans, max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] visited;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			HashSet<Character> set = new HashSet<>();
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					set.add(map[i][j]);
				}
			}
			ans = 1;
			max = set.size();
			// 무조건 1행 1열 출발
			visited = new int[91]; // A 65 Z 90
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void dfs(int i, int j, int size) {
		if (ans == max)
			return;
		if (visited[map[i][j]] == 1) {
			if (ans < size) {
				ans = size;
//				System.out.println(set.toString());
			}
			return;
		}

		visited[map[i][j]]++;

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
				dfs(nr, nc, size + 1);
			}
		}

		visited[map[i][j]]--;

	}

}
