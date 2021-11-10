import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Level_3_하노이의탑 {

	// test
	public static void main(String[] args) {
		int[][] ans = solution(2);
		for (int[] a : ans) {
			System.out.println(Arrays.toString(a));
		}
	}

	static List<int[]> order;

	// 이 문제 참 오랜만에 본다
	public static int[][] solution(int n) {

		order = new ArrayList<>();

		hanoi(n, 1, 2, 3);

		int size = order.size();
		int[][] ret = new int[size][];
		for (int i = 0; i < size; i++) {
			ret[i] = order.get(i);
		}
		return ret;
	}

	private static void hanoi(int n, int from, int via, int to) {

		if (n == 1) {
			order.add(new int[] { from, to });
			return;
		}

		// n 개를 from 에서 to로 옮기는 방법은
		// n-1개를 from에서 via로 옮기고
		hanoi(n - 1, from, to, via);
		// n번째 판을 from에서 to로 옮기고
		order.add(new int[] { from, to });
		// 다시 n-1개의 판을 via에서 to로 옮기는 것이다.
		hanoi(n - 1, via, from, to);

	}
}