import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1193
 */
public class Main_BOJ_1193_분수찾기 { // 제출일 2020-10-31 23:22

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 행/열 로 표시되는 유사 피라미드형 배열
		// 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> 1/3 ->
		// 지그재그
		// X번째 수(최대 1천만)를 출력

		// x/y => x+y-1 번째 그룹의 수
		// 홀수번째일 경우 분모가 오름차순

		int X = Integer.parseInt(br.readLine());
		int n = 0;
		int[] cnt = new int[10000];
		// 0 1 3 6 10
		cnt[0] = 0;
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] = cnt[i - 1] + i;
			if (X <= cnt[i]) {
				n = i;
				break;
			}
		}

		X -= cnt[n - 1];
		// x+y-1 = n;
		int x = 0;
		int y = 0;
		if (n % 2 == 0) {
			// 분자가 오름차순
			x = X;
			y = n + 1 - x;
		} else {
			// 분모가 오름차순
			y = X;
			x = n + 1 - y;
		}

		System.out.println(String.format("%d/%d", x, y));
	}
}
