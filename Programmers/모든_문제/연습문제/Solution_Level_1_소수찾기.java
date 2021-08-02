import java.util.Arrays;

public class Solution_Level_1_소수찾기 { // 제출일 2021-08-02 23:15

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	// test
	public static void main(String[] args) {
		System.out.println(solution(10)); // 4
		System.out.println(solution(5)); // 3
	}

	public static int solution(int n) {
		// 1 부터 n 사이 소수의 개수 반환
		prime();
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (isPrime[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}
