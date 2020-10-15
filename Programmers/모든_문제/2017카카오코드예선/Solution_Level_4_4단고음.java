
public class Solution_Level_4_4단고음 { // 제출일 2020-10-15 23:23
	public static void main(String[] args) {
		System.out.println(solution(15)); // 1
		System.out.println(solution(24)); // 0
		System.out.println(solution(41)); // 2
		System.out.println(solution(2147483647)); // 1735
	}

	static int answer;

	public static int solution(int n) {
		answer = 0;
		dfs(n, 0);
		return answer;
	}

	static void dfs(int n, int plus) {
		if (n < 3 || n < Math.pow(3, plus / 2)) {
			// *++ 을 만들지 못하는 경우
			return;
		}

		if (n == 3) {
			// *++ 만 허용된다
			if (plus == 2) {
				answer++;
			}
		} else if (n > 3) {
			if (n % 3 == 0 && plus >= 2) {
				dfs(n / 3, plus - 2);
			}
		}
		dfs(n - 1, plus + 1);
	}
}