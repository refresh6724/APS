import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 { // 제출일 2019-08-19 01:30
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static StringBuilder sb;
//	static String value;
	static char[] value;
	static int maxExchange;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			value = sc.next().toCharArray();			
			maxExchange = sc.nextInt();
		
			dfs(0,0);
			
			bw.write(String.format("#%d %s\n", tc, answer));
			bw.flush();
		}
		
	}

	static void dfs(int index, int count) {
		if(count == maxExchange) {
			sb = new StringBuilder();
			for (int i = 0; i < value.length; i++) {
				sb.append(value[i]);
			}
			answer = Integer.max(answer, Integer.parseInt(sb.toString()));
			return;
		}
		for (int i = index; i < value.length; i++) {
			for (int j = i+1; j < value.length; j++) {
				if(value[i] <= value[j]) {
					swap(i,j);
					dfs(i, count+1);
					swap(i,j);
				}
			}
		}
		
	}
	
	static void swap(int i, int j) {
		char temp = value[i];
		value[i] = value[j];
		value[j] = temp;
		
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
