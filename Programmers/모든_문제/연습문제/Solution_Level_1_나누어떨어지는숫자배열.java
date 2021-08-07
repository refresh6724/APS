public class Solution_Level_1_나누어떨어지는숫자배열 { // 제출일 2021-08-07 23:51

	public int[] solution(int[] arr, int divisor) {
		int[] filter = Arrays.stream(arr).filter(x -> x % divisor == 0).sorted().toArray();
		return (filter.length == 0) ? new int[] { -1 } : filter;
	}
}
