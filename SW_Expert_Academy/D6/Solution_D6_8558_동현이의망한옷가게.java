import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 8558 동현이의 망한 옷가게
public class Solution_D6_8558_동현이의망한옷가게 { // 제출일 2019-09-19 16:43
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;
	static int N;
	static int[] A;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 10^5 // 사람 수

			answer = 0;
			int C = 1; // 옷 한벌의 가격 = 양의 정수 C = 1
			answer += sc.nextInt() - 1;
			C = 2;
			for (int i = 1; i < N; i++) {
				int Ai = sc.nextInt();
				if (Ai < C) {
					continue;
				} else if (Ai == C) {
					C++;
				} else {
					answer += Ai / C;
					if (Ai % C == 0)
						answer--;
				}
			}
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
