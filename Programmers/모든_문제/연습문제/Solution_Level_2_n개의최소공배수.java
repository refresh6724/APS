public class Solution_Level_2_n개의최소공배수 {

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 6, 8, 14 }));
		System.out.println(solution(new int[] { 1, 2, 3 }));
	}

	public static int solution(int[] arr) {
		int GCD = arr[0];
		int LCM = arr[0];
		for (int i = 1; i < arr.length; i++) {
			GCD = gcd(LCM, arr[i]);
			LCM = LCM / GCD * arr[i];
		}
		return LCM;
	}

	// n>m 일 때 (n%m==0)?m:gcd(m,n%m);
	private static int gcd(int n, int m) {
		if (n > m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}

}