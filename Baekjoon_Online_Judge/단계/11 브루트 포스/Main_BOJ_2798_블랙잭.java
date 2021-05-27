import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class Main_BOJ_2798_블랙잭 { // 제출일 2020-11-19 23:17

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N장의 카드 중 3장을 골라 목표 M에 가장 가까운 수를 만들자
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 3 이상 100 이하
		int m = Integer.parseInt(st.nextToken()); // 10 이상 30만 이하
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int a = num[i] + num[j] + num[k];
					if (sum < a && a <= m) {
						sum = a;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
