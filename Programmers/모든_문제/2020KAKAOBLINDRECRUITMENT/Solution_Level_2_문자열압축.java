import java.util.Deque;
import java.util.LinkedList;

public class Solution_Level_2_문자열압축 { // 제출일 2021-08-24 23:31

	// test
	public static void main(String[] args) {
		System.out.println(solution("aaaaa")); // 2
		System.out.println(solution("aabbaccc")); // 7
		System.out.println(solution("ababcdcdababcdcd")); // 9
		System.out.println(solution("abcabcdede")); // 8
		System.out.println(solution("abcabcabcabcdededededede")); // 14
		System.out.println(solution("xababcdcdababcdcd")); // 17
	}

	static class Node {
		String piece;
		int stack;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(String piece, int stack) {
			super();
			this.piece = piece;
			this.stack = stack;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [piece=").append(piece).append(", stack=").append(stack).append("]");
			return builder.toString();
		}

	}

	public static int solution(String s) {

		int len = s.length();
		int maxCompact = len / 2; // 압축 가능한 최대 크기
		int min = len; // 압축이 불가능한 경우
		Deque<Node> q = new LinkedList<>();
		for (int i = 1; i <= maxCompact; i++) {
			int start = 0;
			while (start + i <= len) {
				if (!q.isEmpty() && q.peekLast().piece.equals(s.substring(start, start + i))) {
					q.peekLast().stack++;
				} else {
					q.add(new Node(s.substring(start, start + i), 1));
				}
				start += i;
			}
			int now = len - start;
			while (!q.isEmpty()) {
				Node node = q.poll();
				if (node.stack != 1) {
					now += Integer.toString(node.stack).length();
				}
				now += i;
			}
			min = Math.min(min, now);
		}
		return min;
	}
}
