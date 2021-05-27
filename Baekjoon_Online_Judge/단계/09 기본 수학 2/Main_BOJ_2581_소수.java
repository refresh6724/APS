import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2581
 */
public class Main_BOJ_2581_소수 { // 제출일 2020-11-17 22:13

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[10001];
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
		// M이상 N이하 소수의 합과 첫 소수 (1이상 1만이하)
		prime();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = -1;
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				if (min == -1) {
					min = i;
				}
				sum += i;
			}
		}
		if (sum != 0) {
			System.out.println(sum);
		}
		System.out.println(min);

	}

}
