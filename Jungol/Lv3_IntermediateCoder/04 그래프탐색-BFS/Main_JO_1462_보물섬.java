import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1462_보물섬 { // 제출일 2021-05-31 23:04

	static int row, col, nr, nc, ans;
	static char[][] map;
	static int[][] path, visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

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
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new char[row][];
		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}

		path = new int[row][col];
		nr = 0;
		nc = 0;
		ans = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'L') {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						nr = i + dr[k];
						nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= row || nc >= col || map[nr][nc] == 'W') {
							continue;
						}
						cnt++;
					}
					path[i][j] = cnt;
				}
			}
		}
	}

	private static void go() {
		// 모든 L에서 다른 L까지의 거리 중 가장 긴 거리 찾기
		// 길이 세 방향이나 네 방향으로 나있는 경우는 제외할 수 있다

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'L' && path[i][j] < 3) {
					bfs(i, j);
				}
			}
		}

	}

	private static void bfs(int i, int j) {

		visited = new int[row][col];
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(i, j, 1);
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (visited[node.r][node.c] == 0) {
				visited[node.r][node.c] = node.x;
				for (int k = 0; k < 4; k++) {
					nr = node.r + dr[k];
					nc = node.c + dc[k];
					if (nr < 0 || nc < 0 || nr >= row || nc >= col || map[nr][nc] == 'W' || visited[nr][nc] != 0) {
						continue;
					}
					q.add(new Node(nr, nc, node.x + 1));
				}
			}
		}
		ans = Math.max(ans, node.x - 1);

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}