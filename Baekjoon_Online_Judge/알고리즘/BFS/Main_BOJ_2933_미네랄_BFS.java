import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-07 09:14

	static int R;
	static int C;
	static char[][] map;
	static int N;
	static int[] H;
	static boolean[][] visited;
	static boolean isGround;
	static boolean isChange;
	static boolean isFall;

	public static void main(String[] args) throws Exception {

		sc.init();

		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = sc.readLine().toCharArray();
		}

		N = sc.nextInt(); // 100회 이하
		H = new int[N];
		for (int i = 0; i < N; i++) {
			H[i] = R - sc.nextInt();
		}
	
		int count = -1;
		while (++count != N) {
		
			isChange = false;
			isGround = false;
			isFall = false;
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			
			int col = 0;
			if (count % 2 == 0) { // 좌
				
				// 하나 지우기
				for (col = 0; col < C; col++) {
					if (map[H[count]][col] == 'x') {
						map[H[count]][col] = '.';
						isChange = true;
						break;
					}
				}
				
				if (isChange) {
					// 위가 연결되어있지 않은 조각이 된다면
					if (!isFall && H[count] - 1 >= 0 && map[H[count] - 1][col] == 'x') {
						bfs(H[count] - 1, col);
						if (!isGround) {
							fall2(); // 한칸만 내리기
							isGround = true;
							isFall = true;
						}
					}
					// 오른쪽이 연결되어있지 않은 조각이 된다면
					if (!isFall && col + 1 < C && map[H[count]][col + 1] == 'x') {	
						isGround = false;
						bfs(H[count], col + 1);
						if (!isGround) {							
							fall2(); // 내릴 수 있을만큼 내리기
							isGround = true;
							isFall = true;							
						}
					}
					// 아래쪽이 연결되어있지 않은 조각이 된다면
					if (!isFall && H[count] + 1 < R && map[H[count] + 1][col] == 'x') { 
						isGround = false;
						bfs(H[count] + 1, col);
						if (!isGround) {
							fall2();
							isGround = true;
							isFall = true;
						}						
					}
				}
				/////////////////////////////////////////////////////////////////////////////////////////////////////
			} else { // 우
				
				// 하나 지우기
				for (col = C-1; col >= 0; col--) {
					if (map[H[count]][col] == 'x') {
						map[H[count]][col] = '.';
						isChange = true;
						break;
					}
				}
				
				if (isChange) {
					// 위가 연결되어있지 않은 조각이 된다면
					if (!isFall && H[count] - 1 >= 0 && map[H[count] - 1][col] == 'x') {
						bfs(H[count] - 1, col);
						if (!isGround) {
							fall2(); // 한칸만 내리기
							isGround = true;
							isFall = true;
						}
					}
					// 왼쪽이 연결되어있지 않은 조각이 된다면
					if (!isFall && col - 1 >= 0 && map[H[count]][col - 1] == 'x') {
						isGround = false;
						bfs(H[count], col - 1);
						if (!isGround) {							
							fall2(); // 내릴 수 있을만큼 내리기
							isGround = true;
							isFall = true;							
						}
					}
					// 아래쪽이 연결되어있지 않은 조각이 된다면
					if (!isFall && H[count] + 1 < R && map[H[count] + 1][col] == 'x') { 
						isGround = false;
						bfs(H[count] + 1, col);
						if (!isGround) {
							fall2();
							isGround = true;
							isFall = true;
						}						
					}
				}
			} // 오른쪽 종료
			
		} // while문 종료

		StringBuffer sb = new StringBuffer();
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				sb.append(map[row][col]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void fall2() {
		// 열을 돌면서 visit이 true인 곳부터 map이 x인 곳까지의 거리를 재고

		int minLength = 1001;
		int start = 0;
		int end = 0;
		for (int col = 0; col < C; col++) {
			start = -1;
			end = R;
			for (int row = 0; row < R; row++) {
				if (visited[row][col])
					start = row;
				else if (map[row][col] == 'x' && start != -1) {
					end = row;
					break;
				}
			}
			minLength = Math.min(minLength, end - start);
		}
		// 모든 visited를 minLength만큼 내린다
		for (int col = 0; col < C; col++) {
			for (int row = R - 2; row >= 0; row--) {
				if (visited[row][col]) {
					map[row][col] = '.';
					map[row + minLength - 1][col] = 'x';
				}
			}
		}

	}

	private static void fall() {
		for (int col = 0; col < C; col++) {
			for (int row = R - 2; row >= 0; row--) {
				if (visited[row][col]) {
					map[row][col] = '.';
					map[row + 1][col] = 'x';
				}
			}
		}
	}

	static LinkedList<Node> q;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs(int row, int col) {
		// 해당 지점에서 상하좌우로 x를 끝까지 쫓아간 뒤 row가 R-1인 지점이 있는지 확인한다
		visited = new boolean[R][C];
		q = new LinkedList<Node>();
		q.add(new Node(row, col));
		visited[row][col] = true;
		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;

			if (r == R - 1)
				isGround = true;
			if (r - 1 >= 0 && map[r - 1][c] == 'x' && !visited[r - 1][c]) {
				visited[r - 1][c] = true;
				q.add(new Node(r - 1, c));
			}
			if (c - 1 >= 0 && map[r][c - 1] == 'x' && !visited[r][c - 1]) {
				visited[r][c - 1] = true;
				q.add(new Node(r, c - 1));
			}
			if (r + 1 < R && map[r + 1][c] == 'x' && !visited[r + 1][c]) {
				visited[r + 1][c] = true;
				q.add(new Node(r + 1, c));
			}
			if (c + 1 < C && map[r][c + 1] == 'x' && !visited[r][c + 1]) {
				visited[r][c + 1] = true;
				q.add(new Node(r, c + 1));
			}
		}
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();

		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	/*
	//테케1
	6 6
	xxxxxx
	x....x
	x....x
	xx...x
	.x...x
	.x....
	1
	3

	//테케2
	4 4
	xxxx
	x..x
	x...
	x...
	1
	4

	//테케3
	4 4
	xxxx
	x..x
	...x
	...x
	1
	4

	//테케4
	5
	5
	xxxxx
	.x..x
	.x..x
	.x...
	.x...
	2
	5
	5

	*/
}


