import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2449_전구 { // 제출일 2020-02-22 22:06
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, k, sum;
	static int[] a;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		a = new int[n + 1];
		int idx = 0;
		int prev = 0;
		int next = 0;
		for (int i = 1; i <= n; i++) {
			next = Integer.parseInt(st.nextToken());
			if (prev != next) {
				a[++idx] = next;
				prev = next;
			}
		}
		n = idx; // 사이즈 압축, 재조정
//		System.out.println(Arrays.toString(a));
//		System.out.println(idx);
		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i == j) {
					dp[i][i] = 0;
				} else {
					dp[i][j] = 201;
				}
			}
		}

		for (int len = 2; len <= n; len++) {
			for (int start = 1; start <= n - len + 1; start++) {
				int end = start + len - 1;
				for (int mid = start; mid < end; mid++) {
					dp[start][end] = Math.min(dp[start][end],
							(dp[start][mid] + dp[mid + 1][end] + ((a[start] != a[mid + 1]) ? 1 : 0)));
				}
			}
		}

		int start = 1;
		int end = n;
		System.out.println(dp[start][end]);

	}

}