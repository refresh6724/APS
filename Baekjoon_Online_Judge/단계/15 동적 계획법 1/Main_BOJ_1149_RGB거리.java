import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {
	
	static int answer;
	static int N;
	static int[] prev;
	static int[] now;
	static int[] RGB;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		prev = new int[3];
		now = new int[3];
		RGB = new int[3];
		
		for (int i = 0; i < N; i++) {
			now[0] = sc.nextInt();
			now[1] = sc.nextInt();
			now[2] = sc.nextInt();
			
			RGB[0] = now[0] + Math.min(prev[1], prev[2]);
			RGB[1] = now[1] + Math.min(prev[0], prev[2]);
			RGB[2] = now[2] + Math.min(prev[0], prev[1]);
			
			prev[0] = RGB[0];
			prev[1] = RGB[1];
			prev[2] = RGB[2];
			//System.out.println(Arrays.toString(prev));
		}
		
		answer = Math.min(prev[0], Math.min(prev[1], prev[2]));	
		System.out.println(answer);
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
