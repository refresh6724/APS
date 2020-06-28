import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3260_두수의덧셈 { // 제출일 2020-06-28 23:41 21,192 kb 132 ms

	static int[] reverseSum = new int[102];

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			StringBuilder sum = new StringBuilder();

			Arrays.fill(reverseSum, -1);

			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();

			int al = A.length;
			int bl = B.length;

			int len = (al > bl) ? al : bl;
			int idx, a, b, c = 0;
			for (idx = 0; idx < len; idx++) {

				if (idx < al) {
					a = A[al - 1 - idx] - '0';
				} else {
					a = 0;
				}

				if (idx < bl) {
					b = B[bl - 1 - idx] - '0';
				} else {
					b = 0;
				}

				c += a + b;
				if (c >= 10) {
					reverseSum[idx] = c % 10;
					c = 1;
				} else {
					reverseSum[idx] = c;
					c = 0;
				}

			}

			if (c == 1) {
				reverseSum[idx] = 1;
			}

			// 만약 A가 10자리 B가 6자리라면
			// A를 뒤에서 부터 char[] 배열 끝부터 위치시키고
			// B역시 char[] 배열 끝부터 위치시키고
			// 하나씩 더해서 한칸씩 미뤄 올리는 방식
			idx = 0;
			while (reverseSum[idx] != -1) {
				sum.insert(0, reverseSum[idx++]);
			}

			answer.append('#').append(tc).append(' ').append(sum.toString()).append("\n");

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
