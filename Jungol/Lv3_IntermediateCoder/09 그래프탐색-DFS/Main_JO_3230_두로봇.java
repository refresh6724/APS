import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// ver1 dfs 사용시 stack over flow Runtime Error(47) 610 ms
// ver2 다익스트라 + 경로추적 Time Limit Exceed(94) max 1931 ms
// ver3 리스트에서 배열로 변경 : 시간 변화 없음 Time Limit Exceed(94) max 1933 ms

public class Main_JO_3230_두로봇 { // 제출일 2021-05-28 23:47

	static int n, a, b, ans;
	static List<List<Node>> graph;
	static Node[] graph3;
	static boolean[] visited;
	static boolean find;
	static int[] dist, from;

	static class Node implements Comparable<Node> {
		int dest;
		int weight;
		Node next;

		public Node() {

		}

		public Node(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}

		public Node(int dest, int weight, Node next) {
			this.dest = dest;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return o.weight - this.weight; // 최단 거리 찾기 이므로 최소힙
		}

	}

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();

		n = fr.nextInt(); // 1 이상 10만 이하
		a = fr.nextInt(); // 로봇 1 위치
		b = fr.nextInt(); // 로봇 2 위치
//		graph = new ArrayList<>(n + 1);
//		for (int i = 0; i <= n; i++) {
//			graph.add(new ArrayList<>());
//		}
		graph3 = new Node[n + 1];

		int u = 0;
		int v = 0;
		int w = 0;
		for (int i = 1; i < n; i++) { // 통로 n-1개
			u = fr.nextInt();
			v = fr.nextInt();
			w = fr.nextInt(); // 각 통로의 길이는 1천을 넘지 않는다
//			graph.get(u).add(new Node(v, w));
//			graph.get(v).add(new Node(u, w));
			graph3[u] = new Node(v, w, graph3[u]);
			graph3[v] = new Node(u, w, graph3[v]);
		}

		visited = new boolean[n + 1];
		find = false;
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		from = new int[n + 1];
	}

	private static void go() {
		// a와 b간의 전체 경로 길이를 구하고 그 중 가장 긴 부분의 길이를 뺀다
		// a에서 dfs로 출발하여 매 이동시 가장 길었던 부분의 길이를 기록한다
		// b에 도착하면 종료
		visited[a] = true;
//		dfs(a, 0, 0); 
//		dijk();
		dijk3();
	}

	private static void dijk3() {
		int cnt = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[a] = 0;
		pq.add(new Node(a, 0));
		while (!pq.isEmpty()) {
			Node next = pq.poll();
			visited[next.dest] = true;
			for (Node adj = graph3[next.dest]; adj != null; adj = adj.next) {
				if (!visited[adj.dest]) {
					
					if (dist[adj.dest] > dist[next.dest] + adj.weight) {
						dist[adj.dest] = dist[next.dest] + adj.weight;
						from[adj.dest] = next.dest;
						pq.add(new Node(adj.dest, dist[adj.dest]));
					}
				}
			}
		}

		// from으로 b에서 a로 역추적
		int prev = 0;
		int next = b;
		int max = 0;
		while (prev != a) {
			prev = from[next];
			for (Node path = graph3[prev]; path != null; path = path.next) {
				if (path.dest == next) {
					max = Math.max(max, path.weight);
					break;
				}
			}
			next = prev;
		}
		ans = dist[b] - max;
	}

	private static void dijk() {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[a] = 0;
		pq.add(new Node(a, 0));
		while (!pq.isEmpty()) {
			Node next = pq.poll();
			visited[next.dest] = true;
			for (Node adj : graph.get(next.dest)) {
				if (!visited[adj.dest]) {
					if (dist[adj.dest] > dist[next.dest] + adj.weight) {
						dist[adj.dest] = dist[next.dest] + adj.weight;
						from[adj.dest] = next.dest;
						pq.add(new Node(adj.dest, dist[adj.dest]));
					}
				}
			}
		}

		// from으로 b에서 a로 역추적
		int prev = 0;
		int next = b;
		int max = 0;
		while (prev != a) {
			prev = from[next];
			for (Node path : graph.get(prev)) {
				if (path.dest == next) {
					max = Math.max(max, path.weight);
					break;
				}
			}
			next = prev;
		}
		ans = dist[b] - max;
	}

	private static void dfs(int now, int max, int sum) {
		if (find) {
			return;
		}

		if (now == b) {
			ans = sum - max;
			find = true;
			return;
		}

		for (Node next : graph.get(now)) {
			if (!visited[next.dest]) {
				visited[next.dest] = true;
				dfs(next.dest, Math.max(max, next.weight), sum + next.weight);
				if (find) {
					return;
				}
				visited[next.dest] = false;
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

	// https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	// 4.Using Reader Class:

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}