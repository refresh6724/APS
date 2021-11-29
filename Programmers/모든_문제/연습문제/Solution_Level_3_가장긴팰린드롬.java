public class Solution_Level_3_가장긴팰린드롬 {

	// test
	public static void main(String[] args) {
		System.out.println(solution("abcdcba")); // 7
		System.out.println(solution("abacde")); // 3
	}

	// 1번 브루트포스
	// 시작값 n * 끝값 n (최대 n = 2500)
	public static int solution(String s) {

		int n = s.length();
		int ans = 1;
		char[] ca = s.toCharArray();
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (ca[i] == ca[j] && ans < (j - i + 1)) {
					ans = Math.max(ans, close(i + 1, j - 1, ca));
				}
			}
		}

		return ans;
	}

	private static int close(int i, int j, char[] ca) {
		int ret = 2;
		while (i < j) {
			if (ca[i++] == ca[j--]) {
				ret += 2;
			} else {
				return 0;
			}
		}
		return ret + ((i == j) ? 1 : 0);
	}
}