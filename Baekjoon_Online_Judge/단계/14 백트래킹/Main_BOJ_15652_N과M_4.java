import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_15652_N과M_4 { // 제출일 2020-12-10 23:28

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 8 이하
		m = Integer.parseInt(st.nextToken()); // 8 이하
		num = new int[m];

		dfs(0, 1);

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

		for (int j = prev; j <= n; j++) {
			num[idx] = j;
			dfs(idx + 1, j);
		}
	}
}
