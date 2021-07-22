import java.util.Arrays;

public class Solution_Level_1_평균구하기 { // 제출일 2021-07-22 23:08

	public double solution(int[] arr) {
		// return Arrays.stream(arr).average().orElse(0);
		return Arrays.stream(arr).sum() / (double) arr.length;
	}
}
