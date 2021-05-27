import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_15649_N과M_1 { // 제출일 2020-12-07 23:22

	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 n과 m이 주어질 때 1부터 n까지 중복 없이 m개를 고른 수열을 모두 출력
		// 사전순으로
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 8 이하
		int m = Integer.parseInt(st.nextToken()); // 8 이하
		num = new int[m];
		visited = new boolean[n + 1];

		dfs(n, m, 0, 0);

		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int n, int m, int idx, int now) {

		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int j = 1; j <= n; j++) {
			if (!visited[j]) {
				visited[j] = true;
				num[idx] = j;
				dfs(n, m, idx + 1, j);
				visited[j] = false;
			}
		}
	}
}
