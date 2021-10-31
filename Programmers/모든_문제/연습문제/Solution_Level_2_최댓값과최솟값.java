import java.util.StringTokenizer;

public class Solution_Level_2_최댓값과최솟값 {

	// test
	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4")); // 1 4
		System.out.println(solution("-1 -2 -3 -4")); // -4 -1
		System.out.println(solution("-1 -1")); // -1 -1

	}

	public static String solution(String s) {

		StringTokenizer st = new StringTokenizer(s);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			min = Math.min(min, a);
		}

		return String.format("%d %d", min, max);
	}
}