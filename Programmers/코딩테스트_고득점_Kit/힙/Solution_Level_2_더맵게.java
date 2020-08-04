public class Solution_Level_2_더맵게 { // 제출일 2020-08-04 19:07
	public static int solution(int[] scoville, int K) {

		// scoville 길이 2이상 백만 이하
		// 각 원소는 0 이상 백만 이하
		// K 0이상 10억 이하

		MyHeap myheap = new MyHeap();
		myheap.init();
		for (int i = 0; i < scoville.length; i++) {
			myheap.push(scoville[i]);
		}

		int answer = 0;
		while (myheap.size() > 1 && myheap.peek() < K) {
			int val = myheap.pop() + (myheap.pop() << 1);
			myheap.push(val);
			answer++;
		}
		
		if(myheap.peek() < K) {
			return -1;
		}
		return answer;
	}

	static class MyHeap {
		public int[] heapArr = new int[1000001];
		public int heapIdx;

		public MyHeap() {

		}

		public void init() {
			heapIdx = 0;
		}

		public int size() {
			return heapIdx;
		}

		public void push(int data) {
			heapArr[++heapIdx] = data;
			int child = heapIdx;
			int parent = child >> 1;
			while (child > 1 && heapArr[parent] > heapArr[child]) { // 최소 <=> 최대
				// 최대 힙인 경우 parent가 child보다 커야 하므로 parent < child 일때 swap
				// 최소 힙인 경우 parent가 child보다 작아야 하므로 parent > child 일때 swap
				swap(parent, child);
				child = parent;
				parent = child >> 1;
			}
		}

		private void swap(int parent, int child) {
			int tmp = heapArr[parent];
			heapArr[parent] = heapArr[child];
			heapArr[child] = tmp;
		}

		public int pop() {
			if (heapIdx == 0) {
				return -1;
			} else if (heapIdx == 1) {
				heapIdx = 0;
				return heapArr[1];
			}

			int ret = heapArr[1];

			swap(1, heapIdx);
			heapIdx--;
			int parent = 1;
			int child = compare(parent);

			while (child <= heapIdx && heapArr[parent] > heapArr[child]) { // 최소 <=> 최대
				swap(parent, child);
				parent = child;
				child = compare(parent);
			}

			return ret;
		}

		public int peek() {
			if (heapIdx == 0) {
				return -1;
			} else {
				return heapArr[1];
			}
		}

		private int compare(int parent) {
			int left = parent << 1;
			int right = left + 1;
			if (right <= heapIdx) {
				if (heapArr[left] < heapArr[right]) { // 최소 <=> 최대
					return left;
				} else {
					return right;
				}
			}
			return left;
		}
	}

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7)); // 2
	}
}