import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_JO_1516_단어세기 { // 제출일 2021-03-12 23:40

	static class Node {
		String s;
		int i;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(String s, int i) {
			super();
			this.s = s;
			this.i = i;
		}

		@Override
		public String toString() {
			return String.format("%s : %d\n", this.s, this.i);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String a = br.readLine();
		while (!a.contentEquals("END")) {
			st = new StringTokenizer(a);
			HashMap<String, Integer> map = new HashMap<>();
			while (st.hasMoreTokens()) {
				String b = st.nextToken();
				if (map.containsKey(b)) {
					map.put(b, map.get(b) + 1);
				} else {
					map.put(b, 1);
				}
			}
			// string 아스키코드 순서로 출력
			LinkedList<Node> li = new LinkedList<>();
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				li.add(new Node(entry.getKey(), entry.getValue()));
			}
			Collections.sort(li, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.s.compareTo(o2.s);
				}
			});
			for (Node node : li) {
				sb.append(node);
			}
			a = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
	}

}