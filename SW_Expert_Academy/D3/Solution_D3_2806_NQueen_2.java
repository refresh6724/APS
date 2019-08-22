import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_2806_NQueen_2 { // 제출일 2019-08-22 08:59
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static boolean[] col;
	static boolean[] rPc; // row + col
	static boolean[] rMcPN; // row - col + N
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			col = new boolean[N+1]; //0은 쓰지 않는다
			rPc = new boolean[2*N+1]; //0은 쓰지 않는다
			rMcPN = new boolean[2*N]; //0은 쓰지 않는다
			answer = 0;
			go(0);
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
	}

	private static void go(int row) {
		if(row == N) {
			answer++;
			return;
		}
		for (int c = 1; c <= N; c++) {
			if(!col[c] && !rPc[row+c] && !rMcPN[row-c+N]) {
				col[c] = rPc[row+c] = rMcPN[row-c+N] = true;
				go(row+1);
				col[c] = rPc[row+c] = rMcPN[row-c+N] = false;
			}
		}
	}


	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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
