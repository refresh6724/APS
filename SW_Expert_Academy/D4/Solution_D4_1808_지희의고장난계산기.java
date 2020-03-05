import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 빠른 것보다 약 1.3배 걸림
public class Solution_D4_1808_지희의고장난계산기 { // 제출일 2020-03-06 00:01

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static boolean[] isCan;
	static int X;
	static int[] dp;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			isCan = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				isCan[i] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
			}
			X = Integer.parseInt(br.readLine());
			dp = new int[X + 1];
			min = dfs2(X);
			sb.append("#").append(t).append(" ").append((min == 0) ? -1 : min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int dfs2(int x) {
		if (dp[x] != 0) {
			return dp[x];
		}

		int test = x;
		int pos = 0;
		int size = 0;
		boolean find = true;

		while (test != 0) {
			pos = test % 10;
			if (!isCan[pos]) {
				find = false;
				break;
			}
			size++;
			test /= 10;
		}

		if (find) {
			dp[x] = size + 1;
			return dp[x];
		} else {
			int a = (int) Math.sqrt(x);
			do {
				while (x % a != 0) {
					a--;
				}
				if (a == 1)
					break;
				int b = x / a;

				int partA = dfs2(a);
				if (partA == 0) {
					continue;
				}
				int partB = dfs2(b);
				if (partB == 0) {
					continue;
				}
				if (dp[x] == 0) {
					dp[x] = partA + partB;
				} else {
					dp[x] = Math.min(dp[x], partA + partB);
				}
			} while (a-- != 1);
			return dp[x];
		}

	}

}
