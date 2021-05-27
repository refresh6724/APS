import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2156_포도주시식 { // 제출일 2020-12-18 23:53 수정 2020-12-19 00:41

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연속으로 3개를 선택할 수 없을 때 가장 많은 수를 선택하는 경우
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n + 1];
		int[] drink = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			System.out.println(num[1]);
		} else if (n == 2) {
			System.out.println(num[1] + num[2]);
		} else if (n == 3) {
			System.out.println(Math.max(num[1] + num[2], Math.max(num[1] + num[3], num[2] + num[3])));
		} else {
			// 무조건 마신다고 가정할 때
			drink[1] = num[1];
			drink[2] = drink[1] + num[2];
			drink[3] = Math.max(num[1], num[2]) + num[3];
			for (int i = 4; i <= n; i++) {
				drink[i] = Math.max(drink[i - 2], Math.max(drink[i - 3], drink[i - 4]) + num[i - 1]) + num[i];
			}
			System.out.println(Math.max(drink[n], Math.max(drink[n - 1], drink[n - 2])));
		}

	}

}
