import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11657 타임머신
public class Main { // 제출일 2019-10-10 13:18
	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static int count;
	static int edge;
	static int[] distance;
	static Edge[] edges;

	static void calc() {
		count = V;
		edge = E;
		distance = new int[V];
		edges = new Edge[E];
	}

	static int V;
	static int E;
	static int[][] adjMatrix;
	static int[] D;
	static int inf = Integer.MAX_VALUE / 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjMatrix = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) {
			Arrays.fill(adjMatrix[i], inf);
		}
		D = new int[V + 1];
		Arrays.fill(D, inf);

		for (int i = 1; i < V + 1; i++) {
			adjMatrix[i][i] = 0;
		}

		calc();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (adjMatrix[a][b] > c) // 현 입력값보다 작은 값이 이미 있을 경우 입력하지 않는다
				adjMatrix[a][b] = c;
			edges[i] = new Edge(a - 1, b - 1, c);
		}
		Arrays.fill(distance, inf);
		distance[0] = 0;

		boolean isNegative = goNegativeCycle();

		if(isNegative) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < V; i++) {
//				System.out.printf("%d\n", D[i]==inf?-1:D[i]);
				sb.append(String.format("%d\n", distance[i] == inf ? -1 : distance[i]));
			}
			System.out.println(sb.toString());
		}
		
//		
//		boolean negativeCycle = false;
//		D[1] = 0;
//		for (int loof = 1; loof < V + 1; loof++) {
//			for (int i = 1; i < V + 1; i++) {
//				for (int j = 1; j < V + 1; j++) {
//					D[i] = Integer.min(D[i], D[j] + adjMatrix[j][i]);
//				}
//			}
//			if (D[1] < 0) {
//				negativeCycle = true;
//				break;
//			}
//		}
//		System.out.println("####adjMatrix####");
//		for (int i = 0; i < V + 1; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
//		System.out.println("####### D #######");
//		System.out.println(Arrays.toString(D));
//		if (!negativeCycle) { // 45% -> 53%
//			for (int i = 1; i < V + 1; i++) {
//				for (int j = 1; j < V + 1; j++) {
//					if (D[i] > D[j] + adjMatrix[j][i]) {
//						negativeCycle = true;
//						break;
//					}
//				}
//			}
//		} // https://www-m9.ma.tum.de/graph-algorithms/spp-bellman-ford/index_en.html

		/*
		 * 
		 * 11 12 1 11 1000 11 10 1000 10 9 1000 9 8 1000 7 6 1000 6 5 1000 5 4 1000 8 7
		 * 1000 4 3 1 3 4 -2 3 1 1000 1 2 4
		 * 
		 * 답 : -1
		 * 
		 * 1 1 1 1 -1
		 * 
		 * 답 : -1
		 * 
		 * 3 3 1 1 2 2 3 -1 3 2 -1
		 * 
		 * 답 : -1 -1
		 * 
		 */
		// System.out.println(D[1]);

		// negativeCycle이 존재하지만 1에서 해당 원소에 접근이 불가능할때 일반적인 출력이 되어야한다
//		if (negativeCycle) {
//			System.out.println(-1);
//		} else {
//			StringBuilder sb = new StringBuilder();
//			for (int i = 2; i < V + 1; i++) {
////				System.out.printf("%d\n", D[i]==inf?-1:D[i]);
//				sb.append(String.format("%d\n", D[i] == inf ? -1 : D[i]));
//			}
//			System.out.println(sb.toString());
//		}
	}

	private static boolean goNegativeCycle() {
		// 간선 리스트를 N-1번 (음수 싸이클 확인 N번) : 반복하며 간선완화작업

		for (int i = 0; i <= count; i++) {
			for (Edge e : edges) {
				if (distance[e.from] == inf)
					continue; // 1번 도시에서 from 까지 최소 비용이 inf이면 다음 간선확인
				if (distance[e.to] > distance[e.from] + e.weight) {
					distance[e.to] = distance[e.from] + e.weight;
					if(i==count) return true; // 음수 사이클이 존재한다
				}
			}
		}
		return false; // 다 돌았는데 업데이트가 이루어지지 않았다면 음수 사이클이 없다는 뜻
	}
}