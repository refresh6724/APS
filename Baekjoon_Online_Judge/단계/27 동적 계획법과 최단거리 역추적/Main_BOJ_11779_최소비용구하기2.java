import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 백준 11779 최소비용 구하기 2
public class Main { // 제출일 2019-10-10 14:37
	static int N;
	static int M;

	static class Edge implements Comparable<Edge> {

		int to;
		int weight;

		public Edge(int to, int weight) {
			super();

			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	static ArrayList<ArrayList<Edge>> adj = null;
	static ArrayList<Edge> list = null;
	static long[] dist;
	static int[] via;
	static long inf = Long.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list = new ArrayList<>();
			adj.add(list);
		}
		dist = new long[N];
		via = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Edge(to, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		dijk(start);
		System.out.println(dist[end]);
		ArrayList<Integer> ret = new ArrayList<>();
		while (end != start) {
			ret.add(end);
			end = via[end];
		}
		ret.add(start);
		System.out.println(ret.size());
		Collections.reverse(ret);
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i) + 1 + " ");
		}
	}

	private static void dijk(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(dist, inf);
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int next = e.to;
			int weight = e.weight;
			if (dist[next] < weight)
				continue;
			for (int i = 0; i < adj.get(next).size(); i++) {
				int nextnext = adj.get(next).get(i).to;
				int nextweight = adj.get(next).get(i).weight + weight;
				if (dist[nextnext] > nextweight) {
					dist[nextnext] = nextweight;
					via[nextnext] = next;
					pq.add(new Edge(nextnext, nextweight));
				}
			}
		}
	}
}