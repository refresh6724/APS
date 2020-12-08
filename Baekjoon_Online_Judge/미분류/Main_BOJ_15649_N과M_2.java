import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_15649_N과M_2 { // 제출일 2020-12-08 23:14

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 n과 m이 주어질 때 1부터 n까지 중복 없이 m개를 고른 수열을 모두 출력
		// 사전순으로
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 8 이하
		m = Integer.parseInt(st.nextToken()); // 8 이하
		num = new int[m];

		dfs(0, 0);

		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int idx, int prev) {

		if (idx == m) {
			sb.append(num[0]);
			for (int i = 1; i < m; i++) {
				sb.append(' ').append(num[i]);
			}
			sb.append('\n');
			return;
		}

		// 12 13 14 23 24 34

		for (int j = prev + 1; j <= n; j++) {
			num[idx] = j;
			dfs(idx + 1, j);
		}
	}
}
