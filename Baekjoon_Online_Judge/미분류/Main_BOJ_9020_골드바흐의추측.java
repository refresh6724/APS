import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9020
 */
public class Main_BOJ_9020_골드바흐의추측 { // 제출일 2020-11-10 23:25

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[10000];
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 소수를 찾고
		prime();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			// 2. n의 절반부터 2까지 내려가면서 소수 짝을 찾는다
			int n = Integer.parseInt(br.readLine());
			for (int j = n/2; j >= 2; j--) {
				// 3. 찾으면 작은 소수부터 출력
				if(isPrime[j] && isPrime[n-j]) {
					System.out.println(String.format("%d %d", j, n-j));
					break;
				}
			}
		}
	}
}
