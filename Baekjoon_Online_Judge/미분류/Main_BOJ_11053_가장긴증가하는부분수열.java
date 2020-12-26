import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11053
 */
public class Main_BOJ_11053_가장긴증가하는부분수열 { // 제출일 2020-12-26 23:02 180 ms n^2 => 개선된 nlogn 방법이 존재한다 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] memo = new int[n];
		Arrays.fill(memo, 1);
		// 가장 긴 부분 수열의 길이
		// 예시 6
		// 10 20 10 30 20 50
		// 정답 4
		// 10 20 30 50

		// i번째에 대해 0~i-1 번까지의 수보다 크고 가장 긴 값을 선택 => n^2
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (num[i] > num[j] && memo[i] <= memo[j]) {
					memo[i] = memo[j] + 1;
				}
			}
		}
		System.out.println(Arrays.stream(memo).max().getAsInt());
	}
}
