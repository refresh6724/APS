import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1978
 */
public class Main_BOJ_1978_소수찾기 { // 제출일 2020-11-18 23:21

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[1001];
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
		// 주어진 수 N개 중 소수의 개수 (최대 1000)
		prime();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (isPrime[a]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
