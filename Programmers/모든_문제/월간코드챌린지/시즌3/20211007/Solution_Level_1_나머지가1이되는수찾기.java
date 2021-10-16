public class Solution_Level_1_나머지가1이되는수찾기 {

	public static int solution(int n) {

		// n = mx + 1
		// 10 = 3 * 3 + 1
		// (10 - 1) / 3 = 3
		// 12 = 1 * 11 + 1
		// (12 - 1) / 11 = 1
		// n - 1 의 1이 아닌 가장 작은 약수 찾기
		n -= 1;
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return i;
			}
		}
		return n;
	}
}