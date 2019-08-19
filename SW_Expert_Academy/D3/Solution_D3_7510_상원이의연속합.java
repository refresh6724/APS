import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7510_상원이의연속합 { // 제출일 2019-08-19 13:26
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			answer = 1; // 자기자신
			int sum = 0;
			for (int i = 1; i <= N/2; i++) {
				sum=i;
				for (int j = i+1; j <= N/2 + 1; j++) {
					sum += j;
					if(sum == N) answer++;
					if(sum > N) break;
				}
			}
			
			
			
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
		
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
