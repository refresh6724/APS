import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_1440_가까운공통조상찾기 { // 제출일 2021-07-10 23:56

	static int n;
	static int[] parent;
	static List<List<Integer>> tree;

	// Lowest Common Ancestor
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim());
		parent = new int[n + 1]; // 루트의 부모는 0이 된다 !!
		tree = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			parent[b] = a; // b의 부모는 a
			tree.get(a).add(b); // a의 자식 b
		}

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		sb.append(lca(a, b));

		bw.write(sb.toString());
		bw.flush();

	}

	private static int lca(int a, int b) {

		int a_depth = get_depth(a);
		int b_depth = get_depth(b);

		if (a_depth > b_depth) {
			while (a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		} else if (a_depth < b_depth) {
			while (a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}

	private static int get_depth(int x) {
		int cnt = 0;
		while (x != 0) {
			cnt++;
			x = parent[x];
		}
		return cnt;
	}

}