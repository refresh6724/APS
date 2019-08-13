import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7964_부먹왕국의차원관문 { // 제출일 2019-08-14 00:56
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int[] map = new int[300002];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();		
		for (int tc = 1; tc <= TC; tc++) {
			int cities = sc.nextInt();
			int limit = sc.nextInt();
			map[0] = 1;
			map[cities+1] = 1;
			for (int i = 1; i <= cities; i++) {
				map[i] = sc.nextInt();
			}
			answer = 0;
			int idx = 0;
			int len = 0;
			while(++idx <= cities) { // cities+1에 도달하기 전까지
				if(map[idx] == 0) { // 공백이면
					len++; // len을 1 늘리고
					if(len == limit) { // 한계거리까지 1이 없으면
						answer++; // 하나를 설치했다치고
						len = 0; // 다시 초기화
					}					
				} else { // 1을 만나면
					len = 0; // 초기화
				}				
			}	
			
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
		
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
