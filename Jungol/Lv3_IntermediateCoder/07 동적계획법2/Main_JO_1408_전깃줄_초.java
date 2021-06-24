import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1408_전깃줄_초 { // 제출일 2021-06-24 23:06

	static int n, max;
	static int[] memo;
	static int[][] wire;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim()); // 전깃줄 수 1 이상 100 이하
		memo = new int[n + 1];
		wire = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (wire[i][1] > wire[j][1]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(n - 1 - Arrays.stream(memo).max().getAsInt());
		bw.write(sb.toString());
		bw.flush();
	}

}