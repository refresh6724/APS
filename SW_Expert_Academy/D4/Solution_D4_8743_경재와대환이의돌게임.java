import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_8743_경재와대환이의돌게임 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder answer;
	static long R;
	static long B;
	public static void main(String[] args) throws Exception {
		
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// 본인 턴에 어느 한 돌무덤에서 2배수를 빼고 다른쪽에 1배수를 더한다
			// 본인 턴에 2개를 가져올 수 없는 사람이 패배한다
			// KJ가 선 DH가 후
			
			R = sc.nextLong();
			B = sc.nextLong();
			
			// 2 1 짝 홀 -> 선 - 후 - 선 패		// 10 	1 DH
			// 10 0 짝 짝 -> 선 - 후 패		// 1010 0 KJ
			// 0 0 짝 짝 -> 선 패			// 0	0 DH
			
			answer = new StringBuilder();
			if(abs(R-B)<2) {
				answer.append("DH");
			} else {
				answer.append("KJ");
			}		
			
			bw.write(String.format("#%d %s\n", tc, answer));
			bw.flush();
		}
		
	}

	private static long abs(long l) {
		return R-B<0?B-R:R-B;
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
