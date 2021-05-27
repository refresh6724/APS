// String[] args를 Token으로 받는 클래스가 핵심

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-11-12 10:57 21828 kb 240 ms

	private void solve() {
		int vertex = sc.nextInt();
		int edge = sc.nextInt();
		int startNode = sc.nextInt();

		// 양방향 그래프, 가중치 x

		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[vertex + 1];

		for (int i = 0; i <= vertex; i++) {
			adj[i] = new ArrayList<>();
		}

		boolean[] visited = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adj[v1].add(v2);
			adj[v2].add(v1);

		}
		
		for (int i=1; i<=vertex; i++) {
            Collections.sort(adj[i]);
        }

		dfs(adj, visited, startNode);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(adj, visited, startNode);

	}

	// DFS 인접리스트
	public static void dfs(ArrayList<Integer>[] adj, boolean[] visited, int startNode) {

		if (visited[startNode]) {
			return;
		}
		
		visited[startNode] = true;
		System.out.print(startNode + " ");

		for (int nextNode : adj[startNode]) {

			if (!visited[nextNode]) {
				dfs(adj, visited, nextNode);
			}

		}

	}

	// BFS 인접리스트
	public static void bfs(ArrayList<Integer>[] adj, boolean[] visited, int startNode) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			startNode = q.poll();
			System.out.print(startNode + " ");
			
			for (int nextNode : adj[startNode]) {

				if (!visited[nextNode]) {
					q.add(nextNode);
					visited[nextNode] = true;
				}

			}
			
		}
		
	}

	public static void main(String[] args) {
		sc.init();

		new Main().solve();
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}
		/*
		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}
		*/
		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}
		
		static long nextLong() {
			return Long.parseLong(next());
		}
		
		static int nextInt() {
			return Integer.parseInt(next());
		}
		
		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}