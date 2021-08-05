import java.util.Arrays;

public class Solution_Level_1_문자열내림차순으로배치하기 { // 제출일 2021-08-05 23:03

	// test
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg")); // "gfedcbZ"
	}

	/**
	 * @param s 영어 대소문자로 구성된 문자열
	 * @return 문자를 큰 것부터 작은 순으로 정렬해 새로운 문자열을 리턴
	 */
	public static String solution(String s) {
		char[] cs = s.toCharArray();
		Arrays.sort(cs);
		return new StringBuilder(String.valueOf(cs)).reverse().toString();
	}
}
