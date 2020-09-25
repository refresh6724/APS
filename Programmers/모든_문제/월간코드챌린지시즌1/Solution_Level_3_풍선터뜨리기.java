public class Solution_Level_3_풍선터뜨리기 { // 제출일 2020-09-25 23:23

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, -1, -5 })); // 3
		System.out.println(solution(new int[] { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 })); // 6
		System.out.println(solution(new int[] { 1, 2, 3, 4 })); // 4 4 4
		System.out.println(solution(new int[] { 1, 2, 4, 3 })); // 3 3 3
		System.out.println(solution(new int[] { 1, 3, 2, 4 })); // 3 4 <=3
		System.out.println(solution(new int[] { 1, 3, 4, 2 })); // 2 2 2
		System.out.println(solution(new int[] { 1, 4, 2, 3 })); // 3 3 3
		System.out.println(solution(new int[] { 1, 4, 3, 2 })); // 2 2 2
		System.out.println(solution(new int[] { 2, 1, 3, 4 })); // 4 4 4
		System.out.println(solution(new int[] { 2, 1, 4, 3 })); // 3 3 3
		System.out.println(solution(new int[] { 2, 3, 1, 4 })); // 3 4 <=3
		System.out.println(solution(new int[] { 2, 3, 4, 1 })); // 2 2 2
		System.out.println(solution(new int[] { 2, 4, 1, 3 })); // 3 3 3
		System.out.println(solution(new int[] { 2, 4, 3, 1 })); // 2 2 2
		System.out.println(solution(new int[] { 3, 1, 2, 4 })); // 4 4 4
		System.out.println(solution(new int[] { 3, 1, 4, 2 })); // 3 3 3
		System.out.println(solution(new int[] { 3, 2, 1, 4 })); // 4 4 4
		System.out.println(solution(new int[] { 3, 2, 4, 1 })); // 3 3 3
		System.out.println(solution(new int[] { 3, 4, 1, 2 })); // 3 3 3
		System.out.println(solution(new int[] { 3, 4, 2, 1 })); // 3 3 3
		System.out.println(solution(new int[] { 0, 1, 2, 3, 4, 5 })); // 6
		System.out.println(solution(new int[] { 0, 1, 2, 3, 4, 6, 5, 7, 8, 9 })); // 9
		System.out.println(solution(new int[] { 0, 4, 2, 8, 6, 12, 10, 11, 9, 5, 7, 1, 3 })); // 3
		System.out.println(solution(new int[] { 0, 10, -10, 9, -9, 8, -8, 1 })); // 5
		System.out.println(solution(new int[] { 0, 10, -8, 9, -9, 8, -10, 1 })); // 5
		System.out.println(solution(new int[] { 0, 10, -9, 9, -10, 8, -8, 1 })); // 5
		System.out.println(solution(new int[] { 0, 3, 6, 9, 20, 10 })); // 5
		System.out.println(solution(new int[] { 0, 3, 6, 9, 1, 20, 10 })); // 3 6 <= 3
	}

	public static int solution(int[] a) {

		// n개의 풍선
		// 임의의 인접한 2개 중 하나를 터뜨린다
		// 번호가 작은 풍선을 터뜨리는 것은 단 한번만 가능하다
		// 따라서 나머지는 모두 번호가 큰 풍선을 터뜨려야 한다
		// 최후까지 남을 수 있는 풍선 번호의 개수를 리턴

		// 1 완전탐색 ?
		// a는 1백만 이하
		// 숫자는 -10억 ~ 10억
		// n! 이상

		// 2 이분탐색?
		// 살아남을 수 없는 풍선 고르기?

		// 3 단순 비교
//		return try_and_error_1(a);

		// 4 비교 탐색
		return try_and_error_2(a);

	}

	private static int try_and_error_2(int[] a) {
		int n = a.length;
		int fail = 0;
		if (n < 3) {
			return n; // 1,2 인 경우 숫자와 상관없이 통과
		}
		
		int lidx = 0;
		int lmin = Integer.MAX_VALUE;
		int ridx = n - 1;
		int rmin = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			if(a[i] < lmin) {
				lmin = a[i];
				lidx = i;
			} else {
				break;
			}
		}		
		for (int i = n - 1; i >= 1; i--) {
			if (a[i] < rmin) {
				rmin = a[i];
				ridx = i;
			} else {
				break;
			}
		}
		lidx++;
		ridx--;
		while (lidx <= ridx) {
			if(a[lidx] > lmin && a[lidx] > rmin) {
				fail++;
				lidx++;
			} else if(a[ridx] > lmin && a[ridx] > rmin) {
				fail++;
				ridx--;
			} else if (a[lidx] < lmin) {
				lmin = a[lidx];
				lidx++;
			} else if (a[ridx] < rmin) {
				rmin = a[ridx];
				ridx--;
			}		
		}
		
		return n - fail;
	}

	private static int try_and_error_1(int[] a) {
		// 가장 작은 수 => 어떤 임의의 수와 경로가 주어져도 살아남음
		// 두번째로 작은 수 => 어떤 임의의 수와 경로가 주어져도 가장 작은 수와 붙었을 때 작은 풍선 터뜨리기를 하면 살아남음
		// 세번째로 작은 수 => 좌 우로 자신보다 작은 수가 각각 1개 이상 있다면 죽는다
		// i번째 위치에서 0 ~ i-1 까지 i번째 수보다 작은 수의 개수, i+1 ~ n-1 까지 i번째 수보다 작은 수의 개수
		// 시간 복잡도는?
		// 길이 n * 탐색 n + 비교 n => n^2 => 100만 * 100만 = 10 조?? => 시간 초과
		// 공간 복잡도는?
		// 작은 수의 개수를 셀 필요가 없으므로 1개 이상이면 true
		// 2n => n
		int n = a.length;
		int fail = 0;

		boolean[] left = new boolean[n];
		// boolean[] right = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					left[i] = true;
					break;
				}
			}
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[i]) {
					// right[i] = true;
					if (left[i]) {
						// System.out.println(a[i]);
						fail++;
					}
					break;
				}
			}
		}
		return n - fail;

	}

}