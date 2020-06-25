import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3142_영준이와신비한뿔의숲 { // 제출일 2020-06-25 23:04 17,684 kb 102 ms

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			// n 개의 뿔과 m 마리의 짐승
			// 2x + y = n
			// x + y = m
			// x = n-m
			// y = m-x

			int n = sc.nextInt();
			int m = sc.nextInt();
			int x = n - m;
			int y = m - x;

			answer.append('#').append(tc).append(' ').append(y).append(' ').append(x).append("\n");

		}
		bw.write(answer.toString());
		bw.flush();
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
