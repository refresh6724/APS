public class Solution_Level_3_등굣길 { // 제출일 2020-09-01 20:06

	// test
	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] { { 2, 2 } })); // 4
	}

	static boolean[][] isPuddle;
	static long[][] memo;

	public static int solution(int m, int n, int[][] puddles) {

		isPuddle = new boolean[n + 1][m + 1];
		memo = new long[n + 1][m + 1];
		memo[1][1] = 1;

		for (int i = 0; i < puddles.length; i++) {
			isPuddle[puddles[i][1]][puddles[i][0]] = true;
		}

		return (int) dp(n, m);

	}

	private static long dp(int n, int m) {

		if (n == 0 || m == 0) {
			return 0;
		}

		if (memo[n][m] != 0) {
			return memo[n][m];
		}

		return memo[n][m] = ((isPuddle[n][m - 1] ? 0 : dp(n, m - 1)) + (isPuddle[n - 1][m] ? 0 : dp(n - 1, m)))	% 1000000007;

	}

}