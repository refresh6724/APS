import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1816_외양간 { // 제출일 2021-06-06 05:28

	static int m, s, c;
	static int[] cow;

	static class Node {
		int left;
		int right;
		int gap;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int left, int right, int gap) {
			super();
			this.left = left;
			this.right = right;
			this.gap = gap;
		}

		public int getLen() {
			return right - left + 1;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 최대 판자수 50
		s = Integer.parseInt(st.nextToken()); // 총 외양간 200
		c = Integer.parseInt(st.nextToken()); // 소가 있는 곳과 각 번호
		cow = new int[c];
		for (int i = 0; i < c; i++) {
			cow[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.parallelSort(cow);

		// 소가 들어있는 곳을 M개의 판자로 막을 때 판자의 총 길이가 최소화 되도록
//		solution_1();
		solution_2();

	}

	private static void solution_2() {

		// 판자 개수가 소가 있는 방보다 많을 경우 1칸에 1개씩 사용 가능하므로 c가 된다
		if (m >= c) {
			System.out.println(c);
			return;
		}

		// 계차 수열
		int[] diff = new int[c - 1];
		for (int i = 1; i < c; i++) {
			diff[i - 1] = cow[i] - cow[i - 1] - 1; // 두 칸 사이에 소가 없는 길이
		}

		int left = cow[0];
		int right = cow[c - 1];
		int maxLen = right - left + 1;

		Arrays.parallelSort(diff);
		// 1개의 판자 최대 길이에서 갭이 큰 순서대로 빼서 분리한다고 생각하자
		for (int i = 1; i < m; i++) {
			maxLen -= diff[c - 1 - i];
		}
		System.out.println(maxLen);
	}

	// 시간 초과 Time Limit Exceed(70) 95,908 KB 1900 ms
	private static void solution_1() {

		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < c; i++) {
			q.add(new Node(cow[i], cow[i], 1));
		}

		while (q.size() > m) {

			Node left = q.poll();
			Node right = q.peek();
			if (left.right + left.gap == right.left) {
				q.poll();
				q.add(new Node(left.left, right.right, right.gap));
			} else {
				left.gap++;
				q.add(left);
			}
		}

		int ans = 0;
		while (!q.isEmpty()) {
			ans += q.poll().getLen();
		}
		System.out.println(ans);
	}

}