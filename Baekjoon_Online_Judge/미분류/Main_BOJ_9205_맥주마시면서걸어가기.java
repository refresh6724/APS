import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-09-25 13:56

	static String answer;
	static int TC;
	static int N;
//	static int SR;
//	static int SC;
//	static int ER;
//	static int EC;
	static int[] r;
	static int[] c;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = "";
		TC = sc.nextInt();
		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt(); // 편의점 0이상 100이하
			r = new int[N + 2];
			c = new int[N + 2];

			// 상근이네 집
			r[0] = sc.nextInt(); // -32768 ≤ x, y ≤ 32767
			c[0] = sc.nextInt();
			// 편의점
			for (int j = 1; j <= N; j++) {
				r[j] = sc.nextInt();
				c[j] = sc.nextInt();
			}
			// 펜타포트 락 페스티벌 좌표
			r[N + 1] = sc.nextInt();
			c[N + 1] = sc.nextInt();

			map = new boolean[N+2][N+2];
			
			// 자기 자신을 일단 true
			for (int k = 0; k < N + 2; k++) {
				map[k][k] = true;
			}
			// 두 점 사이 거리가 1000 이하라면 true
			for (int idx = 0; idx < N + 2; idx++) {
				for (int nextIdx = 0; nextIdx < N + 2; nextIdx++) {
					if (Math.abs(r[idx] - r[nextIdx]) + Math.abs(c[idx] - c[nextIdx]) <= 1000) {
						map[idx][nextIdx] = true;
					}
				}
			}

			// 디버그
//			for (int idx = 0; idx < N + 2; idx++) {
//				System.out.println(Arrays.toString(map[idx]));
//			}

			// 플로이드-워셜 -> 연결 판별
			for (int kk = 0; kk < N + 2; kk++) {
				for (int ii = 0; ii < N + 2; ii++) {
					for (int jj = 0; jj < N + 2; jj++) {
						map[ii][jj] |= map[ii][kk] && map[kk][jj];
					}
				}
			}

			// 디버그
//			for (int idx = 0; idx < N + 2; idx++) {
//				System.out.println(Arrays.toString(map[idx]));
//			}

			if(map[0][N+1]) {
				System.out.println("happy");				
			} else {
				System.out.println("sad");		
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
}