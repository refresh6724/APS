import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=497&sca=3020
public class Main_JO_1214_히스토그램 { // 제출일 2021-05-13 23:35

	static int n;
	static int[] arr;
	static long ans;

	static class Node implements Comparable<Node> {
		int idx;
		int k;
		int ac;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int idx, int k, int ac) {
			super();
			this.idx = idx;
			this.k = k;
			this.ac = ac;
		}

		@Override
		public int compareTo(Node o) {
			return o.k - this.k;
		}

	}

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 10만
		arr = new int[n + 1]; // arr[n] = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 10억
		}
		ans = 0;
	}

	private static void go() {

		// 접근방법 1 그리디
		// 모든 점에서 확인
		// sigma (i * (100000 - i)) from i=1 to 100000 = 166 666 666 650 000

		// 접근방법 2 그리디
		// 각 점에서 무조건 오른쪽으로 자신보다 작은 수 또는 끝이 나올때까지 진행
		// sigma (i) from i=1 to 100000 = 5 000 050 000

		// 접근방법 3 스택
		// 각 점의 위치와 크기를 저장하고 비교하면서 오른쪽으로 진행
		// O(n)

		// 예제
		// 8 // 4 7 6 8 5 9 1 24
		// 5 * 5 = 25

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < n + 1; i++) {
			int ac = 0;
			while (!pq.isEmpty() && pq.peek().k > arr[i]) {
				Node node = pq.poll();
				ans = Math.max(ans, (long) (i - node.idx + node.ac) * node.k);
				ac = Math.max(ac, i - node.idx + node.ac);
			}
			if (pq.isEmpty() || pq.peek().k != arr[i]) {
				pq.add(new Node(i, arr[i], ac));
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}