import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM { // 제출일 2019-08-29 14:39
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();

		// Shortest Job First 시간 구하기
		int N = sc.nextInt();
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}
		Arrays.sort(P); // 시간 오름차순 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				answer += P[j];
			}
		}
		

		bw.write(String.format("%d", answer));
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
