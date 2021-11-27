public class Solution_Level_3_N_Queen {

	// test
	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++) {
			long start = System.currentTimeMillis();
			int ans = solution(i);
			long end = System.currentTimeMillis();
			System.out.println(String.format("%d : %d (%dms)", i, ans, (end - start)));
		}
	}

	static boolean[] col, rd, ld;

	// n은 12 이하의 자연수
	public static int solution(int n) {

		col = new boolean[n];
		rd = new boolean[n << 1];
		ld = new boolean[n << 1];

		return dfs(0, n);
	}

	private static int dfs(int r, int n) {

		if (r == n) {
			return 1;
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (!col[i] && !rd[n + i - r] && !ld[r + i]) {
				col[i] = true;
				rd[n + i - r] = true;
				ld[r + i] = true;
				ret += dfs(r + 1, n);
				col[i] = false;
				rd[n + i - r] = false;
				ld[r + i] = false;
			}
		}
		return ret;

	}
}