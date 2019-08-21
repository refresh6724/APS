import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7227_사랑의카운슬러 { // 제출일 2019-08-21 17:00
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;
	static int N;
	static int[][] xy;
	static long totalSumX;
	static long totalSumY;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			// 최악의 경우 1사분면에서 4사분면으로 10번 빗금
			// answer = 대략 (20만^2 + 20만^2 ) * 10, 8천억
			answer = Long.MAX_VALUE;
			N = sc.nextInt(); // 지렁이 수
			// 수학적으로 쓰면 sigma가 나오게 된다 
			// 문제의 핵심은 선택한 지렁이의 좌표합 - 선택되지 않은 피선택 좌표합이 벡터가 된다는 것
			// 따라서 N개중 N/2개를 선택하면 해당 좌표합 - 피선택 N/2개의 좌표합의 제곱이 정답이 된다.
			xy = new int[N][2];
			totalSumX = 0;
			totalSumY = 0;
			for (int i = 0; i < N; i++) {
				xy[i][0] = sc.nextInt();
				totalSumX += xy[i][0];
				xy[i][1] = sc.nextInt();
				totalSumY += xy[i][1];
			}
			
			dfs(0,0,0,0);
			
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
		
	}

	public static void dfs(int idx, int cnt, int sumX, int sumY) {
						// 0번부터 idx번까지 cnt개를 선택한 그 합 sumX, sumY
		if(idx-cnt>N/2 || idx==N) return;
		// 19번까지 8개를 선택했다면 가망없음
		if(cnt == N/2) {
			// total = select + 나머지 
			// select - 나머지 = total - 2*나머지
			// 나머지 - select = total - 2*select
			// 제곱하므로 부호는 무관하다
			long x = totalSumX-(sumX<<1);
			long y = totalSumY-(sumY<<1);
			answer = Math.min(answer, (x*x + y*y));
			return;
		}
		// idx를 선택하지 않는다
		dfs(idx+1, cnt, sumX, sumY);
		// idx를 선택한다
		dfs(idx+1, cnt+1, sumX+xy[idx][0], sumY+xy[idx][1]);
		
		
	}
	
	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			//System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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
