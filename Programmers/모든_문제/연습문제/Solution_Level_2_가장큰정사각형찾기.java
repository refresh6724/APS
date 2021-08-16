public class Solution_Level_2_가장큰정사각형찾기 { // 제출일 2021-08-16 23:33

	static int row, col;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0 } })); // 0
		System.out.println(solution(new int[][] { { 1 } })); // 1
		System.out.println(solution(new int[][] { { 0 }, { 1 } })); // 1
		System.out.println(solution(new int[][] { { 1 }, { 1 } })); // 1
		System.out.println(solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } })); // 4
	}

	public static int solution(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		if (row == 1 || col == 1) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1) {
						return 1;
					}
				}
			}
			return 0;
		}
		int max = 0;
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (board[i][j] == 1) {
					board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
					max = Math.max(max, board[i][j]);
				}
			}
		}
		return max * max;
	}

}
