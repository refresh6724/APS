import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-07 10:38
	
	static int answer;
	static int N; // 수열의 크기
	static int[] A; // 수열을 이루고 있는 원소
	static int[] D; // LIS를 위한 DP배열
	static int[] tracking; // 이전 원소의 위치를 저장하는 배열
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		
		N = sc.nextInt();
		A = new int[N];
		D = new int[N];
		tracking = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			D[i] = 1;
			tracking[i] = -1;
			for (int j = 0; j < i; j++) {
				if(A[i] > A[j]) {
					//D[i] = Integer.max(D[i], D[j]+1);
					if(D[i] < D[j]+1) {
						D[i] = D[j]+1;
						tracking[i] = j;
					} else { // D[i] > D[j]+1
						//tracking[i] = i;						
					}
				}
			}
		}			
		answer = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(D[i] > answer) {
				answer = D[i];
				idx = i;
			}
		}		
		
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(D));
//		System.out.println(Arrays.toString(tracking));
//		
		//StringBuilder sb = new StringBuilder();
		StringBuffer buf = new StringBuffer();
		buf.append(A[idx]);
		//sb.append(" ").append(A[idx]);
		int track = 0;
		while(true) {
			track = tracking[idx];
			if(track == -1)break;
			buf.insert(0, " ").insert(0, A[track]);
			//sb.append(track).append(" ");
			idx = track;			
		}
			
			
		System.out.println(answer);
		System.out.println(buf.toString());
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
