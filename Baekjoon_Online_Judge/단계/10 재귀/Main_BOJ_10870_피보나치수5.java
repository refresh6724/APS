import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10870
 */
public class Main_BOJ_10870_피보나치수5 { // 제출일 2020-11-11 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n번째 피보나치 수 출력(n <= 20)
		System.out.println(fib(Integer.parseInt(br.readLine())));

	}

	private static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
