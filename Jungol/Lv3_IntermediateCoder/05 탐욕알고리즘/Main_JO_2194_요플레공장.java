import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2194_요플레공장 { // 제출일 2021-06-08 23:06

	static int n, s;
	static long ans;
	static int[] c, y;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 우유 1리터당 c원, 필요량 y리터
		// 우유 1주일 보관에 리터당 s원
		// n주 동안 필요량을 충족하는 최소 운영 비용은?

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하
		s = Integer.parseInt(st.nextToken()); // 1 이상 1백 이하

		ans = 0;
		c = new int[n];
		y = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			c[i] = Integer.parseInt(st.nextToken()); // 1 이상 5천 이하
			y[i] = Integer.parseInt(st.nextToken()); // 0 이상 1만 이하
		}

	}

	private static void go() {

		// 첫 주는 비축유가 없으므로 전량 구매
		ans += c[0] * y[0];
		// 둘째 주부터 이번주 구매가와 지난 구매가 + 보관 비용을 비교하여 가장 작은 금액을 선택
		for (int i = 1; i < n; i++) {
			long min = c[i] * y[i];
			for (int j = 0, k = i - j; j < i; j++, k--) {
				min = Math.min(min, (long) (c[j] + k * s) * y[i]);
			}
			ans += min;
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}