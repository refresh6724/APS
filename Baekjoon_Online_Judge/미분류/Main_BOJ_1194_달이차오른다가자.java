import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_BOJ_1194_달이차오른다가자 { // 제출일 2019-12-18 13:45
	static int N;
	static int M;
	static char[][] map;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		String line = br.readLine();
		st = new StringTokenizer(line, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// debug
//		for (int i = 0; i < N; i++) {
//			System.out.println(map[i]);
//		}

		// 맵을 뒤져 0위치를 찾는다
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		}
//		System.out.println("r : " + r);
//		System.out.println("c : " + c);

		bfs(r, c);

	}

	static class MOVE {
		int row;
		int col;
		int move;
		int key;

		public MOVE(int row, int col) {
			super();
			this.row = row;
			this.col = col;			
			this.move = 0;
			this.key = 0;
		}

		public MOVE(int row, int col, int move, int key) {
			super();
			this.row = row;
			this.col = col;
			this.move = move;
			this.key = key;
		}

		@Override
		public String toString() {
			return "MOVE [row=" + row + ", col=" + col + ", move=" + move + ", key=" + key + "]";
		}
		
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 아무것도 먹지 않은 상태에서
	private static void bfs(int sr, int sc) {
		Queue<MOVE> q = new LinkedList<MOVE>();
		MOVE start = new MOVE(sr, sc);
		q.add(start);
		boolean[][][] visited = new boolean[64][N][M];
		visited[0][sr][sc] = true;
		boolean find = false;
		int row = 0, col = 0;
		int move = 0, key = 0;
		int nr = 0, nc = 0;
		while (!q.isEmpty()) {
			MOVE now = q.poll();
			//System.out.println(now);
			row = now.row;
			col = now.col;
			move = now.move;
			key = now.key;

			// 도착
			if (map[row][col] == '1') {
				find = true;
				break;
			}

			// 계속 이동
			for (int i = 0; i < 4; i++) {
				nr = row + dr[i];
				nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M 	&& !visited[key][nr][nc]) {
					visited[key][nr][nc] = true;					
					switch (map[nr][nc]) {
					case '#':
						// 벽이므로 더이상 진행하지 않는다
						break;
					// 열쇠라면 true로 바꾸고 계속 진행
					// 열쇠를 먹으면 해당 말에서 visited 배열을 초기화한다
					case 'a':
						q.add(new MOVE(nr, nc, move+1, key|(1<<0)));
						break;
					case 'b':
						q.add(new MOVE(nr, nc, move+1, key|(1<<1)));
						break;
					case 'c':
						q.add(new MOVE(nr, nc, move+1, key|(1<<2)));
						break;
					case 'd':
						q.add(new MOVE(nr, nc, move+1, key|(1<<3)));
						break;
					case 'e':
						q.add(new MOVE(nr, nc, move+1, key|(1<<4)));
						break;
					case 'f':
						q.add(new MOVE(nr, nc, move+1, key|(1<<5)));
						break;
					// 나머지는 열쇠를 가지고 있다면 진행 아니면 break
					case 'A':
						if ((key&(1<<0)) == (1<<0))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					case 'B':
						if ((key&(1<<1)) == (1<<1))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					case 'C':
						if ((key&(1<<2)) == (1<<2))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					case 'D':
						if ((key&(1<<3)) == (1<<3))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					case 'E':
						if ((key&(1<<4)) == (1<<4))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					case 'F':
						if ((key&(1<<5)) == (1<<5))
							q.add(new MOVE(nr, nc, move+1, key));
						break;
					default:
						q.add(new MOVE(nr, nc, move+1, key));
					}
				}
			}
		}
		if (find) {
			System.out.println(move);
			return;
		} else {
			System.out.println(-1);
			return;
		}
	}

}
