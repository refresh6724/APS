import java.util.Arrays;

/**
 * https://contest.usaco.org/DEC06.htm
 */
public class Solution_Level_4_징검다리 { // 제출일 2020-08-24 22:40

	// test
	public static void main(String[] args) {
		System.out.println(solution(25, new int[] { 2, 14, 11, 21, 17 }, 2)); // 4
		System.out.println(solution(100, new int[] { 79, 80, 81, 82, 83 }, 1)); // 1
		System.out.println(solution(100, new int[] { 79, 80, 81, 82, 83 }, 2)); // 2
		System.out.println(solution(100, new int[] { 79, 80, 81, 82, 83 }, 3)); // 4
		System.out.println(solution(100, new int[] { 79, 80, 81, 82, 83 }, 4)); // 21 o 83 x
		System.out.println(solution(10, new int[] { 6, 7, 8, 9 }, 3)); // 4 o 9 x
		System.out.println(solution(34, new int[] { 5, 19, 28 }, 2)); // 15 o 28 x
		System.out.println(solution(16, new int[] { 4, 8, 11 }, 2)); // 8 o 11 x

		// https://contest.usaco.org/TESTDATA/DEC06_9.htm
//		System.out.println(solution(65343245, new int[] {}, 0)); // 65343245
		System.out.println(solution(53428902, new int[] { 1229359, 14292516, 18119162, 7640178, 21475457, 13446983,
				10764311, 23677390, 16551566, 19637549, 15393700, 13362406, 14808906, 1188568, 2430010, 995859, 6341191,
				13202229, 11128108, 21174736, 1931010, 9406546, 17129598, 16279493, 11515655, 12283648, 18611563,
				10962958, 9331817, 19164215, 6816932, 15607344, 18492487, 6655012, 16646986, 20600381, 22705607,
				3396266, 10239978, 14787853, 18843930, 12885894, 21986321, 5327198, 13783223, 23728739, 1549474,
				8026301, 13229659, 8054873, 17599294, 4614842, 2902294, 9898145, 15858474, 5860009, 21824861, 19465972,
				3521509, 15269292, 23708887, 16281697, 7936610, 8545942, 20262894, 4297275, 12631814, 137872, 4613587,
				17270469, 18927526, 22213204, 19973483, 13639755, 14210368, 11319843, 20736572, 10972250, 640276,
				22708998, 7109821, 9244360, 312786, 7084191, 8989726, 5094591, 18371807, 23378634, 5074008, 718243,
				12403800, 9224735, 23212977, 3961579, 2549796, 1843642, 2242465, 23140278, 5945922, 11818594 }, 40)); // 238356
	}

	public static int solution(int distance, int[] rocks, int n) {
		Arrays.parallelSort(rocks);

		// return 오류있는모범답안(distance, rocks, n);
		return try_and_error_1(distance, rocks, n);

	}

	/* Programmers 사이트 아이디 Typebi 님의 설명입니다 */
	/*
	 * 바위간의 간격의 최소값을 기준 mid로 찾아가기
	 * 
	 * 최소거리를 변동시킬수있는 방법은 제거위치를 바꿔주는 방법이다. 이전 바위와의 거리가, 임의의 기준값(x)보다 작으면, 최소거리를 늘리기
	 * 위해 현재 바위를 제거해준다 (그러면 바위 사이가 멀어진다 ( 이전바위 - (현재바위) - 다음바위) 최소거리가 이전바위와의 거리 +
	 * 다음바위와의 거리가 되기 때문이다) 기준(x)보다 크면, 그 거리는 최소거리의 후보가 된다. 보관중인 최소거리와 비교해서 더 작으면
	 * 교체한다. 그 바위로부터 다음 바위까지의 새로운 거리를 측정해야하므로, 이전바위를 현재위치로 바꿔준다.
	 * 
	 * 기준값 x로 순회해본 뒤, 제거한 바위의 개수가 n개보다 작거나같다면, 그때의 최소거리를 저장한다. n개보다 작은경우도 괜찮다. 왜냐하면,
	 * 많이 제거할수록 바위사이의 간격은 멀어지기 때문에, n개보다 적게 제거했을 때는 n개 제거했을때보다 어딘가의 바위가 더 가깝다. 즉,
	 * 'n개제거 최소거리'보다 항상 작거나 같다. 최소거리들 중에서의 최대값을 찾는 것이기 때문에, 어차피 걸러진다. x가 더 커도 가능할지
	 * 모르므로 x를 늘려준다.
	 * 
	 * 마지막 바위와 끝지점과의 거리도 최소거리가 될지 모르므로 그것도 측정해서 보관된 최소거리보다 작다면 교체해준다.
	 * 
	 * 기준값 x로 순회해본 뒤, 제거한 바위의 개수가 n개보다 크다면, 바위를 너무 많이 제거했다는 뜻이다. 바위간의 거리가 x보다 작을 때
	 * 제거하므로, 기준값 x가 크다는 의미다. x를 줄여준다.
	 * 
	 * x를 늘리거나 줄이기 위해 이분탐색을 사용한다.
	 * 
	 * x의 범위가 0아래로 떨어질 때까지 (left>=right) 반복해준다.
	 */

	/**
	 * https://contest.usaco.org/TESTDATA/DEC06.jump.htm
	 */
	private static int 오류있는모범답안(int distance, int[] rocks, int n) {
		int a = 0;
		int b = distance;

		while (a < b) {
			int c = (a + b + 1) / 2;

			int p = 0;
			int hits = 0;
			for (int rock : rocks) {
				if (rock - p < c) {
					++hits;
				} else {
					p = rock;
				}
			}

			if (hits > n) {
				b = c - 1;
			} else {
				a = c;
			}
		}

		return a;
	}

	private static int try_and_error_1(int distance, int[] rocks, int n) {
		int left, right, mid;
		int max, min;
		int start, count;

		left = 0;
		right = distance;
		max = Integer.MIN_VALUE;

		while (left <= right) {
			mid = (left + right) / 2;
			start = 0;
			count = 0;
			min = Integer.MAX_VALUE;
			for (int rock : rocks) {
				if ((rock - start) < mid) {
					count++;
				} else {
					min = Math.min(min, (rock - start));
					start = rock;
				}
			}

			min = Math.min(distance - start, min);

			if (count > n) {
				right = mid - 1;
			} else {
				max = Math.max(max, min);
				left = mid + 1;
			}
		}
		return max;
	}

}