import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2616_앱 { // 제출일 2021-05-03 19:06

	static int n, m, ans;
	static int[] memory, cost, memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1 이상 100 이하
		m = Integer.parseInt(st.nextToken()); // 1 이상 1천만 이하

		memory = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(st.nextToken()); // 1 이상 1천만 이하
		}

		cost = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken()); // 0 이상 100 이하
		}
	}

	private static void go() {
		// 코스트를 최소화하며 메모리 합이 m 이상이 되도록 선택

		// 0-1 냅색

		// 그리디
		// 메모리/코스트 비율로 1 코스트 당 메모리 효율이 높은 것부터 선택

		// dfs
		// n가지를 선택하거나 선택하지 않거나 최대 2^100 가지 경우의 수

		// dp - 메모이제이션
		// 최대 100 * 100 코스트에 대해 얻을 수 있는 메모리의 최대합을 계산
		// 최대 100 * 10000번
		memo = new int[10001];
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] == 0) {
				m -= memory[i];
			} else {
				int c = cost[i];
				for (int j = 10000; j >= c; j--) {
					memo[j] = Math.max(memo[j], memo[j - c] + memory[i]);
				}
			}
		}

		for (int i = 0; i < 10001; i++) {
			if (memo[i] >= m) {
				ans = i;
				return;
			}
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