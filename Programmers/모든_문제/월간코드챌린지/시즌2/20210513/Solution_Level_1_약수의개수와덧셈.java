public class Solution_Level_1_약수의개수와덧셈 { // 제출일 2021-05-15 23:05

	static int[] memo;

	public static int solution(int left, int right) {

		// 아르키메데스의 체를 응용하여 약수 개수 체크
		memo = new int[1001];
		for (int i = 2; i < 1001; i++) {
			for (int j = i; j < 1001; j += i) {
				memo[j]++;
			}
		}
		// 약수 1을 미리 제외하면 문제 조건은 홀수일 때 더하고 짝수일 때 빼는 것으로 변한다
		int ret = 0;
		for (int i = left; i <= right; i++) {
			if (memo[i] % 2 != 0) {
				ret += i;
			} else {
				ret -= i;
			}
		}
		return ret;

	}
}
