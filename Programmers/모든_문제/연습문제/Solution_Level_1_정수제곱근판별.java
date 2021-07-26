public class Solution_Level_1_정수제곱근판별 { // 제출일 2021-07-26 23:23

	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(100));
		System.out.println(solution(121));
		System.out.println(solution(1000000));
	}

	public static long solution(long n) {
		// 1이상, 50000000000000 이하
		// n의 제곱근이 x면 x+1의 제곱을 리턴
		// 정수로 안 떨어지면 -1을 리턴

		char[] cn = Long.toString(n).toCharArray();
		// 뒤에서부터 두 자리씩 끊어서 제곱근 계산
		// 100 이면 idx는 012, len = 3 이면 odd면 0에서 시작
		int idx = 0;
		int m = 0;
		int box = 0;
		long x, y;
		if (cn.length % 2 == 0) {
			m = (cn[idx++] - '0') * 10 + (cn[idx++] - '0');
		} else {
			m = cn[idx++] - '0';
		}
		x = 0;
		y = 0;
		box = 0;

		while (true) {

			// box * box 가 m 과 같거나 작을 때 까지
			box = 9;
			while ((y + box) * box > m) {
				box--;
			}
			m -= (y + box) * box;
			x = 10 * x + box;
			y = (y + box + box) * 10;
			if (idx == cn.length) {
				break;
			}
			m = 100 * m + (cn[idx++] - '0') * 10 + (cn[idx++] - '0');
		}

		return (m == 0) ? (x + 1) * (x + 1) : -1;
	}
}
