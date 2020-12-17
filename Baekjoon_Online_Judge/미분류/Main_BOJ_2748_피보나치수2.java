import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2748_피보나치수2 { // 제출일 2020-12-17 23:05

	static long[] fib;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 피보나치 수를 dp로 구하기
		int n = Integer.parseInt(br.readLine());
		fib = new long[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		System.out.println(fib[n]);
	}

}
