import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7584_자가복제문자열 { // 제출일 2019-08-16 19:32
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// 문자열 점화식
			// P0 = "0";
			// Pi+1 = Pi +"0"+f(g(Pi));
			// f() 는 0을 1로 1을 0으로 반전
			// g() 는 좌우반전 reverse
			// 원래는 메서드를 만들어서 쓰려고 했는데
			// k 최대값이 1e18이라는 터무니 없이 큰 값이라서
			// 나누기를 통해 원 값을 찾는 수학적인 방법을 사용해야 한다

			long K = sc.nextLong();
			// 0001100000 이면 가장 처음 나오는 0의 위치
			// 1024는 2^10 이므로 10000000000 => 11이 나온다
			String KK = Long.toBinaryString(K);
			int N = KK.length();
			long KKK = (long)1<<N;
			int cnt = 0;
			while(KKK != K<<1 && !isPow2(KKK-K)) { // 2의 배수면 true 아니면 false이므로 while문 내부로 
				cnt++;
				K = KKK-K;
				KK = Long.toBinaryString(K);
				N = KK.length();
				KKK = (long)1<<N;
			}
			// cnt 횟수만큼 10 반전
			if(cnt%2 == 0) answer = 1;
			if(KKK == K<<1) answer = 0;
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
			answer = 0;
		}

	}

	static boolean isPow2(long K) {
		String KK = Long.toBinaryString(K);
		return KK.indexOf("1") == KK.lastIndexOf("1");
	}
	
	static String f(String str) {
		StringBuilder sb = new StringBuilder();
		int tmp;
		for (int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i) - '0';
			tmp++;
			tmp %= 2;
			sb.append(tmp);
		}
		return sb.toString();
	}

	static String g(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		return sb.reverse().toString();
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

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
