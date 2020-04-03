import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-04 19:35

	static int i;
	static int j;
	static int k;
	static int[][][] input;
	static int[][] c;
	static int[] answer;
	static int tmp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		input = new int[4][6][3]; // win draw lose
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					input[i][j][k] = sc.nextInt();
				}
			}
		}
		c = new int[6][3];
		answer = new int[4];
		dfs(0, 1);
		System.out.println(String.format("%d %d %d %d", answer[0], answer[1], answer[2], answer[3]));

	}

	private static void dfs(int a, int b) {
		if (b == 6) {
			a++;
			b = a + 1;
		}
		if (a == 5) {
			for (int i = 0; i < 4; i++) {
				if (answer[i] == 1)
					continue;
				tmp = 1;
				for (int j = 0; j < 6; j++) {
					for (int k = 0; k < 3; k++) {
						if (c[j][k] != input[i][j][k]) {
							tmp = 0;
							break;
						}
					}
					if (tmp == 0)
						break;
				}
				answer[i] =tmp;
			}
			return;
		}
		// 승 패
		c[a][0]++;
		c[b][2]++;
		dfs(a, b + 1);
		c[a][0]--;
		c[b][2]--;
		// 무 무
		c[a][1]++;
		c[b][1]++;
		dfs(a, b + 1);
		c[a][1]--;
		c[b][1]--;
		// 패 승
		c[a][2]++;
		c[b][0]++;
		dfs(a, b + 1);
		c[a][2]--;
		c[b][0]--;
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
