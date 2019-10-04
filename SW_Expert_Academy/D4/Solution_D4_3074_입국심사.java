import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 3074 입국심사
public class Solution { // 제출일 2019-10-04 15:09

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;
	static long M; // 사람수 10억 이하
	static int N; // 심사대수 10만 이하
	static int[] tk; // 심사에 걸리는 시간 10억 이하
	static long s;
	static long e;

	public static void main(String[] args) throws Exception {
		// 1차 : HashMap 2개 - 시간초과
		// 2차 : PQ 3개 - 시간초과
		// 3차 : BS
		sc.init();
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 심사대 수
			M = sc.nextInt(); // 사람 수
			s = 0;
			e = M;
			tk = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				tk[i] = sc.nextInt(); // 각 심사대의 처리시간
				max = Math.max(max, tk[i]);
			}

			e = M * max;
			
			while (s <= e) {
				long sum = 0;
				long mid = (s + e) / 2;
				for (int i = 0; i < N; i++) {
					sum += mid / tk[i];
				}

				if (sum >= M) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}

			bw.write(String.format("#%d %d\n", tc, e + 1));
			bw.flush();
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
