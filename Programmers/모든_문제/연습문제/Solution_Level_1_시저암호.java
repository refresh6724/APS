public class Solution_Level_1_시저암호 { // 제출일 2021-07-30 23:30

	public static void main(String[] args) {
		System.out.println(solution("AB", 1)); // "BC"
		System.out.println(solution("z", 1)); // "a"
		System.out.println(solution("a B z", 4)); // "e F d"
	}

	public static String solution(String s, int n) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != ' ') {
				if (Character.isLowerCase(cs[i])) {
					cs[i] += n;
					if (cs[i] > 'z') {
						cs[i] -= 26;
					}
				} else {
					cs[i] += n;
					if (cs[i] > 'Z') {
						cs[i] -= 26;
					}
				}
			}
		}
		return String.valueOf(cs);
	}
}
