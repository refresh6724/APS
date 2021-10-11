public class Solution_Level_2_전력망을둘로나누기 {

	// test
	public static void main(String[] args) {

		int n;
		int[][] wires;

		n = 9;
		wires = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		// System.out.println(solution(n, wires)); // 3

		n = 4;
		wires = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		// System.out.println(solution(n, wires)); // 0

		n = 7;
		wires = new int[][] { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };
		System.out.println(solution(n, wires)); // 1
	}

	static boolean[][] mat;
	static boolean[] visited;
	static int start, cnt, diff;

	// 트리 경로를 하나 끊어서 비슷한 크기의 2개로 나누기
	public static int solution(int n, int[][] wires) {
		// 1 100 x 100 트리를 만든다
		// 2 와이어 하나를 골라 false로 돌리고 dfs, visited
		mat = new boolean[n + 1][n + 1];

		for (int[] wire : wires) {
			mat[wire[0]][wire[1]] = true;
			mat[wire[1]][wire[0]] = true;
		}

		diff = n;
		for (int[] wire : wires) {
			mat[wire[0]][wire[1]] = false;
			mat[wire[1]][wire[0]] = false;
			visited = new boolean[n + 1];
			cnt = 0;
			dfs(1, n);
			int a = Math.min(cnt, n - cnt);
			int b = n - a;
			diff = Math.min(diff, b - a);
			if (diff == 0) {
				break;
			}
			mat[wire[0]][wire[1]] = true;
			mat[wire[1]][wire[0]] = true;
		}

		return diff;

	}

	private static void dfs(int x, int n) {
		if (visited[x]) {
			return;
		}
		visited[x] = true;
		cnt++;
		for (int i = 1; i <= n; i++) {
			if (mat[x][i]) {
				dfs(i, n);
			}
		}

	}

}
