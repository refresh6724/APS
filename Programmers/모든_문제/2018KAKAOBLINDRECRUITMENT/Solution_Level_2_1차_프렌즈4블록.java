import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution_Level_2_1차_프렌즈4블록 {

	// test
	public static void main(String[] args) {
		String[] board;

		board = new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(4, 5, board)); // 14
		board = new String[] { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		System.out.println(solution(6, 6, board)); // 15

	}

	public static int solution(int m, int n, String[] board) {
		Game game = new Game(m, n, board);
		while (game.hasSquare()) {
			game.nextTurn();
		}
		return game.score;
	}

	static class Game {
		int m;
		int n;
		char[][] b;
		Queue<int[]> q;
		int score;

		public Game() {
			// TODO Auto-generated constructor stub
		}

		public Game(int m, int n, String[] board) {
			this.m = m;
			this.n = n;
			this.b = new char[m][n];
			for (int i = 0; i < m; i++) {
				this.b[i] = board[i].toCharArray();
			}
			this.q = new LinkedList<>();
			this.score = 0;
		}

		public boolean hasSquare() {
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					// X isKakao(b[i][j]) 
					// O Character.isUpperCase(b[i][j])
					// O b[i][j] != '0'
					if (b[i][j] != '0' && b[i][j] == b[i][j + 1] && b[i][j] == b[i + 1][j] && b[i][j] == b[i + 1][j + 1]) {
						q.add(new int[] { i, j });
					}
				}
			}

			if (q.size() > 0) {
				return true;
			}
			return false;
		}

		private boolean isKakao(char c) {
			if (c == 'R' || c == 'M' || c == 'A' || c == 'F' || c == 'N' || c == 'T' || c == 'J' || c == 'C') {
				return true;
			}
			return false;
		}

		public void nextTurn() {
			Set<Integer> set = new HashSet<>();
			while (!q.isEmpty()) {
				int r = q.peek()[0];
				int c = q.poll()[1];
				b[r][c] = '0';
				set.add(100 * r + c);
				b[r][c + 1] = '0';
				set.add(100 * r + c + 1);
				b[r + 1][c] = '0';
				set.add(100 * (r + 1) + c);
				b[r + 1][c + 1] = '0';
				set.add(100 * (r + 1) + c + 1);
			}
			this.score += set.size();

			for (int j = 0; j < n; j++) {
				Stack<Character> stack = new Stack<>();
				for (int i = 0; i < m; i++) {
					if (b[i][j] != '0') {
						stack.add(b[i][j]);
						b[i][j] = '0';
					}
				}
				for (int i = m - 1; i >= 0 && !stack.isEmpty(); i--) {
					b[i][j] = stack.pop();
				}

			}

		}

	}
}