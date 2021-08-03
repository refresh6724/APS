public class Solution_Level_1_문자열다루기기본 { // 제출일 2021-08-03 23:50

	// test
	public static void main(String[] args) {
		System.out.println(solution("a234")); // false
		System.out.println(solution("1234")); // true
	}

	/**
	 * @param s 길이 1 이상 8 이하 문자열
	 * @return s의 길이가 4 혹은 6이고 숫자로만 구성되어 있다면 true 리턴
	 */
	public static boolean solution(String s) {
		char[] ca = s.toCharArray();
		if (ca.length != 4 && ca.length != 6) {
			return false;
		}
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] < '0' || ca[i] > '9') {
				return false;
			}
		}
		return true;
	}
}
