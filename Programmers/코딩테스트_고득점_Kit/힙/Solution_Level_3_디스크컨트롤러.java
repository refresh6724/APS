import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution_Level_3_디스크컨트롤러 { // 제출일 2020-08-07 14:55

	static MyHeap myheap = new MyHeap();
	static PriorityQueue<Work> pq = new PriorityQueue<>();
	static int len;

	public static int solution(int[][] jobs) {
		
		len = jobs.length;

		for (int i = 0; i < len; i++) {
			pq.add(new Work(jobs[i][0], jobs[i][1]));
		}

		// FCFS와 SJF 방식 중 최소 시간을 구하라
//		int FCFS = first_come_first_serve(jobs);
//		int SJF = shortest_job_first(jobs);
		int SJF2 = shotest_job_first_2();

		return SJF2;
	}

	private static int first_come_first_serve(final int[][] jobs) {

		// jobs가 요청 시간에 대해 정렬 되어 있다는 가정하에
		int sum = 0;
		int next_start = 0;
		int next_end = 0;
		int prev_start = jobs[0][0];
		int prev_end = jobs[0][0] + jobs[0][1];
		sum += jobs[0][1];

		for (int i = 1; i < jobs.length; i++) {
			next_start = (prev_end > jobs[i][0]) ? prev_end : jobs[i][0]; // 이전에 끝난 시간과 다음 작업의 시작 시간 중 더 늦은 시간
			next_end = next_start + jobs[i][1];
			prev_start = next_start;
			prev_end = next_end;
			sum += next_end - jobs[i][0];
		}
		return sum / jobs.length;
	}

	private static int shortest_job_first(final int[][] jobs) {

		// jobs가 요청 시간에 대해 정렬 되어 있다는 가정하에
		// 걸리는 시간을 기준으로 하는 힙
		myheap.init();
		int sum = 0;
		int time = jobs[0][0];
		int idx = 0;
		Work work;

		while (idx != jobs.length) {
			while (idx != jobs.length && jobs[idx][0] <= time) {
				myheap.push(new Work(jobs[idx][0], jobs[idx][1]));
				idx++;
			}
			if (!myheap.isEmpty()) {
				work = myheap.pop();
				time += work.time;
				sum += time - work.request;
			} else {
				time++;
			}
		}

		while (!myheap.isEmpty()) {
			work = myheap.pop();
			time += work.time;
			sum += time - work.request;
		}

		return sum / jobs.length;
	}

	private static int shotest_job_first_2() {
		//
		// 걸리는 시간을 기준으로 하는 힙
		myheap.init();
		int sum = 0;
		int time = pq.peek().request;
		int cnt = 0;
		Work work;

		while (cnt != len) {
			while (!pq.isEmpty() && pq.peek().request <= time) {
				myheap.push(pq.poll());				
			}
			if (!myheap.isEmpty()) {
				work = myheap.pop();
				time += work.time;
				sum += time - work.request;
				cnt++;
			} else {
				time++;
			}
		}

		return sum / len;
	}

	static class Work implements Comparable<Work> {
		int request;
		int time;

		public Work(int request, int time) {
			super();
			this.request = request;
			this.time = time;
		}

		@Override
		public int compareTo(Work o) {
			// request 오름차순 
			// 같으면 time 오름차순
			if (this.request==o.request) {
				return this.time - o.time; // time 오름차순
			} else {
				return this.request-o.request; // request 오름차순
			}
		}
	}

	static class MyHeap {
		public ArrayList<Work> heapArr;
		public int heapIdx;

		public MyHeap() {

		}

		public void init() {
			heapIdx = 0;
			heapArr = new ArrayList<Work>(500); // jobs의 길이는 500 이하
			for (int i = 0; i < 500; i++) {
				heapArr.add(new Work(0, 0));
			}
		}

		public int size() {
			return heapIdx;
		}

		public void push(Work work) {
			heapArr.add(++heapIdx, work);
			int child = heapIdx;
			int parent = child >> 1;
			while (child > 1 && heapArr.get(parent).time > heapArr.get(child).time) { // 최소 <=> 최대
				// 최대 힙인 경우 parent가 child보다 커야 하므로 parent < child 일때 swap
				// 최소 힙인 경우 parent가 child보다 작아야 하므로 parent > child 일때 swap
				swap(parent, child);
				child = parent;
				parent = child >> 1;
			}
		}

		private void swap(int parent, int child) {
			Work tmp = heapArr.get(parent);
			heapArr.set(parent, heapArr.get(child));
			heapArr.set(child, tmp);
		}

		public Work pop() {
			if (heapIdx == 0) {
				return new Work(-1, -1);
			} else if (heapIdx == 1) {
				heapIdx = 0;
				return heapArr.get(1);
			}

			Work ret = heapArr.get(1);

			swap(1, heapIdx);
			heapIdx--;
			int parent = 1;
			int child = compare(parent);

			while (child <= heapIdx && heapArr.get(parent).time > heapArr.get(child).time) { // 최소 <=> 최대
				swap(parent, child);
				parent = child;
				child = compare(parent);
			}

			return ret;
		}

		public Work peek() {
			if (heapIdx == 0) {
				return new Work(-1, -1);
			} else {
				return heapArr.get(1);
			}
		}

		private int compare(int parent) {
			int left = parent << 1;
			int right = left + 1;
			if (right <= heapIdx) {
				if (heapArr.get(left).time < heapArr.get(right).time) { // 최소 <=> 최대
					return left;
				} else {
					return right;
				}
			}
			return left;
		}

		public boolean isEmpty() {
			return (heapIdx == 0);
		}
	}

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } })); // 9
		System.out.println(solution(new int[][] { { 1, 1 }, { 3, 1 }, { 5, 1 } })); // 1
		System.out.println(solution(new int[][] { { 1, 10 }, { 3, 20 }, { 5, 1 } })); // 15

		System.out.println(solution(new int[][] { { 0, 3 }, { 4, 3 }, { 8, 3 } })); // 3
		System.out.println(solution(new int[][] { { 0, 5 }, { 6, 1 }, { 6, 2 } })); // 3
		System.out.println(solution(new int[][] { { 0, 5 }, { 6, 2 }, { 6, 1 } })); // 3
		System.out.println(solution(new int[][] { { 0, 5 }, { 2, 2 }, { 5, 3 } })); // 5
		System.out.println(solution(new int[][] { { 0, 5 }, { 2, 2 }, { 4, 2 } })); // 5

		System.out.println(solution(new int[][] { { 0, 3 }, { 4, 3 }, { 10, 3 } })); // 3
		System.out.println(solution(new int[][] { { 0, 10 }, { 2, 3 }, { 9, 3 } })); // 9
		System.out.println(solution(new int[][] { { 1, 10 }, { 3, 3 }, { 10, 3 } })); // 9
		System.out.println(solution(new int[][] { { 0, 10 } })); // 10
		System.out.println(solution(new int[][] { { 0, 10 }, { 4, 10 }, { 5, 11 }, { 15, 2 } })); // 15
	}
}