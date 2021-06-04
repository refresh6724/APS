import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1006_로봇 { // 제출일 2021-06-04 23:28

	static int n, m, ans;
	static int[] start, end;
	static int[] dr = { 0, 0, 1, -1 }; // 동쪽이 0, 서쪽이 1
	static int[] dc = { 1, -1, 0, 0 }; // 남쪽이 2, 북쪽이 3
	static int[][] map;
	static boolean[][][] visited;

	static class Node {
		int r;
		int c;
		int d;
		int x;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c, int d, int x) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.x = x;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [r=").append(r).append(", c=").append(c).append(", d=").append(d).append(", x=").append(x).append("]");
			return builder.toString();
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
		// 세로길이 m 가로길이 n 반대로 저장
		n = Integer.parseInt(st.nextToken()); // 각 100이하 자연수
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m]; // 0 이동 가능 1 이동 불가
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행 열 방향
		start = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			start[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		end = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			end[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		visited = new boolean[n][m][4];
	}

	// 로봇을 원하는 위치로 이동시키고 원하는 방향으로 바라보게 하는데 최소 몇 번의 명령이 필요한지 구하라
	private static void go() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start[0], start[1], start[2], 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (!visited[node.r][node.c][node.d]) {
				visited[node.r][node.c][node.d] = true;
				if (node.r == end[0] && node.c == end[1] && node.d == end[2]) {
					ans = node.x;
					return;
				}
				// 이동거리는 1~3
				int nr = node.r;
				int nc = node.c;
				for (int i = 1; i <= 3; i++) {
					nr += dr[node.d];
					nc += dc[node.d];
					if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 1) {
						break;
					}
					q.add(new Node(nr, nc, node.d, node.x + 1));
				}

				// 180도 회전 불가
//				for (int i = 0; i < 4; i++) {
//					if (!visited[node.r][node.c][i]) {
//						q.add(new Node(node.r, node.c, i, node.x + 1));
//					}
//				}
				if (node.d == 0 || node.d == 1) {
					q.add(new Node(node.r, node.c, 2, node.x + 1));
					q.add(new Node(node.r, node.c, 3, node.x + 1));
				} else {
					q.add(new Node(node.r, node.c, 0, node.x + 1));
					q.add(new Node(node.r, node.c, 1, node.x + 1));
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