import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1021_장난감조립 { // 제출일 2021-03-31 13:01
	
	// ansMap 사용 시 17,036 KB 361 ms
	// ansArr 사용 시 13,116 KB 268 ms
	
	static class Node {
		int key;
		int value;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("%d %d\n", this.key, this.value);
		}
	}

	static int n, m;
	static List<List<Node>> catalogue;
//	static Map<Integer, Integer> ansMap;
	static int[] ansArr;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 3 이상 100 이하 // 완제품
		m = Integer.parseInt(br.readLine()); // 3 이상 100 이하

		catalogue = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			catalogue.add(new LinkedList<Node>());
		}
//		ansMap = new HashMap<>();
		ansArr = new int[n];

		StringTokenizer st = null;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			catalogue.get(x).add(new Node(y, k));
		}

	}

	private static void go() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(n, 1));
		while (!q.isEmpty()) {
			Node p = q.poll();
			if (catalogue.get(p.key).size() == 0) { // 서브 파츠가 없는 기초 부품이면
				ansArr[p.key] += p.value;
//				if(ansMap.containsKey(p.key)) {
//					ansMap.put(p.key, ansMap.get(p.key) + p.value);
//				} else {
//					ansMap.put(p.key, p.value);
//				}
			} else {
				for (Node node : catalogue.get(p.key)) {
					q.add(new Node(node.key, p.value * node.value));
				}
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

//		ArrayList<Node> ans = new ArrayList<>(ansMap.size());
//		for(Entry<Integer, Integer> entrySet : ansMap.entrySet()) {
//			ans.add(new Node(entrySet.getKey(), entrySet.getValue()));
//		}
//		
//		Collections.sort(ans, new Comparator<Node>() {
//			@Override
//			public int compare(Node o1, Node o2) {				
//				return o1.key - o2.key;
//			}
//		});
//		
//		for(Node node : ans) {
//			sb.append(node);
//		}

		for (int i = 1; i < n; i++) {
			if (ansArr[i] != 0) {
				sb.append(i).append(' ').append(ansArr[i]).append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}