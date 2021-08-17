import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_2_수식최대화 { // 제출일 2021-08-17 23:46

	// test
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20")); // 60420
		System.out.println(solution("50*6-3*2")); // 300
	}

	static String[][] orders = new String[][] { { "\\+", "-", "\\*" }, { "\\+", "\\*", "-" }, { "-", "\\+", "\\*" }, { "-", "\\*", "\\+" }, { "\\*", "-", "\\+" }, { "\\*", "\\+", "-" } };

	public static long solution(String expression) {

		long max = 0;
		for (int i = 0; i < 6; i++) {
			max = Math.max(max, calc(expression, orders[i]));
		}
		return max;
	}

	private static long calc(String expression, String[] order) {

		Queue<Long> q1 = new LinkedList<>();
		String[] first = expression.split(order[0]);
		for (String exp1 : first) {
			Queue<Long> q2 = new LinkedList<>();
			String[] second = exp1.split(order[1]);
			for (String exp2 : second) {
				Queue<Long> q3 = new LinkedList<>();
				String[] third = exp2.split(order[2]);
				for (String exp3 : third) {
					q3.add(Long.parseLong(exp3));
				}
				long end = q3.poll();
				while (!q3.isEmpty()) {
					end = sub(order[2], end, q3.poll());
				}
				q2.add(end);
			}
			long mid = q2.poll();
			while (!q2.isEmpty()) {
				mid = sub(order[1], mid, q2.poll());
			}
			q1.add(mid);
		}
		long start = q1.poll();
		while (!q1.isEmpty()) {
			start = sub(order[0], start, q1.poll());
		}
		return Math.abs(start);
	}

	private static long sub(String order, long a, long b) {
		switch (order) {
		case "\\+":
			return a + b;

		case "-":
			return a - b;

		case "\\*":
			return a * b;
		}
		return b;
	}
}
