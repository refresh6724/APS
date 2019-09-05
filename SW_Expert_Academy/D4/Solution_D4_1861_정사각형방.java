import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 { // 제출일 2019-09-05 14:25
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int length;
	static int N; // 1000이하 자연수
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = Integer.MAX_VALUE;
			length = 0;
			N = sc.nextInt();
			map = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			// N x N 에 대해 각 지점에서 출발해서
			// 상하좌우로 1씩 증가하는 수열 만들기가 가능한지
			// 또 가능하다면 그 길이가 가장 긴것
			// 테케번호 출발번호 길이(자신 포함)
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 출발지점 map[i][j] 
					start(i,j,1);
				}
			}
			
			
			bw.write(String.format("#%d %d %d\n", tc, answer, length));
			bw.flush();
		}
		
	}

	private static void start(int i, int j, int len) {
		// 이동후 answer 갱신
		if(len > length) {
			answer = map[i][j]-len+1;
			length = len;
		} else if(len == length) {
			answer = Integer.min(map[i][j]-len+1, answer);
		}
		if(i-1>=1 && map[i][j]+1 == map[i-1][j]) {
			start(i-1,j,len+1);
			
		} else if(i+1<=N && map[i][j]+1 == map[i+1][j]) {
			start(i+1,j,len+1);
			
		} else if(j-1>=1 && map[i][j]+1 == map[i][j-1]) {
			start(i,j-1,len+1);
			
		} else if(j+1<=N && map[i][j]+1 == map[i][j+1]) {
			start(i,j+1,len+1);
		}
		return; 
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
