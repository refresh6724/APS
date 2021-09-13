public class Solution_Level_1_없는숫자더하기 { // 제출일 2021-09-13 23:07

	// test
	public static void main(String[] args) { 
		System.out.println(solution(new int[] { 1, 2, 3, 4, 6, 7, 8, 0 })); // 14
		System.out.println(solution(new int[] { 5, 8, 4, 0, 6, 7, 9 })); // 6
	}

	public static int solution(int[] numbers) {
		int sum = 45;
		for (int i = 0; i < numbers.length; i++) {
			sum -= numbers[i];
		}
		return sum;
	}
}
