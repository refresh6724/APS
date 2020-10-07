public class Solution_Level_4_스티커모으기_2 { // 2차 제출일 2020-10-07 19:38

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 14, 6, 5, 11, 3, 9, 2, 10 }));// 36
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }));// 8
		System.out.println(solution(new int[] { 1 }));// 1
		System.out.println(solution(new int[] { 1, 2, 3 }));// 3
		System.out.println(solution(new int[] { 1, 0, 1 }));// 1
		System.out.println(solution(new int[] { 1, 0, 1, 1 }));// 2
		System.out.println(solution(new int[] { 0, 1, 0, 0, 1 }));// 2
	}

	public static int solution(int[] sticker) {

		// 단순 1차원 dp 문제
		// 첫글자를 사용할 경우 마지막 글자를 사용할 수 없다
		// 첫글자를 제외하고 두번째부터 마지막 글자까지 두번 반복 따라서 2n

		int n = sticker.length;
		if (n == 1) {
			return sticker[0];
		} else if (n == 2) {
			return Math.max(sticker[0], sticker[1]);
		}

		int[] memo = new int[n];
		memo[0] = sticker[0]; // 첫번째 숫자를 넣고
		memo[1] = sticker[1];
		memo[2] = memo[0] + sticker[2];
		for (int i = 3; i < n - 1; i++) { // 마지막 숫자를 계산하지 않는다
			memo[i] = Math.max(memo[i - 3], memo[i - 2]) + sticker[i];
		}

		int max = Math.max(memo[n - 2], memo[n - 3]);

		memo[0] = 0; // 첫번째 숫자를 빼고
		memo[1] = sticker[1];
		memo[2] = memo[0] + sticker[2];
		for (int i = 3; i < n; i++) { // 마지막 숫자를 계산한다
			memo[i] = Math.max(memo[i - 3], memo[i - 2]) + sticker[i];
		}

		max = Math.max(max, Math.max(memo[n - 1], memo[n - 2]));

		return max;
	}

}