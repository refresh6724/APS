import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2499_저울 { // 제출일 2021-06-09 23:13

	static int n, ans;
	static int[] weight;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine()); // 1 이상 1천 이하
		weight = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken()); // 1 이상 1백만 이하
		}
		// 최대 1천 * 1백만 = 10억
		// n개를 선택하거나 선택하지 않거나 2^1000 = 1.071509e+301
	}

	private static void go() {

		Arrays.parallelSort(weight);
		if (weight[0] != 1) {
			ans = 1;
			return;
		}
		int sum = 1;
		for (int i = 0; i < n && sum >= weight[i]; i++) {
			sum += weight[i];
		}
		ans = sum;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}