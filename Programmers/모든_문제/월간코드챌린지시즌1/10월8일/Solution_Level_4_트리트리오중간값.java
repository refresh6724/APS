import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_Level_4_트리트리오중간값3 { // 제출일 2020-10-26 23:14

	// test
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { { 1, 2 }, { 1, 3 } })); // 1
		System.out.println(solution(4, new int[][] { { 1, 2 }, { 1, 3 }, { 1, 4 } })); // 1
		System.out.println(solution(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } })); // 2
		System.out.println(solution(5, new int[][] { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 4, 5 } })); // 2
		System.out.println(solution(10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 4, 7 }, { 3, 5 }, { 5, 8 }, { 3, 6 }, { 6, 9 }, { 6, 10 } })); // 6
		System.out.println(solution(11, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 8 }, { 8, 9 }, { 6, 10 }, { 10, 11 } })); // 7
		System.out.println(solution(19, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 3, 7 }, { 4, 8 }, { 4, 9 }, { 5, 10 }, { 5, 11 }, { 6, 12 }, { 6, 13 }, { 7, 14 }, { 7, 15 },
				{ 15, 16 }, { 15, 17 }, { 17, 18 }, { 17, 19 } })); // 2 8 8 => 8

	}

	// 2^20 = 1048576
	// 2^19 = 524288
	// 2^18 = 262144
	static final int MAX = 18;
	static List<List<Integer>> tree;
	static int[] depth = new int[1 << MAX]; // i번째 정점의 깊이 (루트 : 0)

	public static int solution(int n, int[][] edges) {
		// 두 점 사이의 거리는 간선의 개수
		// f(a,b,c) = 각 점 사이의 거리 3개의 중간값으로 정의
		// 임의의 세 점을 통해 얻을 수 있는 f값 중 최댓값을 리턴
		// n은 정점의 개수
		// edges 행의 개수는 n-1
		// matrix로 만들면 25만x25만 list로 만들면 25만-1
		// 입력으로 주어지는 그래프는 "트리"임이 보장된다

		tree = new ArrayList<>(n);
		for (int i = 0; i < n; i++) { // 25만번 // n
			tree.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < n - 1; i++) { // 50만번 // 2n
			tree.get(edges[i][0] - 1).add(edges[i][1] - 1);
			tree.get(edges[i][1] - 1).add(edges[i][0] - 1);
		}

		for (int i = 1; i < n; i++) { // 25만번 // n
			depth[i] = -1;
		}
		depth[0] = 0;

		// 0번 정점을 루트로 하여 트리 만들기
		treeDFS(0);

		// 임의의 정점 루트 0 에서 dfs로 깊이를 재어 가장 깊은 점 a를 찾고
		// 다시 a에서 dfs로 깊이를 재어 가장 깊은 점 b를 찾으면
		// a에서 찾은 b의 깊이가 트리에서 가장 긴 길이, 트리의 지름이 된다
		// 이 때 트리 전체에서 한 점을 기준으로 서로 다른 두 점으로의 경로 길이가 트리의 지름이 된다면
		// 문제에서 구하는 f(a,b,c)의 최댓값이 트리의 지름이라고 할 수 있다
		// 반대로 트리 전체에서 트리의 지름을 갖는 경로가 오직 하나만 존재한다면 최댓값이 트리의 지름 - 1이 될 것이다

		int depthA = 0;
		int a = 0;
		for (int i = 0; i < n; i++) {
			if (depthA < depth[i]) {
				depthA = depth[i];
				a = i;
			}
		}

		// 다시 a를 기준으로 깊이를 초기화 한다
		for (int i = 0; i < n; i++) { // 25만번 // n
			depth[i] = -1;
		}
		depth[a] = 0;

		// a를 루트로 하는 트리를 만든다
		treeDFS(a);

		// depthB는 트리의 지름이며 depthA보다 클 수 있다
		int depthB = 0;
		ArrayList<Integer> bCandidate = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (depthB < depth[i]) {
				depthB = depth[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (depthB == depth[i]) {
				bCandidate.add(i);
			}
		}

		// 트리의 지름을 갖는 경로가 2개 이상이라면 트리의 지름이 최댓값이 된다
		if (bCandidate.size() > 1) {
			return depthB;
		}

		// b에서 시작하는 트리의 지름을 갖는 경로가 1개라면 b에서 다시 트리를 만든다
		int b = bCandidate.get(0);
		for (int i = 0; i < n; i++) { // 25만번 // n
			depth[i] = -1;
		}
		depth[b] = 0;

		// b를 루트로 하는 트리를 만든다
		treeDFS(b);

		// depthC는 트리의 지름이며 depthB와 길이가 같아야 한다
		int depthC = 0;
		ArrayList<Integer> cCandidate = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (depthC < depth[i]) {
				depthC = depth[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (depthC == depth[i]) {
				cCandidate.add(i);
			}
		}

		// 만약 c 후보가 2개 이상이 아니라면 f의 최댓값은 트리의 지름 -1이 된다.
		if (cCandidate.size() > 1) {
			return depthC;
		}

		return depthC - 1;

	}

	private static void treeDFS(int parent) {
		for (int child : tree.get(parent)) {
			if (depth[child] == -1) {
				depth[child] = depth[parent] + 1;
				treeDFS(child);
			}
		}
	}

}