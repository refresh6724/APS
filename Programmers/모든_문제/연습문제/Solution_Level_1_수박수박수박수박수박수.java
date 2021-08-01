public class Solution_Level_1_수박수박수박수박수박수 { // 제출일 2021-08-01 23:30

	// test
	public static void main(String[] args) {
		System.out.println(solution(3)); // 수박수
		System.out.println(solution(4)); // 수박수박
	}

	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		int repeat = n / 2;
		for (int i = 0; i < repeat; i++) {
			sb.append("수박");
		}
		if (n % 2 == 1) {
			sb.append("수");
		}
		return sb.toString();
	}
}
