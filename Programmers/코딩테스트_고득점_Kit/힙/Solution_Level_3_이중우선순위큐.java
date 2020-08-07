import java.util.Arrays;

public class Solution_Level_3_이중우선순위큐 { // 제출일 2020-08-08 01:20

	public static int[] solution(String[] operations) {

		// 단순히 보면 Double LinkedList 에 head와 tail을 관리하면 될 것 같다
		// I num => 삽입
		// D 1 => 최댓값 head 삭제
		// D -1 => 최솟값 tail 삭제
		// 이렇게 짜면 최솟값이 반복적으로 삽입되는 경우가 최악의 경우가 된다

		MyDoublePriorityQueue dpq = new MyDoublePriorityQueue();
		dpq.init();

		for (String operation : operations) {
			if (operation.charAt(0) == 'I') { // 삽입
				int num = Integer.parseInt(operation.substring(2));
				dpq.insert(num);
			} else {
				if (operation.charAt(2) == '1') { // 최댓값 삭제
					dpq.deleteMax();
				} else { // 최솟값 삭제
					dpq.deleteMin();
				}
			}
		}

		if(dpq.size == 0) {
			return new int[] {0, 0};
		}			
		return new int[] { dpq.head.next.data, dpq.tail.prev.data };

	}

	static class Node {
		int data;
		Node prev;
		Node next;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}
	}

	static class MyDoublePriorityQueue {
		Node head;
		Node tail;
		int size;

		public MyDoublePriorityQueue() {
			this.size = 0;
		}

		public void init() {
			this.head = new Node(Integer.MAX_VALUE);
			this.tail = new Node(Integer.MIN_VALUE);
			this.head.next = tail;
			this.tail.next = head;
			this.head.prev = tail;
			this.tail.prev = head;
		}

		public void insert(int data) {
			Node node = new Node(data);
			Node compare = head.next;
			while(compare.data > data) {
				compare = compare.next;
			}
			
			// 기존 대상의 이전 노드를 현재 노드의 이전 노드로 바꾸고
			// 이전 노드의 다음 대상을 현재 노드로 변환
			node.prev = compare.prev;
			node.prev.next = node;
			
			node.next = compare;
			compare.prev = node;	
			
			this.size++;
		}
		
		public void deleteMax() {
			if(this.size != 0) {
				Node node = head.next;
				node.next.prev = head;
				head.next = node.next;
				this.size--;
			}
		}
		
		public void deleteMin() {
			if(this.size != 0) {
				Node node = tail.prev;
				node.prev.next = tail;
				tail.prev = node.prev;
				this.size--;
			}
		}
	}

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "I 16", "D 1" }))); // {0, 0}
		System.out.println(Arrays.toString(solution(new String[] { "I 7", "I 5", "I -5", "D -1" }))); // {7, 5}
	}
}