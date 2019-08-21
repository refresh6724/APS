import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_8338_계산기 { // 제출일 2019-08-21 13:37
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			//N개의 수 a[N]
			int N = sc.nextInt(); // 1~9개
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			//수 사이에는 + or * 입력
			//계산기 입력이므로 연산자 우선순위를 무시하고 입력되는대로 계산
			int j = 0;
			if(N != 1) {
				while(j != N) {
					answer = (answer+arr[j] > answer*arr[j]) ? answer+arr[j] : answer*arr[j];
					j++;
				}
			} else {
				answer = arr[0];
			}
			
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
