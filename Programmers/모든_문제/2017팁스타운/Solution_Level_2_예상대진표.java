public class Solution_Level_2_예상대진표 { // 제출일 2020-08-11 21:43

	// test
	public static void main(String[] args) {
		System.out.println(solution(2, 1, 2)); // 1
		System.out.println(solution(8, 4, 7)); // 3
		System.out.println(solution(256, 134, 199)); // 7
	}

	public static int solution(int n, int a, int b) {

		// n 은 2 이상 2^20 이하 자연수, 부전승 없음
		int tmp = 0;
		if (a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		// a와 b가 n>>1 좌우로 있다면 log2(n) 가 답이 된다
		while (true) {
			tmp = n >> 1;
			if (a <= tmp && tmp < b) {
				return log2(n);
			} else if (a <= tmp && b <= tmp) { // 두 수가 왼쪽으로 쏠려 있는 경우
				n >>= 1;
			} else { // 두 수가 모두 오른쪽으로 쏠려 있는 경우
				a -= tmp;
				b -= tmp;
				n >>= 1;
			}
		}
	}

	private static int log2(int n) {
		int ret = 0;
		while (n != 1) {
			ret++;
			n /= 2;
		}
		return ret;
	}

}