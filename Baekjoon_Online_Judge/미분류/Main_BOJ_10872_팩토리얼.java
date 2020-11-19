import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10872
 */
public class Main_BOJ_10872_팩토리얼 { // 제출일 2020-11-19 23:08

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N!을 재귀를 사용해 작성 (N <= 12)
		System.out.println(factorial(Integer.parseInt(br.readLine())));
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}

		return factorial(n - 1) * n;
	}

}
