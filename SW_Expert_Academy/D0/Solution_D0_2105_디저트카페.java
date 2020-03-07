import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 이전 216ms => 이후 122ms
public class Solution_D0_2105_디저트카페 { // 제출일 2020-03-07 21:55
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int answer;
	static int N;
	static int r, c;

	static int[][] map;

	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 시작지점 col : 1 ~ N-2
			int limit = N - 2;
			for (int row = 0; row < limit; row++) {
				for (int col = 1; col <= limit; col++) {
					r = row;
					c = col; // 시작 지점 기록
					boolean[] visited = new boolean[101];
					go(row + 1, col + 1, 1, 1, visited);
				}
			}
			if (answer == 0)
				answer = -1;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void go(int row, int col, int dir, int visit, boolean[] visited) {
		if (visited[map[row][col]])
			return;
		if (row < r)
			return;
		if (dir == 3 && visit < (answer >> 1)) {
			return;
		}
		// 시작지점에서 dfs
		// 무조건 오른쪽 부터 시계방향 p1,2,3,4
		if (visit != 1 && row == r && col == c) { // 무사히 도착했다면
			if (answer < visit) {
				answer = visit;
			}
			return;
		}

		if (dir == 1) { // 우측으로 더 갈 수 있다면 더 보내고 없으면 꺾기
			if (row + 1 < N) {
				visited[map[row][col]] = true;
				if (col + 1 < N) {
					go(row + 1, col + 1, 1, visit + 1, visited);
				}
				if (col - 1 >= 0) {
					go(row + 1, col - 1, 2, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		} else if (dir == 2) {
			if (col - 1 >= 0) {
				visited[map[row][col]] = true;
				if (row + 1 < N) {
					go(row + 1, col - 1, 2, visit + 1, visited);
				}
				if (row - 1 >= 0) {
					go(row - 1, col - 1, 3, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		} else if (dir == 3) {
			if (row - 1 >= 0) {
				visited[map[row][col]] = true;
				if (col + 1 < N) {
					go(row - 1, col + 1, 4, visit + 1, visited);
				}
				if (col - 1 >= 0) {
					go(row - 1, col - 1, 3, visit + 1, visited);
				}
				visited[map[row][col]] = false;

			}
		} else if (dir == 4) {
			if (col + 1 < N) {
				visited[map[row][col]] = true;
				if (row + 1 < N) {
					go(row + 1, col + 1, 1, visit + 1, visited);
				}
				if (row - 1 >= 0) {
					go(row - 1, col + 1, 4, visit + 1, visited);
				}
				visited[map[row][col]] = false;
			}
		}
	}
}


//
//
//public class Solution_D0_2105_디저트카페 { // 제출일 2019-10-30 14:06
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static int answer;
//	static int N;
//	static int r, c;
//
//	static int[][] map;
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		sc.init();
//		// 테스트케이스
//		int TC = sc.nextInt();
//		for (int tc = 1; tc <= TC; tc++) {
//			answer = -1;
//			N = sc.nextInt();
//			map = new int[N][N];
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					map[i][j] = sc.nextInt();
//				}
//			}
//
//			// 입력 종료
//
//			// 시작지점 col : 1 ~ N-2
//			int limit = N - 3;
//
//			for (int row = 0; row <= limit; row++) {
//				for (int col = 1; col <= N - 2; col++) {
//					r = row;
//					c = col; // 시작 지점 기록
//					// boolean[] visited = new boolean[101]; // 디저트 개수
//					int[] visited = new int[101];
//					// visited[map[row][col]] = 0;
//					go(row + 1, col + 1, 1, 1, visited);
//					// visited[map[row][col]] = 0;
//				}
//			}
//
//			bw.write(String.format("#%d %d\n", tc, answer));
//			bw.flush();
//		}
//
//	}
//
//	private static void go(int row, int col, int dir, int visit, int[] visited) {
//		if (visited[map[row][col]] != 0)
//			return;
//		if (row < r)
//			return;
//		// 시작지점에서 dfs
//		// 무조건 오른쪽 부터 시계방향 p1,2,3,4
//		if (visit != 1 && row == r && col == c) { // 무사히 도착했다면
//			// answer = (answer>visit)?answer:visit;
//			if (answer < visit) {
//				answer = visit;
//				// System.out.println(String.format("r:%d c:%d", r,c));
////				for (int i = 0; i < 10; i++) {
////					for (int j = 0; j < 10; j++) {
////						System.out.printf("%d\t ", visited[i*10+j]);
////					}
////					System.out.println();
////				}
////				System.out.println();
//			}
//
//			return;
//		}
//
//		if (dir == 1) { // 우측으로 더 갈 수 있다면 더 보내고 없으면 꺾기
//			if (row + 1 < N) {
//				visited[map[row][col]] = visit;
//				if (col + 1 < N) {
//					go(row + 1, col + 1, 1, visit + 1, visited);
////					visited[map[row][col]] = false;
//				}
//				if (col - 1 >= 0) {
//					// visited[map[row][col]] = true;
//					go(row + 1, col - 1, 2, visit + 1, visited);
//				}
//				visited[map[row][col]] = 0;
//			}
//		} else if (dir == 2) {
//			if (col - 1 >= 0) {
//
//				visited[map[row][col]] = visit;
//				if (row + 1 < N) {
//					go(row + 1, col - 1, 2, visit + 1, visited);
////					visited[map[row][col]] = false;
//				}
//				if (row - 1 >= 0) {
//					// visited[map[row][col]] = true;
//					go(row - 1, col - 1, 3, visit + 1, visited);
//				}
//				visited[map[row][col]] = 0;
//			}
//		} else if (dir == 3) {
//			if (row - 1 >= 0) {
//				visited[map[row][col]] = visit;
//				if (col + 1 < N) {
//					go(row - 1, col + 1, 4, visit + 1, visited);
////					visited[map[row][col]] = false;
//				}
//				if (col - 1 >= 0) {
//					// visited[map[row][col]] = true;
//					go(row - 1, col - 1, 3, visit + 1, visited);
//				}
//				visited[map[row][col]] = 0;
//
//			}
//		} else if (dir == 4) {
//			if (col + 1 < N) {
//				visited[map[row][col]] = visit;
//				if (row + 1 < N) {
//					go(row + 1, col + 1, 1, visit + 1, visited);
////					visited[map[row][col]] = false;
//				}
//				if (row - 1 >= 0) {
//					// visited[map[row][col]] = true;
//					go(row - 1, col + 1, 4, visit + 1, visited);
//				}
//				visited[map[row][col]] = 0;
//			}
//		}
//
//	}
//
//	static class sc {
//		private static BufferedReader br;
//		private static StringTokenizer st;
//
//		static void init() {
//			br = new BufferedReader(new InputStreamReader(System.in));
//			st = new StringTokenizer(" ");
//		}
//
//		static String readLine() {
//			try {
//				return br.readLine();
//			} catch (IOException e) {
//			}
//			return null;
//		}
//
//		static String next() {
//			while (!st.hasMoreTokens()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				} catch (IOException e) {
//				}
//			}
//			return st.nextToken();
//		}
//
//		static int nextInt() {
//			return Integer.parseInt(next());
//		}
//
//		static long nextLong() {
//			return Long.parseLong(next());
//		}
//	}
//}

