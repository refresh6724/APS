import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7732_시간개념 { // 제출일 2019-08-14 00:33
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			String before = sc.readLine();
			int hour1 = Integer.parseInt(before.substring(0,2));
			int minute1 = Integer.parseInt(before.substring(3,5));
			int second1 = Integer.parseInt(before.substring(6,8));
			int time1 = hour1 * 3600 + minute1 * 60 + second1;	
			
			String after = sc.readLine();
			int hour2 = Integer.parseInt(after.substring(0,2));
			int minute2 = Integer.parseInt(after.substring(3,5));
			int second2 = Integer.parseInt(after.substring(6,8));
			int time2 = hour2 * 3600 + minute2 * 60 + second2;	
			
			int time = time2 - time1;
			if(time < 0) time += 24*3600;
			int hour3 = time/3600;
			int minute3 = (time%3600)/60;
			int second3 = time%60;
			
			answer = new StringBuilder();
			if(hour3 >=10 ) answer.append(hour3);
			else answer.append("0").append(hour3);
			answer.append(":");
			if(minute3 >=10 ) answer.append(minute3);
			else answer.append("0").append(minute3);
			answer.append(":");
			if(second3 >=10 ) answer.append(second3);
			else answer.append("0").append(second3);
			
			bw.write(String.format("#%d %s\n", tc, answer.toString()));
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
