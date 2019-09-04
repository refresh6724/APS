import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Sub {
	int r;
	int c;
	int rc;

	public Sub(int r, int c) {
		this.r = r;
		this.c = c;
		this.rc = r * c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public int getRc() {
		return rc;
	}

	@Override
	public String toString() {
		return String.format(" %d %d", this.r, this.c);
	}
}

public class Solution_D4_1258_행렬찾기 { // 제출일 2019-09-04 10:21
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Sub> list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			sb = new StringBuilder();
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<Sub>(N >> 1);
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						paint(i, j);
					}
				}
			}

			list.sort(Comparator.comparing(Sub::getRc).thenComparing(Sub::getR));
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i).toString());
			}
			bw.write(String.format("#%d %d%s\n", tc, list.size(), sb.toString()));
			bw.flush();
		}

	}

	private static void paint(int i, int j) {

		int r = 0;
		int c = 0;
		// i,j 부터 0을 만나거나 행렬의 끝을 만날때까지
		for (int row = i; row < N; row++) {
			if (map[row][j] != 0) {
				r++;
				
			} else break;
			
		}
		for (int col = j; col < N; col++) {
			if (map[i][col] != 0) {
				c++;
			
			} else break;
		}
		for (int i2 = i; i2 < i + r; i2++) {
			for (int j2 = j; j2 < j + c; j2++) {
				visited[i2][j2] = true;
			}
		}
		list.add(new Sub(r, c));
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
