import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1278_배낭채우기2 { // 제출일 2021-06-20 23:44

	static int n, w;
	static int[] weight, price;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1 이상 1천 이하 보석의 수
		w = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하 배낭 용량
		weight = new int[n + 1];
		price = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken()); // 보석의 무게 w_i
			price[i] = Integer.parseInt(st.nextToken()); // 보석의 가치 p_i 1 이상 1만 미만
		}
		memo = new int[n + 1][w + 1];
	}

	// 1과는 다르게 보석을 한 개만 쓸 수 있다.
	// 즉 무게 중심이 아니라 보석 중심으로 계산한다
	private static void go() throws IOException {

		for (int jewel = 1; jewel <= n; jewel++) {
			for (int cost = 1; cost <= w; cost++) {
				if (weight[jewel] <= cost) {
					memo[jewel][cost] = Math.max(memo[jewel - 1][cost], memo[jewel - 1][cost - weight[jewel]] + price[jewel]);
				} else {
					memo[jewel][cost] = memo[jewel - 1][cost];
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(memo[n][w]);
		bw.write(sb.toString());
		bw.flush();
	}

}