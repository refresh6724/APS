public class Solution_Level_4_도둑질 { // 제출일 2020-09-02 22:30 // 제출 시각 현재 java 효율성 테스트에 문제가 있는 것으로 보임

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 1 })); // 4
	}

	static int[] memo;

	public static int solution(int[] money) {

		int len = money.length;
		int max = 0;
		memo = new int[len + 2];
		for (int i = 0; i < len - 1; i++) {
			memo[i + 3] = money[i];
		}
		for (int i = 3; i < len + 2; i++) {
			memo[i] += Math.max(memo[i - 3], memo[i - 2]);
		}
		max = Math.max(memo[len], memo[len + 1]);

		memo = new int[len + 2];
		for (int i = 1; i < len; i++) {
			memo[i + 2] = money[i];
		}
		for (int i = 3; i < len + 2; i++) {
			memo[i] += Math.max(memo[i - 3], memo[i - 2]);
		}

		return Math.max(max, Math.max(memo[len], memo[len + 1]));
	}

}