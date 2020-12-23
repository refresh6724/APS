import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2579
 */
public class Main_BOJ_2579_계단오르기 { // 제출일 2020-12-23 23:36

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 계단을 한칸 또는 두칸 오를 수 있고
		// 연속으로 3개를 선택할 수 없을 때 가장 많이 선택하는 경우
		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(br.readLine());
		} else if (n == 2) {
			System.out.println(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()));
		} else {
			int[][] num = new int[n + 1][2];
			// 0 : 이전 계단을 밟지 않음 = 2칸 이동했다 = 다음 칸을 밟을 수도 있고 다다음 칸으로 갈 수도 있다
			// 1 : 이전 계단을 밟음 = 1칸 이동했다 = 다음 칸은 밟을 수 없다
			num[1][0] = Integer.parseInt(br.readLine());
			num[2][0] = Integer.parseInt(br.readLine());
			num[2][1] = num[1][0] + num[2][0];
			int step = Integer.parseInt(br.readLine());
			num[3][0] = num[1][0] + step;
			num[3][1] = num[2][0] + step;
			for (int i = 4; i <= n; i++) {
				step = Integer.parseInt(br.readLine());
				num[i][0] = Math.max(num[i - 2][0], num[i - 2][1]) + step;
				num[i][1] = num[i - 1][0] + step;
			}
			System.out.println(Math.max(num[n][0], num[n][1]));
		}
	}
}
