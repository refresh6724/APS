import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_Level_3_모두0으로만들기 { // 제출일 2021-04-21 21:41

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { -5, 1, 4 }, new int[][] { { 0, 1 }, { 1, 2 } })); // 9
		System.out.println(solution(new int[] { -5, 1, 0, 4 }, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } })); // 13
		System.out.println(solution(new int[] { -5, 1, 0, 0, 4 }, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } })); // 17
		System.out.println(solution(new int[] { -5, 1, 4 }, new int[][] { { 0, 1 }, { 1, 2 } })); // 9
		System.out.println(solution(new int[] { -5, 1, 4 }, new int[][] { { 0, 1 }, { 1, 2 } })); // 9
		System.out.println(solution(new int[] { -5, 1, 4, -5, 1, 4 }, new int[][] { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } })); // 18
		System.out.println(solution(new int[] { -5, 0, 2, 1, 2 }, new int[][] { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } })); // 9
		System.out.println(solution(new int[] { 0, 1, 0 }, new int[][] { { 0, 1 }, { 1, 2 } })); // -1
	}

	/**
	 * 각 점에 가중치가 부여된 트리<br>
	 * 모든 점의 가중치를 0으로 조절<br>
	 * 임의의 엣지를 골라 연결되 두 점 중 한쪽을 1 증가 다른 한쪽을 1 감소<br>
	 * 0으로 만드는 것이 가능한지 가능하다면 최소 몇 번 해야하는지<br>
	 * 
	 * @param a     각 점의 가중치, 길이 2 이상 30만 이하, 각 -1백만 ~ 1백만
	 * @param edges 트리 간선 정보, 행의 개수는 (a의 길이 - 1)개, 항상 트리임이 보장됨
	 * @return 불가능하다면 -1을 가능하다면 최소 횟수를 리턴
	 */
	public static long solution(int[] a, int[][] edges) {

//		return first_try(a, edges);
//		return second_try(a, edges);
		return third_try(a, edges);

		/* 모범답안 */
		// Programmers의 GooWeon Kang 님의 답안 참고
		// 리프노드(노드의 차수가 1인 것)만 bfs의 큐에 넣고
		// 마치 꽃봉오리가 오므라들듯이 한 점으로 수렴하도록 세팅하면
		// 임의의 점으로 모으는 dfs에 비해 훨씬 안정적이고 빠르게 답을 얻을 수 있습니다
	}

	static List<List<Integer>> tree;
	static long[] la;
	static long answer;

	/**
	 * 첫번째 시도에 시간 초과가 난 이유 : <br>
	 * 같은 경로가 중복되는 경우가 너무 많았음 <br>
	 * 1,2,3,6,9,12,15 통과 나머지 시간 초과 <br>
	 * <br>
	 * 두번째 시도가 틀린 이유 : <br>
	 * 중간에 상쇄되는 경우를 계산하지 못하고 일괄적으로 모음<br>
	 * 1,2,3,6,9,12,15 통과 나머지 실패 <br>
	 * <br>
	 * 세번째 시도 : <br>
	 * 이번엔 두번째 시도에서 놓친 부분을 dfs로 바꾸어 <br>
	 * 마치 끝에서부터 흙을 긁어모으듯이 진행 <br>
	 * 플러스가 흙 더미, 마이너스가 구덩이라면 <br>
	 * 긁개가 당겨오면서 자동으로 덮이는 것을 누적값으로 계산 <br>
	 */
	@SuppressWarnings("unused")
	private static long third_try(int[] a, int[][] edges) {

		// 가중치의 합이 0이 아니면 불가능하다
		// 30만 * 1백만 = 3천억
		long sum = 0;
		for (int aa : a) {
			sum += aa;
		}
		if (sum != 0) {
			return -1;
		}

		la = new long[a.length];
		for (int i = 0; i < a.length; i++) {
			la[i] = a[i];
		}

		// dfs로 최소 횟수를 찾자
		answer = 0;
		tree = new ArrayList<>(a.length);
		for (int i = 0; i < a.length; i++) {
			tree.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}
		dfs(0, 0);
		return answer;

	}

	static void dfs(int parent, int child) {
		for (int next : tree.get(child)) {
			if (next != parent) {
				dfs(child, next);
			}
		}
		la[parent] += la[child]; // parent 에 누적, 플러스와 마이너스가 자동으로 합산된다
		answer += Math.abs(la[child]); // 단, 이동횟수는 절댓값이다
	}

	static long ans;
	static int[] b;
