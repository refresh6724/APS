import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2817_로또Lotto { // 제출일 2021-04-01 23:44

	static int n;
	static int[] arr, lotto;
	static StringBuilder ans;

	public static void main(String[] args) throws Exception {
		input();
		run();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 3 이상 100 이하 // 완제품
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lotto = new int[6];
		ans = new StringBuilder();
	}

	private static void run() {
		// lidx 위치에 arr[idx]를 넣는다 넣지 않는다
		int lidx = 0;
		for (int idx = 0; idx < n; idx++) {
			lotto[lidx] = arr[idx];
			dfs(lidx + 1, idx + 1);
		}
	}

	private static void dfs(int lidx, int idx) {
		if (lidx == 6) {
			ans.append(print());
			return;
		}
		if (idx == n) {
			return;
		}

		for (int next = idx; next < arr.length; next++) {
			lotto[lidx] = arr[next];
			dfs(lidx + 1, next + 1);
		}

	}

	private static String print() {
		StringBuilder sb = new StringBuilder();
		sb.append(lotto[0]);
		for (int i = 1; i < 6; i++) {
			sb.append(' ').append(lotto[i]);
		}
		sb.append('\n');
		return sb.toString();
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans.toString());
		bw.flush();
	}

}