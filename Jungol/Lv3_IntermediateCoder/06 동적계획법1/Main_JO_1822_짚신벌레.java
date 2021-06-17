import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1822_짚신벌레 { // 제출일 2021-06-17 23:39

	static int a, b, d, n, ans, young, adult, old;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		// 0 < a < b < d <= 10,000
		// 1 <= N <= 1,000,000
		memo = new int[n + 1];
		memo[0] = 1; // 0 일에 태어난 벌레 1마리
		ans = 1;
		adult = 0;
	}

	private static void go() {

		if (n < a) {
			for (int day = 1; day < n; day++) {
				memo[day] = 0;
			}
		} else if (n < b) {
			for (int day = 1; day < a; day++) {
				memo[day] = 0;
			}
			for (int day = a; day < n; day++) {
				adult += memo[day - a];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
			}
		} else if (n < d) {
			for (int day = 1; day < a; day++) {
				memo[day] = 0;
			}
			for (int day = a; day < b; day++) {
				adult += memo[day - a];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
			}
			for (int day = b; day < n; day++) {
				adult += memo[day - a] + 1000;
				adult -= memo[day - b];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
			}
		} else {
			for (int day = 1; day < a; day++) {
				memo[day] = 0;
			}
			for (int day = a; day < b; day++) {
				adult += memo[day - a];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
			}
			for (int day = b; day < d; day++) {
				adult += memo[day - a] + 1000;
				adult -= memo[day - b];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
			}
			for (int day = d; day <= n; day++) {
				adult += memo[day - a] + 1000;
				adult -= memo[day - b];
				adult %= 1000;
				memo[day] = adult;
				ans += memo[day];
				ans -= memo[day - d];
			}
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans % 1000);
		bw.write(sb.toString());
		bw.flush();
	}

}