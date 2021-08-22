import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_Level_1_크레인인형뽑기게임 { // 제출일 2021-08-22 23:47

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

	public static int solution(int[][] board, int[] moves) {

		int len = board.length;
		ArrayList<Queue<Integer>> b = new ArrayList<>(len + 1);
		for (int i = 0; i <= len; i++) {
			b.add(new LinkedList<>());
		}
		Stack<Integer> picked = new Stack<>();
		int answer = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] != 0) {
					b.get(j + 1).add(board[i][j]);
				}
			}
		}

		for (int i = 0; i < moves.length; i++) {
			if (!b.get(moves[i]).isEmpty()) {
				int pick = b.get(moves[i]).poll();
				int peek = -1;
				if (!picked.isEmpty()) {
					peek = picked.peek();
				}
				if (pick == peek) {
					picked.pop();
					answer += 2;
				} else {
					picked.add(pick);
				}
			}
		}

		return answer;
	}
}
