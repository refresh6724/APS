import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_3_섬연결하기 { // 제출일 2020-08-15 23:01

	// test
	public static void main(String[] args) {
		System.out.println(solution(4, 
				new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } })); // 4
	}

	public static int solution(int n, int[][] costs) {

		return try_and_error_1(n, costs);
	}

	static int[] parents;

	static void union(int left, int right) {
		int x = findParent(left);
		int y = findParent(right);
		parents[x] = y;
	}

	static int findParent(int child) {
		if (parents[child] == -1) {
			return child;
		}
		return findParent(parents[child]);
	}

	private static int try_and_error_1(int n, int[][] costs) {
		// 크루스칼, Disjoint Set(Union Find) 사용
		int ret = 0;

		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = -1;
		}

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// cost가 작은 순으로 정렬한다
				return o1[2] - o2[2];
			}
		});

		int leftSet, rightSet;
		// 순서대로 붙여준다
		for (int i = 0; i < costs.length; i++) {

			leftSet = findParent(costs[i][0]);
			rightSet = findParent(costs[i][1]);

			if (leftSet == rightSet) {
				continue;
			} else {
				ret += costs[i][2];
				union(leftSet, rightSet);
			}

		}

		return ret;
	}

}