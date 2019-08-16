import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7675_통역사성경이 { // 제출일 2019-08-16 13:44
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static int answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int lineNum = sc.nextInt(); // 문장 숫자 - 스킵
			sb = new StringBuilder();
			String[] lines = sc.readLine().split("[.!?]"); // regular expression
			for (String line : lines) {
				answer = 0;
				StringTokenizer st2 = new StringTokenizer(line, " ");
				while(st2.hasMoreTokens()) {
					String solve = st2.nextToken(); // 문장의 다음 단어
					if(solve.length() == 1) { // 한글자인가?
						if(solve.charAt(0) >= 65 && solve.charAt(0) <= 90) { //대문자인가?
							answer++;							
						} 
						continue;
					} else { // 두글자 이상
						if(solve.charAt(0) >= 65 && solve.charAt(0) <= 90) { //첫글자가 대문자인가?
							for (int i = 1; i < solve.length(); i++) { // 두번째부터 끝까지 
								if(solve.charAt(i) >= 97 && solve.charAt(i) <= 122) { // 소문자인가
									if(i == solve.length()-1) answer++;
								} else {
									break;
								}								
							}							
						} 
					}
				}
				
				sb.append(" ").append(answer);
			}
			
			
			
			
			
			
			bw.write(String.format("#%d%s\n", tc, sb));
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
