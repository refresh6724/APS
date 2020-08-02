import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_2_주식가격 { // 제출일 2020-08-02 21:48
	public static int[] solution(int[] prices) {

		// 예제
		// 1, 2, 3, 2, 3
		// FIFO인 Queue에 하나씩 넣으면서 넣을때보다 낮은 수가 나오는 시점을 기록

		Queue<Node> q = new LinkedList<Node>();
		int value = 0; // 최대 1만
		int maxSize = prices.length; // 최대 10만
		int[] answer = new int[prices.length];
		int qSize = 0;
		Node node;
		for (int i = 0; i < maxSize; i++) {
			value = prices[i];
			qSize = q.size();
			while (qSize-- > 0) {
				node = q.poll();
				node.output++;
				if (node.input <= value) { // 1 <= 2
					q.add(node);
				} else {
					answer[node.idx] = node.output;
				}
			}
			q.add(new Node(i, value, 0));
		}
		qSize = q.size();
		while (qSize-- > 0) {
			node = q.poll();
			answer[node.idx] = node.output;
		}
		return answer;
	}

	static class Node {

		int idx;
		int input;
		int output;

		public Node() {
		}

		public Node(int idx, int input, int output) {
			super();
			this.idx = idx;
			this.input = input;
			this.output = output;
		}

	}

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));
	}
}