public class Solution_Level_1_음양더하기 { // 제출일 2021-04-16 22:33

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 7, 12 }, new boolean[] { true, false, true })); // 9
		System.out.println(solution(new int[] { 1, 2, 3 }, new boolean[] { false, false, true })); // 0
	}

	/**
	 * 
	 * @param absolutes 길이 1천 이하 각 1천 이하
	 * @param signs     참이면 absolute 값이 양수 false면 음수
	 * @return 합을 리턴
	 */
	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else {
				answer -= absolutes[i];
			}
		}
		return answer;
	}
}
