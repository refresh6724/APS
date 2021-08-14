public class Solution_Level_2_올바른괄호 { // 제출일 2021-08-14 22:30

	// test
	public static void main(String[] args) {
		System.out.println(solution("()()")); // true
	}

	static boolean solution(String s) {
		int open = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				open++;
			} else {
				open--;
				if (open < 0) {
					return false;
				}
			}
		}
		if(open == 0) {
			return true;
		}
		return false;
	}
}
