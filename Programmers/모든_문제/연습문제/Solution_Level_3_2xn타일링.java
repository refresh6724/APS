public class Solution_Level_3_2xn타일링 {

	// test
	public static void main(String[] args) {
		System.out.println(solution(4)); // 1 1 2 3 5
		System.out.println(solution(60000)); // 804299274

	}

	public static int solution(int n) {

		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = (memo[i - 2] + memo[i - 1]) % 1000000007;
		}
		return memo[n];

	}
}