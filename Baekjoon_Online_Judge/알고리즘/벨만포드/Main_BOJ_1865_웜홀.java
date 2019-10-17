import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1865_웜홀 { // 제출일 2019-10-17 16:23

	static int count, edgeCount, wormholeCount;
	static final int INF = Integer.MAX_VALUE/3;
	static int[] distance;
	static Edge[] edges;

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			count = sc.nextInt();
			edgeCount = sc.nextInt();
			wormholeCount = sc.nextInt();
			distance = new int[count];
			int edgesize = 2*edgeCount + wormholeCount;
			edges = new Edge[edgesize];
			int a = 0;
			int b = 0;
			int c = 0;
			for (int i = 0; i < 2*edgeCount; ) {
				a = sc.nextInt() -1;
				b = sc.nextInt() -1;
				c = sc.nextInt();
				edges[i++] = new Edge(a,b,c);
				edges[i++] = new Edge(b,a,c);
			}
			for (int i = 2*edgeCount; i < edgesize; i++) {
				a = sc.nextInt() -1;
				b = sc.nextInt() -1;
				c = sc.nextInt() * (-1);
				edges[i] = new Edge(a,b,c);
			}
			Arrays.fill(distance, INF);
			distance[0] = 0;
			if (goNegativeCycle()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean goNegativeCycle() {
		// 간선리스트를 N-1번(음수싸이클 확인 : N번) 반복하며 간선완화 작업
		for (int i = 1; i <= count; ++i) {	
			boolean flag = true;
			for (Edge e : edges) {
				if (distance[e.from] == INF)
					continue; // 1번도시에서 from까지 최소비용이 INF이면 다음 간선
				if (distance[e.to] > distance[e.from] + e.weight) {
					distance[e.to] = distance[e.from] + e.weight;
					flag = false;
					if (i == count)
						return true; // 음수싸이클
				}
			}
			if(flag) return false;
		}
		return false;
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();

		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
