import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10844
 */
public class Main_BOJ_10844_쉬운계단수 { // 제출일 2020-12-25 23:56

	static int[][] memo = new int[101][10];
	static int n;
	static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 길이가 1인 계단 수는 1~9 = 9
		// 길이가 2인 계단 수는 1인 수의 맨 뒤에 각 수의 +-1 을 한 수다. 단 9는 한쪽으로만 가능하다 따라서 (1~8) * 2 + 1 = 17
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i < 10; i++) {
			memo[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) { // 이전에 1로 끝남
					memo[i][j] = memo[i - 1][j + 1];
				} else if (j == 9) { // 이전에 8로 끝남
					memo[i][j] = memo[i - 1][j - 1];
				} else {
					memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % MOD;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += memo[n][i];
		}
		System.out.println(sum % MOD);
	}
}
