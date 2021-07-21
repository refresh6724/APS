public class Solution_Level_1_핸드폰번호가리기 { // 제출일 2021-07-21 22:38

	public String solution(String phone_number) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int len = phone_number.length() - 4;
		while (idx < len) {
			sb.append(phone_number.charAt(idx++));
		}
		sb.append(phone_number.substring(idx));
		return sb.toString();
	}
}
