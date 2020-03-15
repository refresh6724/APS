import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9659_다항식계산 { // 제출일 2020-03-15 23:57

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int[] f, t, a, b;
	static final int MOD = 998244353;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			f = new int[N + 1];
			t = new int[N + 1];
			a = new int[N + 1];
			b = new int[N + 1];
			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sb.append("#" + tc);
			int[] x = new int[M + 1];
			for (int i = 1; i <= M; i++) {
				Arrays.fill(f, -1);
				x[i] = Integer.parseInt(st.nextToken());
				sb.append(" " + f_N(N, x[i])); //
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int f_N(int n, int x_i) {
		if (f[n] != -1) {
			return f[n];
		} else if (n == 1) {
			return f[1] = x_i;
		} else if (n == 0) {
			return f[0] = 1;
		}
		long tmp = 0;
		if (t[n] == 1) {
			tmp = (long) f_N(a[n], x_i) + (long) f_N(b[n], x_i);
		} else if (t[n] == 2) {
			tmp = (long) a[n] * (long) f_N(b[n], x_i);
		} else if (t[n] == 3) {
			tmp = (long) f_N(a[n], x_i) * (long) f_N(b[n], x_i);
		}
		f[n] = (int) (tmp % MOD);
		return f[n];
	}

}
