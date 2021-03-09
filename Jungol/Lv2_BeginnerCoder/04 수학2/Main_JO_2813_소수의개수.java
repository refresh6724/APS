import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2813_소수의개수 { // 제출일 2021-03-09 23:12

	static boolean[] isPrime;

	static void prime() {
		isPrime = new boolean[2000001];
		for (int i = 2; i < 2000001; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < 2000001; i++) {
			if (isPrime[i]) {
				// i*i 연산이 i*2 연산(비트 시프트)보다 시간이 걸리는 것은 사실이지만 2배가 걸릴 정도인가?
				for (int j = i * 2; j < 2000001; j += i) {
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

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		prime();
		for (int i = n; i <= m; i++) {
			if (isPrime[i]) {
				cnt += 1;
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
	}
}