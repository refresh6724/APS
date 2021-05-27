import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스 { // 제출일 2020-12-06 23:23

	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 100 이하

		List<List<Integer>> edges = new LinkedList<>();
		for (int i = 0; i <= n; i++) {
			edges.add(new LinkedList<Integer>());
		}
		int edge = Integer.parseInt(br.readLine()); // 간선의 수
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges.get(a).add(b);
			edges.get(b).add(a);
		}

		cnt = 0;
		visited = new boolean[n + 1];
		bfs(edges);

		bw.write(Integer.toString(cnt - 1));
		bw.flush();
	}

	private static void bfs(List<List<Integer>> edges) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (!visited[now]) {
				visited[now] = true;
				cnt++;
				for (int next : edges.get(now)) {
					q.add(next);
				}
			}
		}
	}
}
