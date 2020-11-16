import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1929
 */
public class Main_BOJ_1929_소수구하기 { // 제출일 2020-11-16 23:06

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[1000001];
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
		// M이상 N이하 소수를 모두 출력한다 (1이상 1백만이하)
		prime();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

}
