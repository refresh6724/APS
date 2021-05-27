import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-09-19 17:30
	public static void main(String[] args) throws Exception {
		sc.init();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[101];
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		int[] d = new int[10001];
		for (int i = 1; i <= k; i++) {
			d[i] = 100001;
		}
		for (int i = 1; i <= n; i++) { // 각 동전에 대해
			for (int j = coin[i]; j <= k; j++) {
				d[j] = Math.min(d[j], d[j - coin[i]] + 1);
			}
		}
		if (d[k] == 100001)
			d[k] = -1;

		System.out.println(d[k]);
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