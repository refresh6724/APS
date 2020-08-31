public class Solution_Level_3_정수삼각형 { // 제출일 2020-08-31 18:55

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } })); // 30
	}

	public static int solution(int[][] triangle) {
		int[] memo = new int[triangle.length + 1];

		for (int i = 0; i < triangle.length; i++) {
			for (int j = triangle[i].length - 1; j >= 0; j--) {
				memo[j + 1] = Math.max(memo[j], memo[j + 1]) + triangle[i][j];
			}
		}
		int max = 0;
		for (int i = 0; i < memo.length; i++) {
			if (max < memo[i]) {
				max = memo[i];
			}
		}
		return max;
	}

}