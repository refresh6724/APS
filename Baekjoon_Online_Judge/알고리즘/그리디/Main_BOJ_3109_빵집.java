import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집 { // 제출일 2019-09-05 10:58
	
	static int answer;
	static int N;
	static int R;
	static int C;
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		R = sc.nextInt(); // 10000 이하 자연수
		C = sc.nextInt(); // 5 ~ 500 자연수
		// .은 빈칸 x는 건물 첫열과 마지막열은 항상 비어있다.
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] arr = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if(arr[j] == 'x') map[i][j] = true;
				// 아닐 경우 false 지나갈 수 있음
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(dfs(i,0)) answer++;
		}
			
			
		System.out.println(answer);
	}

	private static boolean dfs(int row, int col) {
		if(col == C-1) {
			if(!map[row][col]) {
				map[row][col] = true;
				return true;
			}
			else return false;
		}
		if(map[row][col]) return false;
		else map[row][col] = true;
		
		if(row-1>=0 && dfs(row-1, col+1)) {
			return true;
		} else if(dfs(row, col+1)) {
			return true;
		} else if(row + 1 <R && dfs(row+1, col+1)) {
			return true;
		} else return false;		
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
