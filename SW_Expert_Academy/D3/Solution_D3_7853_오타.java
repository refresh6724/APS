import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7853_오타 { // 제출일 2019-08-16 09:54
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 1L;
			char[] input = sc.readLine().toCharArray();
			int size = input.length;
			for (int i = 0, j=1; i < size; i++, j=1) {		
				answer %= 1000000007; // 그대로 계산할 경우 2^1000 = 10^300으로 long 타입을 넘겨버린다, 매번 나눠줄것
				if(i!=0 && i!=size-1) { //중간 
					if(input[i-1] == input[i+1]) { // aba 2 aaa 1
						if(input[i-1] == input[i]) {
							// 그대로 둔다
						} else {
							answer<<=1;
						}			
					} else  { // 1 3이 다른 경우 // abc 3  abb 2 aab 2 
						if(input[i-1] == input[i] || input[i] == input[i+1]) {
							answer<<=1;
						} else {
							answer*=3;
						}
					}
				}  else if(i==0) { // 첫문자
					if(size==1) break;
					if(input[i] != input[i+1]) {
						answer<<=1;
					}
				} else if(i==size-1) {// 끝문자
					if(input[i-1] != input[i]) {
						answer<<=1;
					} 
				} else {
					System.err.println("내가 가정하지 못한 경우");
				}
			}
			
			answer %= 1000000007;			
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
