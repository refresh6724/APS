import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2999_비밀이메일 { // 제출일 2019-08-29 16:15
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		sb = new StringBuilder();
		String input = sc.readLine();
		int N = input.length();
		int j;
		for (j = (int)Math.sqrt(N); j>0; j--) {
			if(N%j == 0) break;
		}
		int k = N/j;
		for (int i = 0; i < N; i++) {
			sb.append(input.charAt((i/k) + (j*i)%N));
		}
		
		bw.write(String.format("%s", sb.toString()));
		bw.flush();
		
	
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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
