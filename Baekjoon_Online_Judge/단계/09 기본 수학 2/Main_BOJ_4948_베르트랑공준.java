import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4948
 */
public class Main_BOJ_4948_베르트랑공준 { // 제출일 2020-11-12 22:22

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[300000];
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
		StringBuilder sb = new StringBuilder();

		// 1. 소수를 찾고
		prime();

		// 2. n보다 크고 2n보다 작거나 같은 소수의 개수를 구한다
		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			int cnt = 0;
			for (int i = n + 1; i <= n << 1; i++) {
				if (isPrime[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
			n = Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
	}
}
