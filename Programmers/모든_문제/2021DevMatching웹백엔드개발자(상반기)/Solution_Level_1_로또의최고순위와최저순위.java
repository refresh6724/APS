import java.util.Arrays;

public class Solution_Level_1_로또의최고순위와최저순위 { // 제출일 2021-07-15 23:41
	// 감상 : 평균 2.5 ms?
	// 스트림으로 처리하면 느리고 hashmap을 쓰면 50배 빠르다

	// test
	public static void main(String[] args) { // 제출일 2021-07-15 23:
		test(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 }, new int[] { 3, 5 });
		test(new int[] { 0, 0, 0, 0, 0, 0 }, new int[] { 38, 19, 20, 40, 15, 25 }, new int[] { 1, 6 });
		test(new int[] { 45, 4, 35, 20, 3, 9 }, new int[] { 20, 9, 3, 45, 4, 35 }, new int[] { 1, 1 });
	}

	private static void test(int[] lottos, int[] win_nums, int[] answer) {
		System.out.println("답변 : " + Arrays.toString(solution(lottos, win_nums)));
		System.out.println("정답 : " + Arrays.toString(answer) + "\n");
	}

	static int[] win = { 6, 6, 5, 4, 3, 2, 1 };

	// 1등 : 6개 일치 ... 5등 : 2개 일치, 6등 : 1개 일치 혹은 전체 불일치
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		// 최고 : 최저에서 0의 개수만큼 추가 일치한다고 계산
		// 최저 : 현재 lottos와 win_nums 간 숫자의 일치 개수

		Arrays.parallelSort(win_nums); //
		int zero = 0;
		int match = 0;

		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zero++;
			} else {
				for (int j = 0; j < win_nums.length && lottos[i] >= win_nums[j]; j++) {
					if (lottos[i] == win_nums[j]) {
						match++;
						break;
					}
				}
			}
		}

		answer[0] = win[match + zero];
		answer[1] = win[match];

		return answer;
	}
}
