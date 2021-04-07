import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1082_화염에서탈출SLIKAR { // 제출일 2021-04-08 01:21

	// 맵은 R행 C열
	// 시작 'S' 도착 'D'
	// 비어있는 칸 '.' 불 '*' 바위 'X'
	static class Node {
		int r;
		int c;
		int step;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c, int step) {
			super();
			this.r = r;
			this.c = c;
			this.step = step;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [r=").append(r).append(", c=").append(c).append(", step=").append(step).append("]");
			return builder.toString();
		}
	}

	static int r, c, answer;
	static char[][] map;
	static Queue<Node> move, fire;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		input();
		run();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;

		map = new char[r][];
		move = new LinkedList<>();
		fire = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') { // 빈도수가 높은 것을 앞으로
					fire.add(new Node(i, j, 0));
				} else if (map[i][j] == 'S') { // 딱 한 번 나온다
					move.add(new Node(i, j, 0));
				}
			}
		}
	}

	private static void run() {
		while (!move.isEmpty() && movePhase()) {
			firePhase();
		}
	}

	private static boolean movePhase() {
		int nr = 0;
		int nc = 0;
		int m = move.size();
		for (int i = 0; i < m; i++) {
			Node node = move.poll();
			if (map[node.r][node.c] != 'S') {
				continue;
			}
			for (int j = 0; j < 4; j++) {
				nr = node.r + dr[j];
				nc = node.c + dc[j];
				if (nr < 0 || nc < 0 || nr == r || nc == c) {
					continue;
				}
				if (map[nr][nc] == '.') {
					map[nr][nc] = 'S';
					move.add(new Node(nr, nc, node.step + 1));
				} else if (map[nr][nc] == 'D') {
					answer = node.step + 1;
					move = new LinkedList<>();
					return false;
				}
			}
		}
		return true;
	}

	private static void firePhase() {
		int nr = 0;
		int nc = 0;
		int f = fire.size();
		for (int i = 0; i < f; i++) {
			Node node = fire.poll();
			for (int j = 0; j < 4; j++) {
				nr = node.r + dr[j];
				nc = node.c + dc[j];
				if (nr < 0 || nc < 0 || nr == r || nc == c) {
					continue;
				}
				if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
					map[nr][nc] = '*';
					fire.add(new Node(nr, nc, 0));
				}
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append((answer == 0) ? "impossible" : answer);
		bw.write(sb.toString());
		bw.flush();
	}

}
