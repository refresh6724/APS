import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_Level_1_실패율 { // 제출일 2021-08-19 23:13

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 }))); // 3,4,2,1,5
		System.out.println(Arrays.toString(solution(4, new int[] { 4, 4, 4, 4, 4 }))); // 4,1,2,3
	}

	static class Node implements Comparable<Node> {
		int stage;
		double value;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int stage, double value) {
			super();
			this.stage = stage;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			double diff = o.value - this.value;
			if (diff > 0) {
				return 1;
			} else if (diff < 0) {
				return -1;
			} else {
				return this.stage - o.stage;
			}
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [stage=").append(stage).append(", value=").append(value).append("]");
			return builder.toString();
		}

	}

	public static int[] solution(int N, int[] stages) {

		int len = stages.length;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		int cnt = 0;
		int now = 1;

		Arrays.sort(stages);
		for (int stage : stages) {
			if (stage > N) {
				break;
			}
			if (now != stage) {
				pq.add(new Node(now++, (double) cnt / len));
				len -= cnt;
				while (now < stage) {
					pq.add(new Node(now++, 0));
				}
				if (len == 0) {
					break;
				}
				cnt = 1;
			} else {
				cnt++;
			}
		}
		pq.add(new Node(now++, (double) cnt / len));
		while (now <= N) {
			pq.add(new Node(now++, 0));
		}

		int[] ret = new int[N];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = pq.poll().stage;
		}
		return ret;
	}
}
