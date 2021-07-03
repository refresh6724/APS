import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2543_타일채우기 { // 제출일 2019-10-02 15:31

	static int answer;
	static int N;
	static int R;
	static int C;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt(); // 2이상 512이하 2의 제곱수
		R = sc.nextInt();
		C = sc.nextInt();

		map = new int[N][N];
		dfs(R, C, 0, 0, N, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int hr, int hc, int sr, int sc, int size, int tile) {
		if (size == 2) {
			if (hr == sr && hc == sc) { // 2사분면
				map[sr][sc] = tile;
				map[sr][sc + 1] = 1;
				map[sr + 1][sc + 1] = 1;
				map[sr + 1][sc] = 1;
			} else if (hr == sr && hc == sc + 1) { // 1사분면
				map[sr][sc] = 2;
				map[sr][sc + 1] = tile;
				map[sr + 1][sc + 1] = 2;
				map[sr + 1][sc] = 2;
			} else if (hr == sr + 1 && hc == sc + 1) { // 4사분면
				map[sr][sc] = 4;
				map[sr][sc + 1] = 4;
				map[sr + 1][sc + 1] = tile;
				map[sr + 1][sc] = 4;
			} else if (hr == sr + 1 && hc == sc) { // 3사분면
				map[sr][sc] = 3;
				map[sr][sc + 1] = 3;
				map[sr + 1][sc + 1] = 3;
				map[sr + 1][sc] = tile;
			}
		}
		// 쪼개기
		else {
			int H = cal(hr, hc, sr, sc, size);
			// System.out.println(H);
			int mr = sr + size / 2;
			int mc = sc + size / 2;
			switch (H) {
			case 1:
				dfs(hr, hc, sr, mc, size / 2, tile); // 1사분면				
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 2); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 2); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 2); // 4사분면
				break;
			case 2:
				dfs(mr - 1, mc, sr, mc, size / 2, 1);// 1사분면	
				dfs(hr, hc, sr, sc, size / 2, tile); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 1); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 1); // 4사분면
				break;
			case 3:
				dfs(mr - 1, mc, sr, mc, size / 2, 3);// 1사분면	
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 3); // 2사분면
				dfs(hr, hc, mr, sc, size / 2, tile); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 3); // 4사분면
				break;
			case 4:
				dfs(mr - 1, mc, sr, mc, size / 2, 4);// 1사분면	
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 4); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 4); // 3사분면
				dfs(hr, hc, mr, mc, size / 2, tile); // 4사분면
				break;
			}
		}

	}

	private static int cal(int hr, int hc, int sr, int sc, int size) {
		// 홀의 위치가 몇 사분면인지 반환
		if (hr >= sr + size / 2) {
			if (hc >= sc + size / 2)
				return 4;
			else
				return 3;
		} else {
			if (hc >= sc + size / 2)
				return 1;
			else
				return 2;
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
}
