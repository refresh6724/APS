import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_Level_2_짝지어제거하기 { // 제출일 2020-08-10 22:46

	// test
	public static void main(String[] args) {
		System.out.println(solution("baabaa")); // 1
		System.out.println(solution("cdcd")); // 0
	}

	public static int solution(String s) {
		// s 는 최대 100만 자
		// 수행 가능이면 1 불가능이면 0 반환

		// return try_and_error_1(s); 정확성 7 /13 (3 ~ 8) 효율성 1/8 (1,3~8) 	35.3/100
		// return try_and_error_2(s); 정확성 10/13 (3,4,5) 효율성 2/8 (3~8) 		55.2/100
		return try_and_error_3(s); // 정확성 13/13			 효율성 8/8			100 /100
	}

	private static int try_and_error_3(String s) {

		// LIFO => Stack 사용

		Stack<Integer> st = new Stack<>();
		Queue<Integer> qu = new LinkedList<>();

		// 첫번째 입력
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			num = s.charAt(i);
			if (!st.isEmpty() && st.peek() == num) {
				st.pop();
			} else {
				st.add(num);
			}
		}

		// 두번째 꺼내서 넣기
		int quSize = 0;
		int stSize = 0;
		while (quSize != st.size()) {
			num = 0;
			stSize = st.size();
			for (int i = 0; i < stSize; i++) {
				qu.add(st.pop());
			}

			quSize = qu.size();
			for (int i = 0; i < quSize; i++) {
				num = i;
				if (!st.isEmpty() && st.peek() == num) {
					st.pop();
				} else {
					st.add(i);
				}
			}
		}

		if (st.size() == 0) {
			return 1;
		}
		return 0;
	}

	private static int try_and_error_2(String s) {

		// 완전 탐색 arr & idx 사용

		char[] arr = s.toCharArray();
		int len = arr.length;

		// 4. len을 전부 이동하는 동안 같은 곳이 없었다면 0을 리턴한다, 모두 없앴다면 1을 리턴한다
		int cnt = 1;
		int sum = 0;
		int left = 0;
		int right = 0;
		int last = 0;
		boolean find = false;

		loop: while (cnt != 0) {

			cnt = 0;

			for (left = 0; left < len; left++) {
				if (arr[left] != 0) {
					break;
				}
			}
			for (right = left + 1; right < len; right++) {
				if (arr[right] != 0) {
					break;
				}
			}

			while (left < len && right < len) {

				// 2. 같은지 확인한다
				// 둘이 같다면 0으로 바꾼다
				while (left >= 0 && right < len && arr[left] == arr[right]) {
					arr[left--] = 0;
					arr[right++] = 0;
					find = true;
					last = right;
					cnt++;
					sum++;
					// 3. 같으면 지우고 같지 않으면 1번으로 돌아간다
					// 둘이 다르다면 한칸만 이동하여 left와 right의 새로운 위치를 확정한다
				}

				// 1. left와 right 위치를 정한다
				// 0과 1로 시작
				while (right < len) {
					if (find) {
						left = last;
						find = false;
					} else {
						left = right;
					}
					for (right = left + 1; right < len; right++) {
						if (arr[right] != 0) {
							break;
						}
					}
					if (right >= len) {
						continue loop;
					} else {
						break;
					}

				}
			}

		}

		if ((sum << 1) != len) {
			return 0;
		} else {
			return 1;
		}

	}

	private static int try_and_error_1(String s) {

		// FIFO => Queue 사용

		int left = 0;
		int right = 0;

		Queue<Integer> q = new LinkedList<>();

		left = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			right = s.charAt(i);
			if (left == right) {
				i++;
				right = 0;
				if (i < s.length()) {
					left = s.charAt(i);
				} else {
					left = 0;
				}
			} else {
				q.add(left);
				left = right;
				right = 0;
			}
		}
		if (left != 0) {
			q.add(left);
			left = 0;
		}

		int size = 0;
		int cnt = 1;

		while (cnt != 0 && q.size() != 0) {
			cnt = 0;
			size = q.size();
			left = q.poll();
			for (int i = 1; i < size; i++) {
				right = q.poll();
				if (left == right) {
					cnt++;
					i++;
					right = 0;
					if (i < size) {
						left = q.poll();
					} else {
						left = 0;
					}
				} else {
					q.add(left);
					left = right;
					right = 0;
				}
			}
			if (left != 0) {
				q.add(left);
				left = 0;
			}
		}

		if (q.size() != 0) {
			return 0;
		} else {
			return 1;
		}
	}
}