import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_2261_경로찾기 { // 제출일 2021-06-02 23:35

	static int n, k, a, b;
	static String ans;
	static char[][] codes;
	static List<List<Integer>> path;
	static boolean[] visited;

	static class Node {
		int idx;
		ArrayList<Integer> order;

		public Node() {
		}

		public Node(int idx, ArrayList<Integer> order) {
			super();
			this.idx = idx;
			this.order = order;
			this.order.add(idx);
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
		n = Integer.parseInt(st.nextToken()); // 3 이상 1천 이하
		k = Integer.parseInt(st.nextToken()); // 2 이상 30 이하

		codes = new char[n][];
		for (int i = 0; i < n; i++) {
			codes[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()) - 1;
		b = Integer.parseInt(st.nextToken()) - 1;

		path = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			path.add(new LinkedList<>());
		}

		visited = new boolean[n];
		ans = null;

	}

	// n개의 이진 코드에 대해 서로에 대한 해밍 거리를 구한 뒤
	// a에서 b까지의 가장 짧은 해밍 경로를 구하라
	private static void go() {

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (getHamingLength(i, j) == 1) {
					path.get(i).add(j);
					path.get(j).add(i);
				}
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(a, new ArrayList<>()));
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (!visited[node.idx]) {
				visited[node.idx] = true;
				if (node.idx == b) {
					print(node.order);
					return;
				}
				for (int next : path.get(node.idx)) {
					q.add(new Node(next, (ArrayList<Integer>) node.order.clone()));
				}
			}
		}

	}

	private static void print(ArrayList<Integer> order) {

		StringBuilder sb = new StringBuilder();
		for (int o : order) {
			sb.append(o + 1).append(' ');
		}
		ans = sb.toString().trim();
	}

	private static int getHamingLength(int i, int j) {
		int cnt = 0;
		for (int idx = 0; idx < k; idx++) {
			if (codes[i][idx] != codes[j][idx]) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append((ans == null) ? -1 : ans);
		bw.write(sb.toString());
		bw.flush();
	}

}