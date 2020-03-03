import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_bfs { // 제출일 2020-03-03 15:41
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int sx, sy, fx, fy;
	static int[] lrr = { 0, 0 };
	static int[] lrc = { -1, 1 };
	static int[] udr = { -1, 1 };
	static int[] udc = { 0, 0 };
	static int ans;
	static boolean[][][] visited;

	static class Point {

		int i;
		int j;
		int sth;
		boolean dir;

		public Point(int i, int j, int sth, boolean dir) {
			super();
			this.i = i;
			this.j = j;
			this.sth = sth;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()) + 100;
			sy = Integer.parseInt(st.nextToken()) + 100;
			fx = Integer.parseInt(st.nextToken()) + 100;
			fy = Integer.parseInt(st.nextToken()) + 100;

			ans = 0;

			// 가장 빨리 도착하는 경우의 수
			bfs();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx, sy, 0, true));
		q.add(new Point(sx, sy, 0, false));

		visited = new boolean[201][201][2];
		visited[sx][sy][0] = true;
		visited[sx][sy][1] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.i == fx && p.j == fy) {
				ans = p.sth;
				break;
			}

			if (p.dir) { // 현재 = 좌우
				for (int i = 0; i < 2; i++) { // 다음 = 상하
					int nr = p.i + udr[i];
					int nc = p.j + udc[i];
					if (nr >= 0 && nc >= 0 && nr < 201 & nc < 201 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.sth + 1, false));
					}
				}
			} else {
				for (int i = 0; i < 2; i++) {
					int nr = p.i + lrr[i];
					int nc = p.j + lrc[i];
					if (nr >= 0 && nc >= 0 && nr < 201 & nc < 201 && !visited[nr][nc][0]) {
						visited[nr][nc][0] = true;
						q.add(new Point(nr, nc, p.sth + 1, true));
					}
				}
			}

		}

	}

}
