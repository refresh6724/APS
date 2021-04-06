import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1695_단지번호붙이기 { // 제출일 2021-04-06 23:30

	static char[][] map;
	static int[][] visited;
	static int[] dr, dc;
	static int n, cnt;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim());
		map = new char[n][];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new int[n][n];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		cnt = 0;
	}

	private static void go() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1' && visited[i][j] == 0) {
					dfs(++cnt, i, j);
				}
			}
		}
	}

	private static void dfs(int cnt, int i, int j) {
		visited[i][j] = cnt;

		int nr = 0;
		int nc = 0;
		for (int k = 0; k < 4; k++) {
			nr = i + dr[k];
			nc = j + dc[k];
			if (nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] == '0' || visited[nr][nc] != 0) {
				continue;
			}
			dfs(cnt, nr, nc);
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[cnt + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[visited[i][j]]++;
			}
		}
		sb.append(cnt).append('\n');
		// 오름차순 출력
		arr[0] = 0;
		Arrays.parallelSort(arr);
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}