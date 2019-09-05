import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_16973_직사각형탈출 { // 제출일 2019-09-06 15:29

	static int answer;
	static int N;
	static int M;
	static boolean[][] lattice;
	static boolean[][] map;
	static int H;
	static int W;
	static int Sr;
	static int Sc;
	static int Fr;
	static int Fc;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt(); // 2~1000
		M = sc.nextInt(); // 2~1000
		lattice = new boolean[N][M]; // 1,1부터 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lattice[i][j] = (sc.nextInt() == 0) ? false : true;
			}
		}
		// 상하좌우 둘레 모두 true로 변경
		/*
		 * for (int i = 0; i < N+2; i++) { lattice[0][i] = true; lattice[i][0] = true;
		 * lattice[N+1][i] = true; lattice[i][N+1] = true; }
		 */
		H = sc.nextInt(); // 1 ~ N
		W = sc.nextInt(); // 1 ~ M
		Sr = sc.nextInt() - 1; // 1 ~ N-H+1 // 1,1부터
		Sc = sc.nextInt() - 1;
		Fr = sc.nextInt() - 1; // 1 ~ N-H+1
		Fc = sc.nextInt() - 1; // 1 ~ M-W+1 //

		int n = N - H + 1;
		int m = M - W + 1;
		map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = check(i, j);
			}
		}

		if (calc(0)) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean check(int i, int j) {
		for (int i2 = i; i2 < i + H; i2++) {
			for (int j2 = j; j2 < j + W; j2++) {
				if (lattice[i2][j2])
					return true;
			}
		}
		return false;
	}

	static LinkedList<Node> q;

	static class Node {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	private static boolean calc(int cnt) {
		q = new LinkedList<Node>();
		q.add(new Node(Sr, Sc, cnt));
		map[Sr][Sc] = true;
		int row = 0;
		int col = 0;
		int count = cnt;
		while (!q.isEmpty()) {
			Node node = q.poll();
			row = node.r;
			col = node.c;
			count = node.cnt;
			if (row == Fr && col == Fc) {
				answer = count;
				return true;
			}
			if (row - 1 >= 0 && !map[row - 1][col]) {
				map[row - 1][col] = true;
				q.add(new Node(row - 1, col, count + 1));
			}
			if (row + 1 < N - H + 1 && !map[row + 1][col]) {
				map[row + 1][col] = true;
				q.add(new Node(row + 1, col, count + 1));
			}
			if (col - 1 >= 0 && !map[row][col - 1]) {
				map[row][col - 1] = true;
				q.add(new Node(row, col - 1, count + 1));
			}
			if (col + 1 < M - W + 1 && !map[row][col + 1]) {
				map[row][col + 1] = true;
				q.add(new Node(row, col + 1, count + 1));
			}
		}

		return false;
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
}
