import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9942_순열2 { // 제출일 2020-05-14 02:23 19,964 kb 4,761 ms

	static int[] fac = new int[11];
	static int[] memo = new int[81];
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i <= 10; i++) {
			fac[i] = fac[i - 1] * i;
		}

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 10 이하
//			int n = tc;
			int k = Integer.parseInt(st.nextToken()); // 100 이하

			int min = n * (n + 1) / 2;
			int max = n * (n + 1) - ((n % 2 == 1) ? (n + 1) / 2 : 0) - (n / 2) * (n / 2 + 1);

			Arrays.fill(memo, min, max + 1, 0);
			sb.append(min).append(" ").append(max).append("\n");

			if (k <= min) {
				sb.append((long) fac[n] * fac[n]).append("\n");
			} else if (k > max) {
				sb.append(0).append("\n");
			} else {
				visited = new boolean[n + 1];
				for (int i = 1; i <= n; i++) { // 스타트
					visited[i] = true;
					dfs(i, 1, 0);
					visited[i] = false;
				}

				int sum = 0;
				for (int i = k; i <= max; i++) {
					sum += memo[i];
				}
				sb.append((long) sum * fac[n]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int prev, int step, int sum) {
		sum += Math.max(prev, step);
		if (step == n) {
			memo[sum]++;
			return;
		}
		for (int next = 1; next <= n; next++) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, step + 1, sum);
				visited[next] = false;
			}
		}
	}
}