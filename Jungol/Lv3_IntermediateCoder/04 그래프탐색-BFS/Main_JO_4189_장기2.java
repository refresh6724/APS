import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_JO_4189_장기2 { // 제출일 2021-05-29 20:01

	static int n, m, r, c, s, k, ans;
	static boolean[][] visited;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

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

		// 장기판 제일 왼쪽 위 좌표 1,1
		// 계산을 편하게 하기 위해 입력받은 값에서 전부 1을 뺀다

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 장기판 행의 수 1 이상, 1000 이하
		m = Integer.parseInt(st.nextToken()); // 장기판 열의 수 1 이상, 1000 이하

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1; // 말이 있는 위치의 행
		c = Integer.parseInt(st.nextToken()) - 1; // 말이 있는 위치의 열
		s = Integer.parseInt(st.nextToken()) - 1; // 졸이 있는 위치의 행
		k = Integer.parseInt(st.nextToken()) - 1; // 졸이 있는 위치의 열

		visited = new boolean[n][m];
		ans = 0;
	}

	private static void go() {
		// r,c에서 시작해 s,k 까지의 최소 이동 횟수
		// 이게 왜 백트래킹 dfs로 분류되었을까 아무리 봐도 bfs인데

		LinkedList<Node> q = new LinkedList<>();
		Node node = new Node(r, c, 0);
		q.add(node);
		int nr = 0;
		int nc = 0;
		while (!q.isEmpty()) {
			node = q.pollFirst();
			if (!visited[node.r][node.c]) {
				visited[node.r][node.c] = true;
				if (node.r == s && node.c == k) {
					ans = node.x;
					return;
				}

				for (int i = 0; i < 8; i++) {
					nr = node.r + dr[i];
					nc = node.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) {
						continue;
					}
					q.add(new Node(nr, nc, node.x + 1));
				}
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}