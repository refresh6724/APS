import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1976_시각검증 { // 제출일 2020-01-11 23:38

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 시 분으로 이루어진 시각을 2개 입력 받아, 더한 값을 시 분으로 출력하는 프로그램을 작성하라.
			// 시각은 12시간제로 표시한다. 즉, 시가 가질 수 있는 값은 1시부터 12시이다.
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			b += d;
			if (b >= 60) {
				b -= 60;
				a++;
			}

			a += c;
			if (a > 12)
				a -= 12;
			sb.append("#").append(test_case).append(" ").append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb.toString());
	}
}
