import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-07 09:55
	
	static long answer;
	static int K;
	static int N;
	static int[] arr; // int 범위내에서 입력됨
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new int[K];
		long s = 1L;
		long e = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > e) e = arr[i];
		}
		long mid = 0;
		long div = 0;
		while(s<=e) {
			div = 0;
			mid = (s+e)/2;
			for (int i = 0; i < K; i++) {
				div += arr[i]/mid;				
			}
			if(div >= N) { // 목표보다 크거나 같으면 나누는 것을 크게
				//System.out.println(String.format("s:%d e:%d m:%d ans:%d", s, e, mid, answer));
				s = mid +1;
				if(mid > answer) answer = mid;
			} else if(div < N) { // answer < N     // 목표보다 모자라면 나누기를 작게
				//System.out.println(String.format("s:%d e:%d m:%d ans:%d", s, e, mid, answer));
				
				e = mid-1;		
			} 
		}
				
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
