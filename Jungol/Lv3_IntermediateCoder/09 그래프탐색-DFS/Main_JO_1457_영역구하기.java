import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1457_영역구하기 { // 제출일 2021-05-22 23:40

	static int m, n, k;
	static int[][] map;
	static int cnt;
	static ArrayList<Integer> size;

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
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m]; // x,y 좌표계
		// 왼쪽 아래가 0,0 오른쪽 위가 n,m
		cnt = 0;
		size = new ArrayList<>();

		int x1, y1, x2, y2;
		x1 = y1 = x2 = y2 = 0;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for (int xAxis = x1; xAxis < x2; xAxis++) {
				for (int yAxis = y1; yAxis < y2; yAxis++) {
					map[xAxis][yAxis] = -1;
				}
			}
		}
	}

	private static void go() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					cnt++;
					bfs(cnt, i, j);
				}
			}
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r;
		int c;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs(int c, int i, int j) {
		int s = 0;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j));
		int nr = 0;
		int nc = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (map[node.r][node.c] == 0) {
				map[node.r][node.c] = c;
				s += 1;
				for (int k = 0; k < 4; k++) {
					nr = node.r + dr[k];
					nc = node.c + dc[k];
					if (nr < 0 || nc < 0 || nr == n || nc == m || map[nr][nc] != 0) {
						continue;
					}
					q.add(new Node(nr, nc));
				}
			}
		}

		size.add(s);
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n');
		for (int a : size.stream().sorted().toArray(Integer[]::new)) {
			sb.append(a).append(' ');
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}

}