import java.util.Arrays;

public class Solution_Level_3_거스름돈 { // 제출일 2021-11-16 23:55

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 })); // 4
	}

	static final int MOD = 1000000007;
	static int[] memo;

	public static int solution(int n, int[] money) {
		Arrays.parallelSort(money);
		memo = new int[n + 1];
		// memo[0] = 1 // 올바르지 않은 방법
		for (int m : money) {
			memo[m] += 1;
			for (int i = 1; i <= n; i++) {
				if (i >= m) {
					memo[i] = (memo[i] + memo[i - m]) % MOD;
				}
			}
		}
		return memo[n];
	}
}