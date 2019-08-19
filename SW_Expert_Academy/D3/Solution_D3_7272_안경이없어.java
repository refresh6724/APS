import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 { // 제출일 2019-08-19 13:36
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			String left = sc.next();
			String right = sc.next();
			if(left.length() == right.length()) {
				boolean isDiff = false;
				for (int i = 0; i < left.length(); i++) {
					if(judge(left.charAt(i)) != judge(right.charAt(i))) isDiff = true;
				}
				if(isDiff) {
					answer = "DIFF";
				} else {
					answer = "SAME";
				}
				
			} else {
				answer = "DIFF";
			}
			
			bw.write(String.format("#%d %s\n", tc, answer));
			bw.flush();
		}
		
	}

	static int judge(char c) {
		switch(c){
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			return 1;
		case 'B':
			return 2;
		default :
			return 0;
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
