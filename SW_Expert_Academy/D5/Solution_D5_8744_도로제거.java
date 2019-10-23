import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
// 오답 -> 11개 시간초과 -> 13개 시간초과 -> 통과
public class Solution_D5_8744_도로제거 { // 제출일 2019-10-23 15:28
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N;
	static int M;
	//static boolean[][] connected;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] connected = new int[N+1];
			Arrays.fill(connected, N-1);
			
			
			int s=0;
			int e=0;
			// 이 중 M개를 제거
			for (int i = 0; i < M; i++) { // 1만번
				s = sc.nextInt();
				e = sc.nextInt();
				connected[s]--;
				connected[e]--;				
			}
			
			Arrays.sort(connected);						
						
			bw.write(String.format("#%d %d\n", tc, connected[0]-1));
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
