public class Solution_Level_2_JadenCase문자열만들기 { // 제출일 2021-11-08 23:17

	// test
	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me")); // "3people Unfollowed Me"
		System.out.println(solution("for the last week")); // "For The Last Week"
		System.out.println(solution("a  3b  c d")); // "A  3b  C D"
		System.out.println(solution(" ")); // " "
	}

	public static String solution(String s) {
		char[] cs = s.toCharArray();
		boolean beforeSpace = true;
		for (int i = 0; i < cs.length; i++) {
			if (beforeSpace) {
				if (Character.isAlphabetic(cs[i])) {
					beforeSpace = false;
					cs[i] = Character.toUpperCase(cs[i]);
				} else if (cs[i] != ' ') {
					beforeSpace = false;
				}
			} else {
				if (cs[i] == ' ') {
					beforeSpace = true;
				} else {
					cs[i] = Character.toLowerCase(cs[i]);
				}
			}
		}
		return String.copyValueOf(cs);
	}
}