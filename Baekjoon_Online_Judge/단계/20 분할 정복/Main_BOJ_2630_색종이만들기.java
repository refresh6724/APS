import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-02 13:48
	
	static int answer1;
	static int answer2;
	static int N;
	static int R;
	static int C;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer1 = 0;
		answer2 = 0;
		
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,N);
		
			
			
		System.out.println(answer1); // 0
		System.out.println(answer2); // 1
		
	}

	private static void dfs(int sr, int sc, int size) {
		// 해당 사이즈가 모두 한가지 색이라면 해당 색에 ++
		boolean oneColor = true;
		int color = map[sr][sc];
		for (int i = sr; i < sr+size; i++) {
			for (int j = sc; j < sc+size; j++) {
				if(map[i][j] != color) {
					oneColor = false;
					break;
				}
			}
			if(!oneColor) break;
		}
		
		if(oneColor) {
			if(color == 0) answer1++;
			else answer2++;
		} else {
			// 4사분면
			dfs(sr,sc,size/2);
			
			// 1사분면			
			dfs(sr+size/2,sc,size/2);
			
			// 2사분면
			dfs(sr+size/2,sc+size/2,size/2);
			
			// 3사분면
			dfs(sr,sc+size/2,size/2);			
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