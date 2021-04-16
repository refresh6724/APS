import java.util.Stack;

public class Solution_Level_2_괄호회전하기 { // 제출일 2021-04-16 22:36

	// test
	public static void main(String[] args) {
		System.out.println(solution("[](){}")); // 3
		System.out.println(solution("}]()[{")); // 2
		System.out.println(solution("[)(]")); // 0
		System.out.println(solution("}}}")); // 0

		System.out.println(solution("(")); // 0
		System.out.println(solution("([")); // 0
		System.out.println(solution("([{")); // 0
		System.out.println(solution("([])")); // 1
		System.out.println(solution("([)(])")); // 0

//		System.out.println(solution("}{")); // 1
//		System.out.println(solution("}{()")); // 1
//		System.out.println(solution("[{()}]")); // 1
//		System.out.println(solution(")}][{(")); // 1
//		System.out.println(solution(")}][{()}][{()}][{(")); // 3
//		System.out.println(solution("[{{}}{()}(()){()()}]")); // 1
//		System.out.println(solution("[{[{[{[{[{}]}]}]}]}]")); // 1
	}

	// 규칙 1 () {} [] 는 모두 올바른 괄호 문자열
	// 규칙 2 A가 올바른 괄호 문자열이라면 (A) {A} [A] 역시 올바른 괄호 문자열
	// 규칙 3 A, B가 올바른 괄호 문자열 이라면 AB도 올바른 괄호 문자열

	/**
	 * 대괄호, 중괄호, 소괄호로 이루어진 문자열 s <br>
	 * 왼쪽으로 x칸 만큼 회전시켰을 때 올바른 괄호 문자열이 되는 x의 개수<br>
	 * x는 0 이상 s 미만<br>
	 * 
	 * @param s 길이는 1천 이하
	 * @return 올바른 괄호 문자열이 되는 x의 개수
	 */
	public static int solution(String s) {

		int cnt = -1;
		for (int x = 0; x < s.length(); x++) {
			cnt = prove(s.substring(x).concat(s.substring(0, x)));
			if (cnt != -1) {
				break;
			}
		}

		return (cnt == -1) ? 0 : cnt;
	}

	private static int prove(String concat) {

//		System.out.println(concat);

		int cnt = 0;
		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < concat.length(); i++) {
			switch (concat.charAt(i)) {
			case '(':
				s.push('(');
				break;
			case ')':
				if (s.isEmpty() || s.peek() != '(') {
					return -1;
				}
				s.pop();
				if (s.isEmpty()) {
					cnt++;
				}
				break;
			case '{':
				s.push('{');
				break;
			case '}':
				if (s.isEmpty() || s.peek() != '{') {
					return -1;
				}
				s.pop();
				if (s.isEmpty()) {
					cnt++;
				}
				break;
			case '[':
				s.push('[');
				break;
			case ']':
				if (s.isEmpty() || s.peek() != '[') {
					return -1;
				}
				s.pop();
				if (s.isEmpty()) {
					cnt++;
				}
				break;
			}
		}

		return cnt;
	}
}
