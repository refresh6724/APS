import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9461_파도반수열 { // 제출일 2020-12-21 23:28

	static int[] p = { 0, 1, 1, 1, 2, 2, 3, 4, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < TC; tc++) {
			// 나선 모양으로 이어지는 정삼각형 변의 길이
			// 0~10 : 0 1 1 1 2 2 3 4 5 7 9
			// n번째?
			int n = Integer.parseInt(br.readLine());
			if (n < 9) {
				sb.append(p[n]).append('\n');
			} else {
				long[] pp = new long[n + 1];
				for (int i = 0; i < p.length; i++) {
					pp[i] = p[i];
				}
				for (int i = 9; i <= n; i++) {
					pp[i] = pp[i - 5] + pp[i - 1];
				}
				sb.append(pp[n]).append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
