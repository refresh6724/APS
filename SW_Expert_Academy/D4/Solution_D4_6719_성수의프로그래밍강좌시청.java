import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청 { // 제출일 2019-10-23 15:40
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static double answer;
	static int N;
	static int K;
	static int[] M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 200 이하 자연수
			K = sc.nextInt();
			M = new int[N];
			for (int i = 0; i < N; i++) {
				M[i] = sc.nextInt(); // 10000 이하 자연수
			}
			
			Arrays.sort(M);
			answer = 0;
			for (int i = N-K; i < N; i++) {
				answer = (answer+M[i])/2;
			}
			
			bw.write(String.format("#%d %f\n", tc, answer));
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
