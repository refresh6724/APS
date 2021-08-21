public class Solution_Level_1_1차_비밀지도 { // 제출일 2021-08-21 23:31

	// test
	public static void main(String[] args) {
		testcase1();
	}

	private static void testcase1() {
		int n = 5;
		int[] arr1 = new int[] { 9, 20, 28, 18, 11 };
		int[] arr2 = new int[] { 30, 1, 21, 17, 28 };
		String[] ret = solution(n, arr1, arr2);
		for (int i = 0; i < ret.length; i++) {
			System.out.println((ret[i]));
		}
	}

	/**
	 * 벽 겹치기
	 * 
	 * @param n    배열의 길이
	 * @param arr1
	 * @param arr2
	 * @return 각 배열의 수
	 */
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] ret = new String[n];
		String formatString = "%" + n + "s";
		for (int i = 0; i < n; i++) {
			ret[i] = String.format(formatString, Integer.toBinaryString(arr1[i] | arr2[i])).replace('0', ' ').replace('1', '#');
		}
		return ret;
	}
}
