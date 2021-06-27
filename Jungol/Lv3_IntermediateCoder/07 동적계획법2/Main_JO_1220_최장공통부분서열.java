
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_JO_1220_최장공통부분서열 { // 제출일 2021-06-27 23:38

	static char[] left, right;
	static int l, r;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine().trim();
		String b = br.readLine().trim();
		l = a.length();
		r = b.length();
		left = new char[l + 1];
		for (int i = 0; i < l; i++) {
			left[i + 1] = a.charAt(i);
		}
		right = new char[r + 1];
		for (int i = 0; i < r; i++) {
			right[i + 1] = b.charAt(i);
		}
		memo = new int[l + 1][r + 1];
	}

	private static void go() throws Exception {

		for (int i = 1; i <= l; i++) {
			for (int j = 1; j <= r; j++) {
				if (left[i] == right[j]) {
					memo[i][j] = getMax(i - 1, j - 1) + 1;
				} else {
					memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(Arrays.stream(memo[l]).max().getAsInt());
		bw.write(sb.toString());
		bw.flush();
	}

	private static int getMax(int i, int j) {
		int ret = memo[0][j];
		for (int k = 1; k <= i; k++) {
			ret = Math.max(ret, memo[k][j]);
		}
		return ret;
	}

}