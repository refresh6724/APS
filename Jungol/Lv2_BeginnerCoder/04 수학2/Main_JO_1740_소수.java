import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1740_소수 { // 제출일 2021-03-08 19:04

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < 10001; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < 10001; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// m <= n, 1만 이하 자연수
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int min = -1;
		int sum = 0;

		prime();

		for (int i = m; i <= n; i++) {
			if (isPrime[i]) {
				if (min == -1) {
					min = i;
				}
				sum += i;
			}
		}
		if (min != -1) {
			sb.append(sum).append('\n');
		}
		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
	}

}