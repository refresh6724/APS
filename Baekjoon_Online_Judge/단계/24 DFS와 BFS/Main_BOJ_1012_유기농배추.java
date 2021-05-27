import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class Main_BOJ_1012_유기농배추 { // 제출일 2020-12-19 05:21

	static boolean[][] map = new boolean[50][50];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int row, col, cnt, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		int r, c;
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			cnt = Integer.parseInt(st.nextToken());
			// 문제가 좀 애매하게 적혀있다
			// 덩어리 찾기 문제
			// 큐 생성 시간 때문에 bfs가 dfs에 비해 느리다
			for (int j = 0; j < row; j++) {
				Arrays.fill(map[j], 0, col, false);
			}
			for (int j = 0; j < cnt; j++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			ans = 0;
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (map[j][k]) {
						ans++;
						bfs(j, k);
					}
				}
			}
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static class Node {
		int row;
		int col;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		map[r][c] = false;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				r = node.row + dr[i];
				c = node.col + dc[i];
				if (r < 0 || c < 0 || r >= row || c >= col || !map[r][c]) {
					continue;
				}
				map[r][c] = false;
				q.add(new Node(r, c));
			}
		}
	}
}
