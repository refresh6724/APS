public class Solution_Level_1_최대공약수와최소공배수 { // 제출일 2021-07-24 23:21

	public static int[] solution(int n, int m) {
		int gcd = getGCD(n, m);
		int lcm = n / gcd * m;
		return new int[] { gcd, lcm };
	}

	private static int getGCD(int n, int m) {
		return (m == 0) ? n : getGCD(m, (n % m));
	}

}
