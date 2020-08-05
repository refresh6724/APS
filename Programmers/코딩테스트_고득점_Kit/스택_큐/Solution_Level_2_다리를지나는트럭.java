import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_2_다리를지나는트럭 { // 제출일 2020-08-05 23:07
	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// 예제
		// 길이가 2이고 최대 하중 10kg인 다리
		// 7,4,5,6 kg 인 트럭이 지나가려면
		// 0초에는 모두 대기
		// 1초에 7 이 올라가고 4를 더하면 11이 되므로 4는 대기
		// 다리 위는 FIFO로 큐를 사용한다
		// 7이 지나가고 4가 올라감
		// 5가 올라가려 시도하여 10보다 작아서 올라간다
		// 한번 확인 후 다시 넣으면 LIFO여야 하기 때문에 스택을 사용한다

		Queue<Node> bridge = new LinkedList<>();
		int len = truck_weights.length;
		int time = 0;
		int waitIdx = 0;
		int sum = 0;
		int onthebridge = 0;
		Node node;
		while (waitIdx != len || !bridge.isEmpty()) {
			time++;
			onthebridge = bridge.size();
			while (onthebridge-- > 0) {
				node = bridge.poll();
				node.length--;
				if (node.length == 0) {
					sum -= node.weight;
				} else {
					bridge.add(node);
				}
			}

			if (waitIdx != len && sum + truck_weights[waitIdx] <= weight) {
				sum += truck_weights[waitIdx];
				bridge.add(new Node(truck_weights[waitIdx], bridge_length));
				waitIdx++;
			}
		}

		return time;
	}

	static class Node {
		int weight;
		int length;

		public Node(int weight, int length) {
			super();
			this.weight = weight;
			this.length = length;
		}
	}

	// test
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 })); // 8
		System.out.println(solution(100, 100, new int[] { 10 })); // 101
		System.out.println(solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 })); // 100
	}
}