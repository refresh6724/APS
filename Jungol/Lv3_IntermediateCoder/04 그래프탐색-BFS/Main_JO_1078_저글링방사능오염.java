import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1078_저글링방사능오염 { // 제출일 2021-05-30 21:58

	static int row, col, cnt, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Node> q;

	static class Node {
		int row;
		int col;
		int x;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int row, int col, int x) {
			super();
			this.row = row;
			this.col = col;
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
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			String a = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = a.charAt(j) - '0';
			}
		}
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int sr = Integer.parseInt(st.nextToken()) - 1;
		q.add(new Node(sr, sc, 3));
		cnt = 0;
		ans = 0;
	}

	private static void go() {
		Node node = null;
		int nr = 0;
		int nc = 0;
		while (!q.isEmpty()) {
			node = q.poll();
			if (map[node.row][node.col] == 1) {
				map[node.row][node.col] = node.x;

				for (int i = 0; i < 4; i++) {
					nr = node.row + dr[i];
					nc = node.col + dc[i];
					if (nr < 0 || nc < 0 || nr >= row || nc >= col || map[nr][nc] != 1) {
						continue;
					}
					q.add(new Node(nr, nc, node.x + 1));
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1) {
					cnt++;
				} else {
					ans = Math.max(ans, map[i][j]);
				}

			}
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append('\n').append(cnt).append('\n');
		bw.write(sb.toString());
		bw.flush();
	}

}