public class Solution_Level_4_사칙연산 { // 제출일 2020-09-22 19:08

	// test
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "1", "-", "3", "+", "5", "-", "8" })); // 1
		System.out.println(solution(new String[] { "5", "-", "3", "+", "1", "+", "2", "-", "4" })); // 3
	}

	public static int solution(String[] arr) {

		// arr는 3 이상 201 이하 홀수
		// 두 개씩 계산해서 만들 수 있는 가장 큰 수
		// 2i가 숫자
		// 2i+1 이 문자
		// 계산 횟수는 문자의 개수만큼 총 i번
		// 최대 101 개의 문자에 대해서 우선순위 결정 => 경우의 수 101!

		int[] num = new int[(arr.length + 1) / 2];
		char[] plma = new char[arr.length / 2];
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				num[i / 2] = Integer.parseInt(arr[i]);
			} else {
				plma[i / 2] = arr[i].charAt(0);
			}
		}

		// 접근방법 1 => fail
		// 1개 최댓값 => 1
		// 2개 최댓값 => 2
		// 3개 최댓값 => 1 최댓값 +- 뒤 2개 또는 2 최댓값 +- 3
		// 4개 최댓값 => 2 최댓값 +- 뒤 2개 또는 3 최댓값 +- 4

		/*
		int[] memo = new int[(arr.length + 1) / 2];
		memo[0] = num[0];
		memo[1] = (plma[0] == '+') ? num[0] + num[1] : num[0] - num[1];

		for (int i = 2; i < memo.length; i++) {
			int right = (plma[i - 1] == '+') ? num[i - 1] + num[i] : num[i - 1] - num[i];
			memo[i] = Math.max((plma[i - 2] == '+') ? memo[i - 2] + right : memo[i - 2] - right, 
								(plma[i - 1] == '+') ? memo[i - 1] + num[i] : memo[i - 1] - num[i]);
		}

		return memo[((arr.length + 1) / 2) - 1];
		*/

		// 접근방법 2
		// i부터 j까지 최소값과 최대값을 저장
		int len = (arr.length + 1) / 2;

		int[][] max = new int[len][len];
		int[][] min = new int[len][len];
		for (int i = 0; i < num.length; i++) {
			max[i][i] = min[i][i] = num[i];

		}

		for (int cal = 1; cal < num.length; cal++) {
			for (int left = 0, right = left + cal; left < num.length - cal; left++, right++) {

				int mm = Integer.MIN_VALUE;
				int mn = Integer.MAX_VALUE;
				for (int idx = left; idx < right; idx++) {
					if (plma[idx] == '+') {
						mm = Integer.max(mm, max[left][idx] + max[idx + 1][right]);
						mn = Integer.min(mn, min[left][idx] + min[idx + 1][right]);
					} else {
						mm = Integer.max(mm, max[left][idx] - min[idx + 1][right]);
						mn = Integer.min(mn, min[left][idx] - max[idx + 1][right]);
					}
				}
				max[left][right] = mm;
				min[left][right] = mn;

			}
		}

		return max[0][len - 1];

	}

}