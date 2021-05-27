import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1011
 */
public class Main_BOJ_1011_FlymetotheAlphaCentauri { // 제출일 2020-11-04 23:22

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// x 지점에서 y 지점으로 이동할 때
		// n번째 이동거리 kn 은 이전 n-1번째 이동거리에서 -1, 0, +1 이어야 한다
		// 음수 이동은 허용되지 않으므로 첫번째 이동거리는 무조건 1이고
		// 추가 조건에 의해 마지막 이동거리도 무조건 1이다
		// 따라서 xy 거리에 따라서 경로는 제한될 수 밖에 없다
		// 1 : 1
		// 2 : 11
		// 3 : 111
		// 4 : 121
		// 5 : 1211
		// 6 : 1221
		// 7 : 12211
		// 8 : 12221
		// 9 : 12321
		// 10 : 123211
		// 11 : 123221
		// 12 : 123321
		// 13 : 1233211
		// 14 : 1233221
		// 15 : 1233321
		// 16 : 1234321

		// n^2 을 기준으로
		// (n-1)^2 +1 부터 n^2 - n 까지 2(n-1)
		// n^2 - n +1 부터 n^2 까지 2n-1 이다.

		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = y - x;

			int n = (int) Math.sqrt(d);
			if (d == n * n) {
				System.out.println(2 * n - 1);
			} else {
				n++;
				if (d <= (n * n - n)) {
					System.out.println(2 * (n - 1));
				} else {
					System.out.println(2 * n - 1);
				}
			}
		}
	}
}
