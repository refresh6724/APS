import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ICPC > Regionals > Asia Pacific > Korea > Asia Regional - Seoul 2005 A번
public class Main_8958_OX퀴즈 { // 제출일 2019-08-29 16:56
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			String ox = sc.readLine(); // 0보다 크고 80보다 작은 문자열
			// 연속 O가 1이면 1 2면 3 3이면 6 4면 10  n(n+1)/2
			answer = 0;
			// 처음 O발견
			int start =0;
			int end = 0;
			while(true) {
				start = ox.indexOf("O", end);
				end = ox.indexOf("X", start);
				if(start == -1 || end == -1) break;
				answer += (end-start)*(end-start+1)/2;					
			}
			int n = 0;
			if(start == -1) { // X로 끝난 경우
				
			}
			else if(end == -1) { // O로 끝난 경우
				n = ox.length()-start;
				answer += n*(n+1)/2;
			}
			
			
			bw.write(String.format("%d\n", answer));
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
