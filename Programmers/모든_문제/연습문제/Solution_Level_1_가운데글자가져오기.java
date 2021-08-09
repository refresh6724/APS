public class Solution_Level_1_가운데글자가져오기 { // 제출일 2021-08-09 23:15

	public String solution(String s) {
		int len = s.length();
		return s.substring((len - 1) / 2, len / 2 + 1);
	}
}
