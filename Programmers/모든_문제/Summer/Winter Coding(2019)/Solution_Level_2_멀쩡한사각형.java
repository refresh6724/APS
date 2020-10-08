public class Solution_Level_2_멀쩡한사각형 { // 제출일 2020-10-08 23:37

	// test
	public static void main(String[] args) {
		System.out.println(solution(8, 12)); // 80
	}

	public static long solution(int w, int h) {

		long sum = (long) w * h;

		if (w < h) {
			int tmp = w;
			w = h;
			h = tmp;
		}
		int gcd = GCD(w, h);
		w /= gcd;
		h /= gcd;
		if (w == 1 || h == 1) {
			return sum - w * h * gcd;
		}
		int x = ((w / h) + 1) * h + ((w % h) - 1);
		return sum - gcd * x;
	}

	private static int GCD(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

}