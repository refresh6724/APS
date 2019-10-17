import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트와링크 { // 제출일 2019-10-17 14:10 
	
	static int answer;
	static int N; // 20이하
	static int[][] S; // 시너지
	static boolean[] team;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		
		N = sc.nextInt();
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		}
		answer = 10000;
		team = new boolean[N];		
		dfs(0, 0);	
			
		System.out.println(answer/2);
	}

	private static void dfs(int idx, int cnt) {
		if(idx == N) {
			if(cnt != N/2) return;
			// 모든 인원을 점검해서 절반이 한팀인 경우 계산 ㄱ
			calc();
			return;
		}
		
		team[idx] = true;
		dfs(idx+1, cnt+1);
		team[idx] = false;
		dfs(idx+1, cnt);		
	}

	private static void calc() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(team[i] && team[j]) {
					sum1 += S[i][j];
					sum1 += S[j][i];
				} else if(!team[i] && !team[j]) {
					sum2 += S[i][j];
					sum2 += S[j][i];
				}
			}
		}
		answer = Math.min(answer, Math.abs(sum1-sum2));		
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
