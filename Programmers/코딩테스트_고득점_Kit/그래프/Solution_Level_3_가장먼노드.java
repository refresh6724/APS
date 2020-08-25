import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_Level_3_가장먼노드 { // 제출일 2020-08-25 21:52 // 테케 최대 시간 96 ms

	// test
	public static void main(String[] args) {
		System.out.println(
				solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } })); // 3
	}

	public static int solution(int n, int[][] edges) {
		// 노드 n은 2 이상 2만 이하
		// 간선은 양방향 총 5만개 이하
		// 1번에서 출발해 가장 먼 노드 개수를 리턴

		// boolean[][] adjacentArray = new boolean[20001][20001];
		// 4억 바이트 = 400 MB ...?
		List<List<Integer>> adjList = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			adjList.add(new LinkedList<Integer>());
		}
		int a, b;
		for (int i = 0; i < edges.length; i++) {
			a = edges[i][0];
			b = edges[i][1];
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		// 1번에서 출발 bfs
		boolean[] visited = new boolean[n + 1];
		int[] distances = new int[n + 1];
		Queue<Node> q = new LinkedList<Node>();
		Node node = new Node(1, 0);
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (!visited[node.vertex]) {
				visited[node.vertex] = true;
				distances[node.vertex] = node.distance;
				for (int next : adjList.get(node.vertex)) {
					q.add(new Node(next, node.distance + 1));
				}
			}
		}
		Arrays.parallelSort(distances);
		int max = distances[distances.length - 1];
		int cnt = 0;
		for (int i = distances.length - 1; i >= 2; i--) {
			if (distances[i] != max) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	static class Node {
		int vertex;
		int distance;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}

}