public class Solution_Level_1_문자열을정수로바꾸기 { // 제출일 2021-07-31 23:03

	// test
	public static void main(String[] args) {
		System.out.println(solution("+25")); // 25
	}

	// Integer.parseInt(String s) 구현하기
	public static int solution(String s) {
		char[] cs = s.toCharArray();
		int plusminus = 0;
		int idx = 0;
		if (cs[idx] >= '1' && cs[idx] <= '9') {
			plusminus = 1;
		} else {
			plusminus = (cs[idx++] == '+') ? 1 : -1;
		}
		int answer = 0;
		for (; idx < cs.length; idx++) {
			answer = answer * 10 + (cs[idx] - '0');
		}
		return plusminus * answer;
	}
}
