import java.util.Arrays;

public class Solution_Level_1_x만큼간격이있는n개의숫자 { // 제출일 2021-07-20 21:00

	// test
	public void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 5)));
		System.out.println(new int[] { 2, 4, 6, 8, 10 });
		System.out.println();
		System.out.println(Arrays.toString(solution(4, 3)));
		System.out.println(new int[] { 4, 8, 12 });
		System.out.println();
		System.out.println(Arrays.toString(solution(-4, 2)));
		System.out.println(new int[] { -4, -8 });
		System.out.println();
	}

	public long[] solution(int x, int n) {
		// x는 -10000000 이상 10000000 이하 정수
		// n은 1000 이하 자연수

		long[] answer = new long[n];
		answer[0] = x;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] + x;
		}

		return answer;
	}
}
