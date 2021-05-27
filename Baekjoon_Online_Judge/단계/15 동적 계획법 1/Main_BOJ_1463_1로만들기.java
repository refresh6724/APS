import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class Main_BOJ_1463_1로만들기 { // 제출일 2020-12-24 22:49

	static int n;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		num = new int[n + 1];
		num[1] = 0;
		for (int i = 2; i <= n; i++) {
			if (i % 6 == 0) {
				num[i] = Math.min(num[i / 3], Math.min(num[i / 2], num[i - 1])) + 1;
			} else if (i % 3 == 0) {
				num[i] = Math.min(num[i / 3], num[i - 1]) + 1;
			} else if (i % 2 == 0) {
				num[i] = Math.min(num[i / 2], num[i - 1]) + 1;
			} else {
				num[i] = num[i - 1] + 1;
			}
		}
		System.out.println(num[n]);
	}
}
