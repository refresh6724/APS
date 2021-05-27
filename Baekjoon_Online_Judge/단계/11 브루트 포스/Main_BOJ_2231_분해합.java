import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2231
 */
public class Main_BOJ_2231_분해합 { // 제출일 2020-11-20 23:52

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N의 분해합이 M일 때 M을 N의 생성자라 한다.
		// N이 주어질 때 가장 작은 생성자를 구하라. 없다면 0 출력
		// N으로 최대 1백만이 주어진다
		// 분해합으로 더해지는 최댓값은 자릿수 * 9 이므로
		String s = br.readLine();
		int len = s.length() - 1;
		int N = Integer.parseInt(s);

		// 1000000 - 54
		// 999946부터 999999까지 정답 없음

		// 10 - 9
		// 1부터 2 3 4 5 정답 5 + 5

		// 90 - 9
		// 81부터 정답 81 + 8 + 1
		int ans = 0;
		if (N < 10 && N % 2 == 0) {
			ans = N / 2;
		} else if(N < 55) {
			for (int i = N - 9; i < N; i++) {
				if (m(i, N)) {
					ans = i;
					break;
				}
			}
		} else {
			for (int i = N - 54; i < N; i++) {
				if (m(i, N)) {
					ans = i;
					break;
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean m(int i, int n) {

		int sum = i;
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		if (sum == n) {
			return true;
		}
		return false;
	}

}
