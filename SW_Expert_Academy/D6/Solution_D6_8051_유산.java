import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 기존 제출일 2019-08-28 11:58 37,932 kb 3,472 ms
// 개선 제출일 2020-05-09 01:13 24,584 kb 2,901 ms
public class Solution_D6_8051_유산 {

	static long[][] info;
	static final int SPACE = 0;
	static final int PRICE = 1;
	static int N;
	static long answer, D, tS, tP, dS, dP; // total, diff

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Long.parseLong(st.nextToken());
			tS = 0; // total space
			tP = 0; // total price
			info = new long[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][SPACE] = Long.parseLong(st.nextToken());
				info[i][PRICE] = Long.parseLong(st.nextToken());
				tS += info[i][SPACE];
				tP += info[i][PRICE];
			}

			Arrays.sort(info, new Comparator<long[]>() {
				@Override
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o2[0], o1[0]);
				}
			});
			dfs(0, 0, 0, 0, 0, tS, tP);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void dfs(int idx, long hoS, long hoP, long daS, long daP, long rS, long rP) { // rest
		dS = hoS - daS;
		dP = hoP - daP;
		if (idx == N) {
			if (abs(dS) > D || dP < 0)
				return;
			ans(dP);
			return;
		}
		if (dP + rP < 0 || abs(dS) > rS + D || answer > rP + dP)
			return;

		rS -= info[idx][SPACE];
		rP -= info[idx][PRICE];

		dfs(idx + 1, hoS + info[idx][SPACE], hoP + info[idx][PRICE], daS, daP, rS, rP);
		dfs(idx + 1, hoS, hoP, daS + info[idx][SPACE], daP + info[idx][PRICE], rS, rP);
		dfs(idx + 1, hoS, hoP, daS, daP, rS, rP);
	}

	private static long abs(long a) {
		return a > 0 ? a : (-a);
	}

	private static void ans(long dp) {
		if (answer < dp) {
			answer = dp;
		}
	}

}