//	static List<List<Integer>> tree;
	static boolean[] visited;
	static int[] dist;

	static class Node {
		int idx;
		int len;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int idx, int len) {
			super();
			this.idx = idx;
			this.len = len;
		}
	}

	/**
	 * 두번째 시도 시간초과 & 틀린방법<br>
	 * 모든 가중치를 특정 노드에 모으기<br>
	 * 30만 노드 * 30만번 bfs * 매번 합계 계산<br>
	 * 0번 노드에 모두 모을 경우와 n번 노드에 모을 경우의 값이 다름<br>
	 * 또한 2개의 노드에 나눠서 모으는 것이 더 효율적인 경우도 있음<br>
	 */
	@SuppressWarnings("unused")
	private static long second_try(int[] a, int[][] edges) {
		// dist를 추가하여 0번으로 모두 모으기
		ans = 0;

		// 분석 1 a의 합이 0이어야 한다 o
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		if (sum != 0) {
			return -1;
		}

		// 분석 2
		b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		tree = new ArrayList<>(a.length);
		for (int i = 0; i < a.length; i++) {
			tree.add(new LinkedList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			tree.get(edges[i][0]).add(edges[i][1]);
			tree.get(edges[i][1]).add(edges[i][0]);
		}

		// 분석 2까지 ... 시간 초과
		// 분석 3 거리를 먼저 구한다?
		// 다익스트라? 플로이드-워셜(30만^3)
		// 엣지의 개수가 n-1개이므로 매우 sparse한 트리
		// pq를 사용할 경우 O(30만 * log(30만)) * 30만

		// 분석 4
		// 0번 노드에 모두 모으기...?
		// 이거 가능성 있다
		// 다익스트라로 0번에서 모든 정점까지의 거리를 계산하고
		// 일괄 계산
		go_second();
		return (ans == 0) ? -1 : ans;
	}

	/**
	 * dist 배열에 0번까지의 거리를 저장
	 */
	private static void bfs() {
		dist = new int[b.length];
		dist[0] = 0;
		visited = new boolean[b.length];
		visited[0] = true;
		Queue<Node> q = new LinkedList<>();
		for (int i : tree.get(0)) {
			q.add(new Node(i, 1));
		}
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (!visited[curr.idx]) {
				visited[curr.idx] = true;
				dist[curr.idx] = curr.len;
				for (int next : tree.get(curr.idx)) {
					q.add(new Node(next, curr.len + 1));
				}
			}
		}
	}

	private static void go_second() {
		bfs();
		// 0번 노드로 모두 모은다
		for (int i = 1; i < b.length; i++) {
			ans += (long) b[i] * dist[i];
		}
	}

	/**
	 * 첫번째 시도 시간초과 & 틀린 방법<br>
	 * 가중치가 있는 모든 노드에 대해 0번 부터 <br>
	 * bfs로 0으로 만드는 접근 방법<br>
	 * 문제를 잘못 파악해서 홀수와 짝수일 경우를 나눠 계산해서 틀림<br>
	 * 홀짝을 나누지 않았어도 <br>
	 * 예시 new int[] { -5, 1, 4, -5, 1, 4 }, <br>
	 * new int[][] { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } }; // 18 <br>
	 * 위 예시의 변종에 대해 20을 답으로 리턴할 수 있음<br>
	 */
	@SuppressWarnings("unused")
	private static long first_try(int[] a, int[][] edges) {
		ans = 0;

		// 분석 1 a의 합이 0이어야 한다 o
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		if (sum != 0) {
			return -1;
		}

		// 분석 2 각 점 간의 거리가 홀수 칸인 경우 +- 상쇄, 짝수 칸인 경우 +끼리 -끼리 상쇄
		// 0번 노드부터 1칸 거리에 있는 친구들과 상쇄시 1 추가 2칸 거리일 경우 2추가 ... 최대 거리까지 상쇄
		// a의 모든 가중치가 0이 되면 종료
		b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		tree = new ArrayList<>(a.length);
		for (int i = 0; i < a.length; i++) {
			tree.add(new LinkedList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			tree.get(edges[i][0]).add(edges[i][1]);
			tree.get(edges[i][1]).add(edges[i][0]);
		}
		go_first();
		return ans;
	}

	private static void go_first() {
		// 트리의 0번 노드부터 bfs로 돌면서 b의 가중치를 상쇄시킨다
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0) {
				continue;
			}
			visited = new boolean[b.length];
			visited[i] = true;
			Queue<Node> q = new LinkedList<>();
			for (int first : tree.get(i)) {
				q.add(new Node(first, 1));
			}
			while (!q.isEmpty() && b[i] != 0) {
				Node n = q.poll();
				if (!visited[n.idx]) {
					visited[n.idx] = true;

					if (b[i] * b[n.idx] < 0) {
						b[n.idx] += b[i];
						ans += (long) n.len * Math.abs(b[i]);
						b[i] = 0;
						break;
					}

//					처음에 완전히 틀린 이유
//					len이 홀수면 +- 상쇄
//					if (n.len % 2 != 0) {
//						// 위에 따로 빼놓은 if 부분
//					} else { // 짝수 거리인 경우 && 같은 부호일 경우 계산
//						if (b[i] * b[n.idx] > 0) {
//							b[n.idx] -= b[i];
//							ans += (long) n.len * b[i];
//							b[i] = 0;
//							break;
//						}
//					}

					for (int next : tree.get(n.idx)) {
						q.add(new Node(next, n.len + 1));
					}

				}
			}
//			if (b[i] != 0) {
//				ans = -1;
//				return;
//			}
		}
	}
}
