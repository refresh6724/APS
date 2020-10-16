
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

	/**
	 * 약 600 ms 
	 * 3^20 = 34억 
	 * 2^31 = 21억 
	 * 즉 plus가 40까지 갈 수 있다 
	 * 정확히는 2 * log n / log 3 번
	 * 가지를 뻗으므로 O(nlogn) 
	 * 21억 41 > 3^0 
	 * 21억 39 > 3^1 
	 * ... 
	 * 21억 1 < 3^20
	 */
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

	/**
	 * 약 60 ms 
	 * 최대 제곱수 제한을 두어 위 방법보다 10배 빠르다 
	 */
	static int math(int n) {
		int m = (int) (Math.log(n) / Math.log(3));
		return go(n - 2, m, (m << 1) - 2);
	}

	static int go(int n, int m, int p) {
		if (n == 1 && m == 0 && p == 0) { // 시작점에 도달했다면
			return 1;
		}
		if (n <= 1 || m <= 0 || p < 0) { // 범위를 벗어나는 경우
			return 0;
		}
		if (p > (m << 1)) { // +가 너무 많아 *++ 를 만들지 못하는 경우
			return 0;
		}

		if (n % 3 == 0) { // 3 의 배수라면 곱하기 한번을 깎고 수를 3으로 나누는 경우와 플러스 3번을 더 깎아보는 경우
			return go(n / 3, m - 1, p) + go(n - 3, m, p - 3);
		} else { // 3의 배수가 아니라면 3의 배수로 맞춰주기
			return go(n - n % 3, m, p - n % 3);
		}
	}
}