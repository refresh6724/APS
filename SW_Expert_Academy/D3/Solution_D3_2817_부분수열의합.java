import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합 { // 제출일 2020-06-20 23:34 19,508 kb 125 ms

	static int[] A;
	static int n, k, answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 20개
			k = Integer.parseInt(st.nextToken()); // 목표 1000

			A = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			answer = 0;
			dfs(0, 0);

			sb.append('#').append(i).append(' ').append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int idx, int sum) {
		if (sum == k) {
			answer++;
			return;
		} else if (sum > k || idx == n) {
			return;
		}

		dfs(idx + 1, sum);
		dfs(idx + 1, sum + A[idx]);

	}
}
