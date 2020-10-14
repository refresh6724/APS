
public class Solution_Level_3_보행자천국 { // 제출일 2020-10-14 18:12
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } })); // 6
		System.out.println(solution(3, 6, new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } })); // 2
		System.out.println(solution(2, 5, new int[][] { { 0, 0, 2, 2, 0 }, { 0, 2, 2, 2, 0 } })); // 2
		System.out.println(solution(1, 1, new int[][] { { 0 } })); // 1
		System.out.println(solution(2, 2, new int[][] { { 0, 1 }, { 1, 0 } })); // 0
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } })); // 0
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 2 }, { 0, 2, 0 }, { 2, 0, 0 } })); // 2
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 2 }, { 0, 1, 0 }, { 2, 0, 0 } })); // 0
		System.out.println(solution(3, 3, new int[][] { { 0, 2, 2 }, { 2, 2, 2 }, { 2, 2, 0 } })); // 0
		System.out.println(solution(3, 3, new int[][] { { 0, 2, 0 }, { 2, 0, 2 }, { 0, 2, 0 } })); // 2
		System.out.println(solution(3, 3, new int[][] { { 0, 2, 0 }, { 2, 0, 2 }, { 0, 0, 0 } })); // 2
		System.out.println(solution(3, 3, new int[][] { { 0, 2, 0 }, { 0, 0, 0 }, { 0, 0, 0 } })); // 4
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 2 }, { 2, 0, 0 }, { 0, 0, 0 } })); // 3
	}

	static final int MOD = 20170805;
	static final int LEFT = 0;
	static final int UP = 1;
	static int[][][] memo;

	public static int solution(int m, int n, int[][] cityMap) {
		// (1,1), (1,2), (2,1) 의 경우 무조건 1을 리턴
		// (2,2) 의 경우 2 - 0 이 아닌 개수를 리턴
		if (m < 3 && n < 3) {
			int notZero = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (cityMap[i][j] != 0) {
						notZero++;
					}
				}
			}
			return (Math.min(m, n) - notZero);
		}

		memo = new int[m][n][2];
		memo[0][0][LEFT] = memo[0][0][UP] = 1;

		// 1행
		for (int col = 1; col < n; col++) {
			if (cityMap[0][col - 1] == 1) {
				memo[0][col][LEFT] = 0;
			} else {
				memo[0][col][LEFT] = memo[0][col - 1][LEFT];
			}
		}
		// 1열
		for (int row = 1; row < m; row++) {
			if (cityMap[row - 1][0] == 1) {
				memo[0][row][UP] = 0;
			} else {
				memo[row][0][UP] = memo[row - 1][0][UP];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (cityMap[i - 1][j] == 0) {
					memo[i][j][UP] = calc(i - 1, j);
				} else if (cityMap[i - 1][j] == 2) {
					memo[i][j][UP] = memo[i - 1][j][UP];
				}

				if (cityMap[i][j - 1] == 0) {
					memo[i][j][LEFT] = calc(i, j - 1);
				} else if (cityMap[i][j - 1] == 2) {
					memo[i][j][LEFT] = memo[i][j - 1][LEFT];
				}
			}
		}
//		dp(0, 1, m, n, cityMap); // 위의 반복문과 동일한 알고리즘인데 안된다 이유가 뭘까
		return calc(m - 1, n - 1);
	}

	private static int calc(int i, int j) {
		return (memo[i][j][LEFT] + memo[i][j][UP]) % MOD;
	}

	private static void dp(int i, int j, int m, int n, int[][] cityMap) {
		if (j == n) {
			dp(i + 1, 0, m, n, cityMap);
			return;
		}
		if (i == m) {
			return;
		}

		// 왼쪽부터
		if (j > 0) {
			switch (cityMap[i][j - 1]) {
			case 0:
				memo[i][j][LEFT] = calc(i, j - 1);
				break;
			case 1:
				break;
			case 2:
				memo[i][j][LEFT] = memo[i][j - 1][LEFT];
				break;
			}
		}

		if (i > 0) {
			switch (cityMap[i - 1][j]) {
			case 0:
				memo[i][j][UP] = calc(i - 1, j);
				break;
			case 1:
				break;
			case 2:
				memo[i][j][UP] = memo[i - 1][j][UP];
				break;
			}
		}

		dp(i, j + 1, m, n, cityMap);
	}

	public int 모범답안(int m, int n, int[][] cityMap) {
		int answer = 0;
		int[][] right = new int[m + 1][n + 1];
		int[][] down = new int[m + 1][n + 1];

		right[1][1] = 1;
		down[1][1] = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cityMap[i - 1][j - 1] == 0) {
					right[i][j] += (right[i][j - 1] + down[i - 1][j]) % MOD;
					down[i][j] += (down[i - 1][j] + right[i][j - 1]) % MOD;
				} else if (cityMap[i - 1][j - 1] == 2) {
					right[i][j] = right[i][j - 1];
					down[i][j] = down[i - 1][j];
				}
			}
		}
		answer = (right[m][n - 1] + down[m - 1][n]) % MOD;
		return answer;
	}

}