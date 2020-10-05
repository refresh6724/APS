public class Solution_Level_4_쿠키구입 { // 제출일 2020-10-05 17:59

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 2, 3 })); // 3
		System.out.println(solution(new int[] { 1, 2, 4, 5 })); // 0
		System.out.println(solution(new int[] { 1, 1 })); // 1
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 9 })); // 3
	}

	public static int solution(int[] cookie) {

		// 그냥 무식하게 처음부터 하나씩 세는 방식으로도 최대 90ms 이하로 통과 가능하다
		
//		return try_and_error_1(cookie); // 효율성 7,8 시간 초과
//		return try_and_error_2(cookie); // 효율성 6,7,8 시간 초과
//		return try_and_error_3(cookie); // 효율성 7 시간 초과
		return try_and_error_4(cookie); // 통과 전체 50ms 이하
	}

	private static int try_and_error_4(int[] cookie) {

		// step 1 더하기 (시간 복잡도 고정 n(n+1)/2 + n = n^2)
		int n = cookie.length; // 최대 2000
		// 2000 * 2000 * 4byte = 16MB
		int[][] memo = new int[n][n]; // 각 원소 1 이상 500 이하
		// 전체 합의 절반을 넘기면 의미가 없어진다
		for (int i = 0; i < n; i++) {
			memo[i][i] = cookie[i];
		}
		for (int row = n - 2; row >= 0; row--) {
			for (int col = row + 1; col < n; col++) {
				memo[row][col] = memo[row][col - 1] + cookie[col];
			}
		}

		// step 2 찾기 (시간 복잡도 최악 sigma(k=1 to n-1) k^3 = n^4) 단, 가지치기로 제한
		int max = 0;
		int s = Integer.MAX_VALUE;
		for (int len = n-1; len >= 1; len--) {			
			/*
			 * if (max != 0) { return max; } // 정확성 17 실패
			 */
			for (int start = 0, end = start + len; end < n; start++, end++) {
				s = memo[start][start + len];
				if (s % 2 == 0 && s / 2 > max) {
					s /= 2;
					for (int mid = start; mid < end; mid++) {
						if (memo[start][mid] > s) {
							break;
						} else if (memo[start][mid] == s) {
							max = Math.max(max, s);
						}
					}
				}
			}
		}

		return max;
	}

	private static int try_and_error_3(int[] cookie) {

		// step 1 더하기 (시간 복잡도 고정 n)
		int n = cookie.length;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + cookie[i - 1];
		}

		// step 2 찾기 (시간 복잡도 최악 n^3)
		int max = 0;
		int s = Integer.MAX_VALUE;
		for (int len = n; len >= 2; len--) {
			if (max == s / 2) { // 같은 길이라면 더 긴쪽이 크다는 점에 착안
				return max;
			}
			for (int start = 0; start + len <= n; start++) {
				s = sum[start] + sum[start + len];
				if (s % 2 == 0 && s / 2 > max) {
					for (int mid = start; mid < start + len; mid++) {
						if (s == sum[mid] * 2) {
							max = Math.max(max, sum[start + len] - sum[mid]);
						}
					}
				}
			}
		}

		return max;
	}

	private static int try_and_error_2(int[] cookie) {

		// step 1 더하기 (시간 복잡도 고정 n)
		int n = cookie.length;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + cookie[i - 1];
		}
		// i부터 j까지의 합은 s[j] - s[i-1]이 된다
		// 0부터 시작하므로 s[-1] 이 나올수 있음에 주의

		// step 2 찾기 (시간 복잡도 최악 n^3)
		int max = 0;
		// 예를 들어 start = 2, mid = 5, end = 10 이면
		// s5 - s1 = s10 - s5
		// s1 + s10 = 2s5
		for (int start = 1; start < n; start++) {
			for (int end = n; end > start; end--) {
				int s = sum[start - 1] + sum[end];
				if (s % 2 == 0 && s / 2 > max) {
					for (int mid = start; mid < end; mid++) {
						if (s == sum[mid] * 2) {
							max = Math.max(max, sum[end] - sum[mid]);
							/*
							 * if(max == s/2) { // 추가하면 정확성 3, 9, 효율성 3 fail return max; }
							 */
						}
					}
				}
			}
		}

		return max;
	}

	private static int try_and_error_1(int[] cookie) {

		// step 1 더하기 (시간 복잡도 고정 n(n+1)/2 + n = n^2)
		int n = cookie.length; // 최대 2000
		// 2000 * 2000 * 4byte = 16MB
		int[][] memo = new int[n][n]; // 각 원소 1 이상 500 이하
		// 전체 합의 절반을 넘기면 의미가 없어진다
		int sum = 0;
		for (int i = 0; i < n; i++) {
			memo[i][i] = cookie[i];
			sum += cookie[i];
		}
		sum >>= 1;
		for (int row = n - 2; row >= 0; row--) {
			for (int col = row + 1; col < n; col++) {
				memo[row][col] = memo[row][col - 1] + cookie[col];
			}
		}

		// 0 | 1 1 2 3
		// 1 | 1 2 5 7
		// 1 | 0 1 3 6
		// 2 | 0 0 2 5
		// 3 | 0 0 0 3

		// step 2 찾기 (시간 복잡도 최악 sigma(k=1 to n-1) (k(n-k)) = (n^3-6n^2-n)/6 = n^3)

		// 3행의 숫자 [3] 에 대해 2열의 숫자 [5,3,2] 가 있다면 max 갱신
		// 2행의 숫자 [2,5] 에 대해 1열의 숫자 [2,1] 이 있다면 max 갱신
		// 1행의 숫자 [1,3,6] 에 대해 0열의 숫자 [1] 이 있다면 max 갱신
		// 정답 3

		int max = 0;
		for (int row = n - 1; row >= 1; row--) {
			for (int col = n - 1; col >= row; col--) {
				if (memo[row][col] > max && memo[row][col] <= sum) {
					for (int find = 0; find < row; find++) {
						if (memo[row][col] == memo[find][row - 1]) {
							max = memo[row][col];
							break;
						}
					}
				}
			}
		}

		return max;
	}
}