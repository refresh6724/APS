import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_8822_홀수중간값피라미드1 { // 제출일 2019-10-31 13:20
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();

			answer = 1;
			if (X == 1 || X == 2 * N - 1)
				answer = 0;

			bw.write(String.format("#%d %d\n", tc, answer));
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
