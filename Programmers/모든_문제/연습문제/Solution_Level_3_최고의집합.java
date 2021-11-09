public class Solution_Level_3_최고의집합 {

	// test
	public static void main(String[] args) {

	}

	public static int[] solution(int n, int s) {

		// 중복이 허용되는 집합이었다...

		int sn = s / n;
		int md = s % n;
		if (sn == 0) {
			return new int[] { -1 };
		}
		int[] ret = new int[n];
		for (int i = 0; i < n - md; i++) {
			ret[i] = sn;
		}
		for (int i = n - md; i < n; i++) {
			ret[i] = sn + 1;
		}
		return ret;

	}

	public static int[] solutionForUniqueSet(int n, int s) {
		// n이 최댓값 1만, s가 최댓값 1억인 경우
		// 1에서 1만까지 모두 더했을 때 50005000
		// s를 n으로 나눈 값이 세트의 평균값
		// 평균값을 기준으로 좌우로 n/2개
		// 1부터 s/n까지 n/2개가 되지 않으면 fail
		// 짝수 - 짝수 - 4 20 > 5 를 기준으로 3456 18 < 3 4 6 7 < 4567 22
		// 짝수 - 홀수 - 4 19 > 4 를 기준으로 3 4 5 7 420 // 2 4 6 7 336 // 4444에서 -1,0,+1,+3
		// 홀수 - 짝수 - 3 20 > 6 을 기준으로 567 18 < 578 -1, +1, +2 < 678 21
		// 홀수 - 홀수 - 3 19 > 6 을 기준으로 567 18 < 568 -1, 0, +2 < 678 21

		// 4 10 > 2.5 // 1 2 3 4
		// 1 1 > 1 // 1

		int straight = n * (n + 1) / 2;
		if (straight > s) {
			return new int[] { -1 };
		}

		int sn = s / n;
		int half = n / 2;
		int start = sn - half + 1;
		int end = start + n - 1;
		int sum = (start + end) * n / 2;
		while (sum + n <= s) {
			start += 1;
			sum += n;
		}
		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			ret[i] = start + i;
		}
		if (sum == s) {
			return ret;
		}
		int diff = s - sum;
		for (int i = n - 1, j = 0; j < diff; i--, j++) {
			ret[i] += 1;
		}

		return ret;
	}
}