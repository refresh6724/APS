import java.util.Arrays;

public class Solution_Level_2_전화번호목록 { // 제출일 2020-07-31 22:40
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
		// 바로 전 숫자로 시작하는 문자가 있다면 false
		String prev = phone_book[0];
		for (int i = 1; i < phone_book.length; i++) {
			if(phone_book[i].length() >= prev.length() && phone_book[i].substring(0, prev.length()).equals(prev)) {
				return false;
			} else {
				prev = phone_book[i];
			}
		}
		return true;
    }
}