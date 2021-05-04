import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_JO_1328_빌딩 { // 제출일 2021-05-04 20:55

	static class Node {
		int height;
		int idx;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int height, int idx) {
			super();
			this.height = height;
			this.idx = idx;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// 자신의 오른쪽에서 자신보다 크면서 가장 가까운 위치, 없다면 0
		int n = Integer.parseInt(br.readLine().trim()); // 10만
		int[] h = new int[n];
		int[] o = new int[n];

		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(br.readLine().trim()); // 100만
		}

		Stack<Node> stk = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stk.isEmpty() && stk.peek().height <= h[i]) {
				stk.pop();
			}
			if (stk.isEmpty()) {
				o[i] = 0;
			} else {
				o[i] = stk.peek().idx;
			}
			stk.add(new Node(h[i], i + 1));
		}

		for (int i = 0; i < o.length; i++) {
			sb.append(o[i]).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}