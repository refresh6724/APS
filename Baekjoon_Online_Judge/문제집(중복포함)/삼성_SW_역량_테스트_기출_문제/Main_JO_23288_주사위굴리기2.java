import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_23288_주사위굴리기2 { // 제출일 2021-11-03 23:42

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Map game = new Map(n, m, map);
		while (k-- > 0) {
			game.nextTurn();
		}
		System.out.println(game.score);

	}

	static int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dc = { 1, 0, -1, 0 }; // 우 하 좌 상

	static class Map {
		int n;
		int m;
		int[][] map; // 1,1 ~ n,m 좌표 사용
		int[][] canMove;
		int[][] visited;
		int idx;
		int r;
		int c;
		Dice dice;
		int dir;
		int score;

		public Map() {
			// TODO Auto-generated constructor stub
		}

		public Map(int n, int m, int[][] map) {
			super();
			this.n = n;
			this.m = m;
			this.map = map;
			this.canMove = new int[n][m];
			this.visited = new int[n][m];
			this.idx = 0;
			move();
			this.r = 0;
			this.c = 0;
			this.dice = new Dice(1, 6, 4, 3, 2, 5);
			this.dir = 0;
			this.score = 0;
		}

		private void move() {
			for (int i = 0; i < this.n; i++) {
				for (int j = 0; j < this.m; j++) {
					if (canMove[i][j] == 0) {
						bfs(i, j);
					}
				}
			}
		}

		private void bfs(int i, int j) {
			this.idx += 1;
			int num = map[i][j];
			int cnt = 0;

			// visited
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { i, j });
			while (!q.isEmpty()) {
				int qr = q.peek()[0];
				int qc = q.poll()[1];
				if (visited[qr][qc] < this.idx) {
					visited[qr][qc] = this.idx;
					cnt += 1;
					for (int k = 0; k < 4; k++) {
						int nr = qr + dr[k];
						int nc = qc + dc[k];
						if (nr < 0 || nc < 0 || nr == this.n || nc == this.m || map[nr][nc] != num || visited[nr][nc] == this.idx) {
							continue;
						}
						q.add(new int[] { nr, nc });
					}
				}
			}

			// canMove
			q.add(new int[] { i, j });
			while (!q.isEmpty()) {
				int qr = q.peek()[0];
				int qc = q.poll()[1];
				if (canMove[qr][qc] == 0) {
					canMove[qr][qc] = cnt;
					for (int k = 0; k < 4; k++) {
						int nr = qr + dr[k];
						int nc = qc + dc[k];
						if (nr < 0 || nc < 0 || nr == this.n || nc == this.m || map[nr][nc] != num || canMove[nr][nc] != 0) {
							continue;
						}
						q.add(new int[] { nr, nc });
					}
				}
			}
		}

		public void nextTurn() {
			int nr = this.r + dr[dir];
			int nc = this.c + dc[dir];
			if (nr < 0 || nc < 0 || nr == this.n || nc == this.m) {
				dir += 2;
				dir %= 4;
				nr = this.r + dr[dir];
				nc = this.c + dc[dir];
			}
			this.r = nr;
			this.c = nc;

			switch (dir) {
			case 0:
				dice.turnRight();
				break;
			case 1:
				dice.turnDown();
				break;
			case 2:
				dice.turnLeft();
				break;
			case 3:
				dice.turnUp();
				break;
			}

			scoring();

		}

		private void scoring() {
			int a = dice.bottom;
			int b = this.map[this.r][this.c];

			if (a > b) {
				this.dir += 1;
				this.dir %= 4;
			} else if (a < b) {
				this.dir += 3;
				this.dir %= 4;
			}

			this.score += b * this.canMove[this.r][this.c];
		}

	}

	static class Dice {
		int top;
		int bottom;
		int left;
		int right;
		int up;
		int down;

		public Dice() {
			// TODO Auto-generated constructor stub
		}

		public Dice(int top, int bottom, int left, int right, int up, int down) {
			super();
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
		}

		public void turnRight() {
			this.bottom = this.right;
			this.right = this.top;
			this.top = this.left;
			this.left = 7 - this.right;
		}

		public void turnDown() {
			this.bottom = this.down;
			this.down = this.top;
			this.top = this.up;
			this.up = 7 - this.down;
		}

		public void turnLeft() {
			this.bottom = this.left;
			this.left = this.top;
			this.top = this.right;
			this.right = 7 - this.left;
		}

		public void turnUp() {
			this.bottom = this.up;
			this.up = this.top;
			this.top = this.down;
			this.down = 7 - this.up;
		}

	}

}