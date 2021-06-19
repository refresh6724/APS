import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1077_배낭채우기1 { // 제출일 2021-06-19 23:20

	static int n, w;
	static int[] weight, price, memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1 이상 1천 이하 보석의 수
		w = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하 배낭 용량
		weight = new int[n];
		price = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken()); // 보석의 무게 w_i
			price[i] = Integer.parseInt(st.nextToken()); // 보석의 가치 p_i
		}
		memo = new int[w + 1];
	}

	private static void go() {
		for (int cost = 1; cost <= w; cost++) {
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (cost - weight[i] >= 0) {
					max = Math.max(max, memo[cost - weight[i]] + price[i]);
				}
			}
			memo[cost] = max;
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(memo[w]);
		bw.write(sb.toString());
		bw.flush();
	}

}