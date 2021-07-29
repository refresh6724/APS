public class Solution_Level_1_이상한문자만들기 { // 제출일 2021-07-29 23:06

	public String solution(String s) {
		// 각 단어의 짝수 인덱스를 대문자, 홀수 인덱스를 소문자로 치환
		char[] cs = s.toCharArray();
		for (int i = 0, j = 0; i < cs.length; i++) {
			if (cs[i] != ' ') {
				if (j++ % 2 == 0) {
					cs[i] = Character.toUpperCase(cs[i]);
				} else {
					cs[i] = Character.toLowerCase(cs[i]);
				}
			} else {
				j = 0;
			}
		}
		return String.valueOf(cs);
	}
}
