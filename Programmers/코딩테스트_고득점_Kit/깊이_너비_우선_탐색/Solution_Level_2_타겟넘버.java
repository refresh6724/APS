public class Solution_Level_2_타겟넘버 { // 제출일 2020-09-03 22:10

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3)); // 5
	}

	static int answer, len;

	public static int solution(int[] numbers, int target) {

		answer = 0;
		len = numbers.length;
		dfs(0, 0, numbers, target);
		return answer;
	}

	private static void dfs(int idx, int sum, int[] numbers, int target) {

		if (idx == len) {
			if (sum == target) {
				answer++;
			}
			return;
		}

		dfs(idx + 1, sum + numbers[idx], numbers, target);
		dfs(idx + 1, sum - numbers[idx], numbers, target);

	}

}