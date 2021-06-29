import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1858_DNA유사도 { // 제출일 2021-06-29 23:58

	static int n, m, lis, ma, mb;
	static char[] a, b;
	static int[][] memo;
	static int[][] lsp, rsp; // left, right starting point

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim());
		String t = br.readLine().trim();
		a = new char[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = t.charAt(i - 1);
		}

		m = Integer.parseInt(br.readLine().trim());
		t = br.readLine().trim();
		b = new char[m + 1];
		for (int i = 1; i <= m; i++) {
			b[i] = t.charAt(i - 1);
		}

		memo = new int[n + 1][m + 1];
		lsp = new int[n + 1][m + 1];
		rsp = new int[n + 1][m + 1];

		lis = 0;
		ma = 0;
		mb = 0;

		for (int left = 1; left <= n; left++) {
			for (int right = 1; right <= m; right++) {

				int plus = -2;
				if (a[left] == b[right]) {
					// 같은 경우에만 새로운 시작점이 될 수 있다
					memo[left][right] = 3;
					lsp[left][right] = left;
					rsp[left][right] = right;
					plus = 3;
				}

				if (memo[left][right] < memo[left - 1][right - 1] + plus) {
					memo[left][right] = memo[left - 1][right - 1] + plus;
					lsp[left][right] = lsp[left - 1][right - 1];
					rsp[left][right] = rsp[left - 1][right - 1];
				}

				// 공백 사용됨
				if (memo[left][right] < memo[left - 1][right] - 2) {
					memo[left][right] = memo[left - 1][right] - 2;
					lsp[left][right] = lsp[left - 1][right];
					rsp[left][right] = rsp[left - 1][right];
				}

				if (memo[left][right] < memo[left][right - 1] - 2) {
					memo[left][right] = memo[left][right - 1] - 2;
					lsp[left][right] = lsp[left][right - 1];
					rsp[left][right] = rsp[left][right - 1];
				}

				// 최대 부분합이 갱신될 때만
				if (lis < memo[left][right]) {
					lis = memo[left][right];
					ma = left;
					mb = right;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(lis).append('\n');
		for (int i = lsp[ma][mb]; i <= ma; i++) {
			sb.append(a[i]);
		}
		sb.append('\n');
		for (int i = rsp[ma][mb]; i <= mb; i++) {
			sb.append(b[i]);
		}
		sb.append('\n');

		bw.write(sb.toString());
		bw.flush();

	}

}