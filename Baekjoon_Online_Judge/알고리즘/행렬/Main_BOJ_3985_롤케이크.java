import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 { // 제출일 2019-08-29 16:33
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int L = sc.nextInt(); // 롤케이크의 길이 1000 이하 자연수
		int N = sc.nextInt(); // 방청객의 수 1000 이하 자연수

		int num1 = 0;
		int len = 0;
		int max1 = 0;
		int[] cake = new int[L + 1];
		int p = 0;
		int k = 0;
		int cnt = 0;
		int max2 = 0;
		int num2 = 0;
		for (int i = 1; i <= N; i++) {
			p = sc.nextInt();
			k = sc.nextInt();
			cnt = 0;
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}
			}
			len = k - p;
			if (len > max1) {
				max1 = len;
				num1 = i; // 0번부터 => 1번으로 변환
			}
			if (cnt > max2) {
				max2 = cnt;
				num2 = i;
			}
		}

		bw.write(String.format("%d\n%d", num1, num2));
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
