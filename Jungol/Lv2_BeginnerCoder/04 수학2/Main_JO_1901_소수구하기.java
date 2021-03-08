import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1901_소수구하기 { // 제출일 2021-03-08 19:33

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < 1000001; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < 1000001; j += i) {
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

		prime();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());

			if (isPrime[m]) {
				sb.append(m).append('\n');
			} else {
				for (int j = 1; j < m; j++) {
					if (isPrime[m - j]) {
						if (m + j < 1000000 && isPrime[m + j]) {
							sb.append(m - j).append(' ').append(m + j).append('\n');
							break;
						} else {
							sb.append(m - j).append('\n');
							break;
						}
					} else if (m + j < 1000000 && isPrime[m + j]) {
						sb.append(m + j).append('\n');
						break;
					}
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}