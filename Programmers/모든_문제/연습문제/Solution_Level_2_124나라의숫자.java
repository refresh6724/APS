public class Solution_Level_2_124나라의숫자 { // 제출일 2021-08-12 23:55

	// test
	public static void main(String[] args) {
		System.out.println(solution(1)); //
		System.out.println(solution(2)); //
		System.out.println(solution(3)); //
		System.out.println(solution(4)); //
	}

	public static String solution(int n) {

		int[] arr = new int[1000];
		int cnt = 0;
		while (n != 0) {
			int mok = n / 3;
			int nam = n % 3;
			if (nam == 0) {
				arr[cnt++] = 4;
				mok--;
			} else {
				arr[cnt++] = nam;
			}
			n = mok;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = cnt - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
