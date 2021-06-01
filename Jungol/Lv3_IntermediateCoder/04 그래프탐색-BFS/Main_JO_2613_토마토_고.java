import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_2613_토마토_고 { // 제출일 2021-06-01 23:27

	static int n, m, nr, nc, ans;
	static int[][] box;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Node> q;

	static class Node {
		int r;
		int c;
		int x;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c, int x) {
			super();
			this.r = r;
			this.c = c;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		nr = 0;
		nc = 0;
		ans = 0;

		q = new LinkedList<Node>();

		box = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 비어있음
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					visited[i][j] = true;
					for (int k = 0; k < 4; k++) {
						nr = i + dr[k];
						nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= n || nc >= m || box[nr][nc] != 0 || visited[nr][nc]) {
							continue;
						}
						visited[nr][nc] = true;
						q.add(new Node(nr, nc, 2));
					}
				}
			}
		}
	}

	private static void go() {
		bfs();
		count();
	}

	private static void bfs() {
		int nr = 0;
		int nc = 0;
		Node node = null;
		while (!q.isEmpty()) {
			node = q.poll();
			if (box[node.r][node.c] == 0) {
				box[node.r][node.c] = node.x;
				for (int i = 0; i < 4; i++) {
					nr = node.r + dr[i];
					nc = node.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= n || nc >= m || box[nr][nc] != 0 || visited[nr][nc]) {
						continue;
					}
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, node.x + 1));
				}
			}
		}
	}

	private static void count() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					ans = -1;
					return;
				} else if (box[i][j] != -1) {
					ans = Math.max(ans, box[i][j]);
				}
			}
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append((ans != -1) ? ans - 1 : ans);
		bw.write(sb.toString());
		bw.flush();
	}

}