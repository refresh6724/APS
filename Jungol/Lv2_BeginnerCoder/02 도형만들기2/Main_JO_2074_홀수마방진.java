import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2074_홀수마방진 { // 제출일 2019-10-23 18:01
	
	static StringBuilder sb;
	static int N;
	static int NN;
	static int[] fill;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		sb = new StringBuilder();
		N = sc.nextInt();
		NN = N*N;
		fill = new int[NN];
		
		go(N/2, 1);		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(fill[N*i + j]).append(" ");
			}
			sb.append("\n");
		}
			
		System.out.println(sb.toString());
	}

	private static void go(int idx, int num) {
		if(num > NN) return;
		fill[idx] = num;
		if(num % N == 0) go(idx+N, num+1);
		else if(idx % N == 0) go(idx-1, num+1);
		else if(idx-N-1<0) go(idx+NN-N-1, num+1);
		else go(idx-N-1, num+1);		
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
