import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2000_동전교환 { // 제출일 2021-06-18 23:02

	static int n, w, ans;
	static int[] coin, memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 1 이상 10 이하
		coin = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken()); // 각 단계
		}
		w = Integer.parseInt(br.readLine().trim()); // 1 이상 64,000 이하
		memo = new int[w + 1];
		Arrays.fill(memo, 65000);
		for (int i = 0; i < n; i++) {
			memo[coin[i]] = 1;
		}

	}

	private static void go() {
		// w를 만드는데 필요한 동전의 최소 개수
//		ans = sol_1(w);
		ans = sol_2(w);

	}

	// Success(100)
	// 재귀가 아닌 반복문 사용
	private static int sol_2(int money) {
		for (int m = 1; m <= w; m++) {
			if (memo[m] == 1) {
				continue;
			}
			int min = 65000;
			for (int i = 0; i < n; i++) {
				if (m - coin[i] > 0) {
					min = Math.min(min, memo[m - coin[i]] + 1);
				}
			}
			memo[m] = min;
		}
		return memo[w];
	}

	// Time Limit Exceed(86)
	// d3.in : mem=13076k time=1906ms
	// imp 인 경우 끝까지 돌게 된다
	private static int sol_1(int money) {
		if (memo[money] != 65000) {
			return memo[money];
		}
		int min = memo[money];
		for (int i = 0; i < n; i++) {
			if (money > coin[i]) {
				min = Math.min(min, sol_1(money - coin[i]) + 1);
			}
		}
		return memo[money] = min;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append((ans == 65000) ? "impossible" : ans);
		bw.write(sb.toString());
		bw.flush();
	}

}