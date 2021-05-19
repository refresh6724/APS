import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1409_벽장문의이동 { // 제출일 2021-05-20 05:30

	static int n, m, a, b, ans;
	static int[] order;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine().trim());
		order = new int[m];
		for (int i = 0; i < m; i++) {
			order[i] = Integer.parseInt(br.readLine().trim());
		}
		ans = Integer.MAX_VALUE;
	}

	private static void go() {

		dfs(0, a, b, 0);

	}

	private static void dfs(int idx, int left, int right, int cnt) {
		if (idx == m) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (order[idx] <= left) {
			dfs(idx + 1, order[idx], right, cnt + (left - order[idx]));
		} else if (order[idx] >= right) {
			dfs(idx + 1, left, order[idx], cnt + (order[idx] - right));
		} else {
			dfs(idx + 1, order[idx], right, cnt + (order[idx] - left));
			dfs(idx + 1, left, order[idx], cnt + (right - order[idx]));
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