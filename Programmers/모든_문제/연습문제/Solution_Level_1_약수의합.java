public class Solution_Level_1_약수의합 { // 제출일 2021-07-29 23:17

	public static void main(String[] args) {
		System.out.println(solution(0));
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(25));
		System.out.println(solution(100000000));
	}

	// 정수 n의 약수를 모두 더한 값을 리턴
	// n은 0 이상 3천 이하
	public static int solution(int n) {
		int ans = 0;
		int i = 1;
		int j = n / i;
		while (i < j) {
			ans += i + j;
			while (true) {
				if (n % (++i) == 0) {
					j = n / i;
					break;
				}
			}
		}
		if (i == j) {
			ans += i;
		}
		return ans;
	}
}
