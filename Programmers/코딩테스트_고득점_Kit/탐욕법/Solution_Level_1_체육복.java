import java.util.Arrays;

public class Solution_Level_1_체육복 { // 제출일 2020-08-12 18:30

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 })); // 5
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 })); // 4
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 })); // 2
		System.out.println(solution(3, new int[] { 1, 3 }, new int[] { 1, 2 })); // 3

		/* 최소 */
		System.out.println(solution(2, new int[] { 1 }, new int[] { 1 })); // 2
		System.out.println(solution(2, new int[] { 2 }, new int[] { 1 })); // 2
		System.out.println(solution(2, new int[] { 1 }, new int[] { 2 })); // 2
		System.out.println(solution(2, new int[] { 2 }, new int[] { 2 })); // 2
		System.out.println(solution(2, new int[] { 1, 2 }, new int[] { 1 })); // 1
		System.out.println(solution(2, new int[] { 1, 2 }, new int[] { 2 })); // 1
		System.out.println(solution(2, new int[] { 1 }, new int[] { 1, 2 })); // 2
		System.out.println(solution(2, new int[] { 2 }, new int[] { 1, 2 })); // 2

		/* 최대 */
		System.out.println(solution(30,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
						26, 27, 28, 29, 30 },
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
						26, 27, 28, 29, 30 })); // 30

		/* 5번 테스트 케이스로 추정 */
		System.out.println(solution(3, new int[] { 2, 3 }, new int[] { 1, 2 })); // 2
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		// n : 2 이상 30 이하
		// lost : 1 이상 n 이하
		// reserve : 1 이상 n 이하
		// 본인의 체육복을 도난당하지 않았고 여벌이 있다면 양 옆에 빌려 줄 수 있다.
		// 따라서 3, {2,3}, {1,2} 인 경우
		// 2의 여벌 체육복을 3에게 빌려 줄 수 없다
		// 이 경우 답은 2다.
		// 단순하게 낮은 수부터 채운다면?

		// 1. 정렬 (2nlgn)
		Arrays.parallelSort(lost);
		Arrays.parallelSort(reserve);

		// 2. 옷 배열 생성 (2n)
		int[] clothes = new int[n];
		Arrays.fill(clothes, 1);

		// 3. 잃어버린 옷 (n)
		for (int i : lost) {
			clothes[i - 1]--;
		}

		// 4. 자기 체육복을 잃어버리고 여벌 체육복만 남은 사람을 먼저 제거해야 한다(n)
		for (int i : reserve) {
			clothes[i - 1]++;
		}

		// 5. 그 뒤에 2벌인 사람을 대상으로 좌우를 보고 나눠준다 (n)
		for (int idx = 0; idx < n; idx++) {
			if (clothes[idx] == 2) {
				if (idx - 1 >= 0 && clothes[idx - 1] == 0) {
					clothes[idx - 1]++;
				} else if (idx + 1 < n && clothes[idx + 1] == 0) {
					clothes[idx + 1]++;
				}
			}
		}

		// 6. 옷이 0벌이 아닌 사람의 수를 센다 (n)
		int answer = 0;
		for (int cloth : clothes) {
			if (cloth != 0) {
				answer++;
			}
		}
		return answer;
	}

}