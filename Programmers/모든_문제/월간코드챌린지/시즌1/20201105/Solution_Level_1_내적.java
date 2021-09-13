public class Solution_Level_1_내적 { // 제출일 2020-11-09 23:02

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }, new int[] { -3, -1, 0, 2 })); // 3
		System.out.println(solution(new int[] { -1, 0, 1 }, new int[] { 1, 0, -1 })); // -2
	}

	// 1000 * 1000 * 1000 = 최대  10억
	public static int solution(int[] a, int[] b) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i] * b[i];
		}
		return sum;
	}

}