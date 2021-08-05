import java.util.stream.Stream;

public class Solution_Level_1_문자열내p와y의개수 { // 제출일 2021-08-05 23:54

	// test
	public static void main(String[] args) {
		System.out.println(solution("pP0000yY")); // true
		System.out.println(solution("Pyy")); // false
	}

	/**
	 * @param s 영어 대소문자로 구성된 길이 50 이하의 문자열
	 * @return p,P 의 개수와 y,Y의 개수가 같으면 true 아니면 false 리턴
	 */
	public static boolean solution(String s) {
		String[] ss = s.toLowerCase().split("");
		long p = Stream.of(ss).filter(c -> c.startsWith("p")).count();
		long y = Stream.of(ss).filter(c -> c.startsWith("y")).count();
		return p == y; // 다소 억지스럽게 스트림을 써봤다
	}
}
