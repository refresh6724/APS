import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class Main_BOJ_2839_설탕배달 { // 제출일 2020-10-29 23:10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 3 이상 5000 이하 N 입력
		// n = 3x + 5y 일때 x+y의 최솟값은? 단, x>=0, y>=0
		// 해가 없을 경우 -1 리턴

		// n 최댓값이 5000 밖에 안되므로
		// y값이 최대일 때부터 x값을 0에서 하나씩 늘려가면서
		// 일치할 때를 리턴하는 것이 최적값이다
		// 만약 y가 0이하로 내려갔는데도 해가 나오지 않는다면 -1을 출력

		int n, x, y, ans;
		n = Integer.parseInt(br.readLine());

		y = n / 5;
		x = (n % 5) / 3;
		ans = -1;

		while (y >= 0) {

			if (n == (y * 5) + (x * 3)) {
				ans = x + y;
				break;
			}

			y--;
			x = (n - (y * 5)) / 3;
		}

		System.out.println(ans);

	}
}
