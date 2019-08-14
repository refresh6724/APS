import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 { // 제출일 2019-08-14 19:32

	static String[][] arr = new String[201][];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int V;

	public static void main(String[] args) throws Exception {
		sc.init();
		for (int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt();

			arr = new String[201][];
			for (int i = 1; i <= V; i++) {
				arr[i] = sc.readLine().split(" ");
				// System.out.println(Arrays.toString(arr[i]));
			}

			// 주어진 순서는 by level
			// 왼쪽 자식 2*i 오른쪽 2*i+1

			// 숫자는 terminal 이어야 한다
			// 연산자는 자식을 모두 가져야한다
			answer = 1;// 유효한 수식이라고 가정하고
			// 다음에 오는 수식 검증에서 실패하면 answer = 0 하고 break;
			dfs(1); // 검증

			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
	}

	static void dfs(int idx) {
		String tmp = arr[idx][1];
		char c = tmp.charAt(0); // 나올수 있는 경우의 수 숫자와 연산자 ,숫자의 경우 두자리 이상인 경우 처음 숫자

		if (Character.isDigit(c)) { // 숫자라면 terminal이어야한다
			if (idx * 2 > V || idx * 2 + 1 > V)
				return; // idx*2 가 V보다 크다면
			if (arr[idx * 2] != null || arr[idx * 2 + 1] != null) {
				answer = 0;
				return;
			}
		} else { // 연산자이면 두 자식이 모두 있어야 한다
			if (arr[idx * 2] == null || arr[idx * 2 + 1] == null) {
				answer = 0;
				return;
			}
			// 통과했다면 다음 자식에 대해서도 테스트
			dfs(idx * 2);
			dfs(idx * 2 + 1);
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
