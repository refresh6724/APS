public class Solution_Level_1_자릿수더하기 { // 제출일 2021-07-29 23:01

	public static int solution(int n) {
		int answer = 0;
		while (n != 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	}
}
