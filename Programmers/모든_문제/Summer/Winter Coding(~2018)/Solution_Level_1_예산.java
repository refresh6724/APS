import java.util.Arrays;

public class Solution_Level_1_예산 { // 제출일 2020-09-26 23:08

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }, 9)); // 3
		System.out.println(solution(new int[] { 2, 2, 3, 3 }, 10)); // 4
	}

	public static int solution(int[] d, int budget) {
		Arrays.parallelSort(d);
		int ret = 0;
		int idx = 0;
		while(budget >= 0) {
			budget -= d[idx++];
			ret++;
			if(idx == d.length) {
				break;
			}
		}
		if(budget < 0) {
			return ret-1;
		}
		return ret;
	}

}