import java.io.DataInputStream;
import java.io.IOException;

// 최초 제출일 2020-05-29 23:59 20,988 kb 2,133 ms
// 3차 제출일 2020-05-30 01:24 20,704 kb 993 ms
// 7차 제출일 2020-06-01 03:41 55,100 kb 208 ms
public class Solution_D3_6808_규영이와인영이의카드게임 {

	static final int CARD = 9;
	static final int PAIR = 18;
	static int[] a = new int[CARD];
	static int[] b = new int[CARD];
	static int[] fact = new int[CARD + 1];
	static int halfMaxScore = (PAIR) * (PAIR + 1) >> 2;
	// n*(n+1)/2 = 171
	// 1에서 18까지의 합의 절반 // 85
	// 84에서 다음 비교가 18+17 인 경우까지
	static int[][] memo;
	static int win, lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i <= CARD; i++) {
			fact[i] = i * fact[i - 1];
		}

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			int[] num = new int[PAIR + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < CARD; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				num[a[i]] = 1;
			}

			for (int i = 1, j = 0; i <= PAIR; i++) {
				if (num[i] == 0) {
					b[j++] = i;
				}
			}

			memo = new int[halfMaxScore + PAIR << 1][1 << CARD];
			for (int i = 0; i < halfMaxScore + PAIR << 1; i++) {
				Arrays.fill(memo[i], -1);
			}

			win = dfs(0, 0, 0, 0);
			// 총점이 171 점으로 홀수이므로 무승부는 없다
			sb.append("#").append(tc).append(' ').append(win).append(' ').append(fact[9] - win).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int dfs(int visited, int step, int scoreA, int scoreB) {

		if (memo[scoreA][visited] != -1) {
			return memo[scoreA][visited];
		}

		if (scoreA > halfMaxScore) {
			return memo[scoreA][visited] = fact[CARD - step];
		} else if (scoreB > halfMaxScore) {
			return memo[scoreA][visited] = 0;
		}

		int ret = 0;
		for (int next = 0; next < CARD; next++) {
			if ((visited & (1 << next)) == 0) {
				int plus = a[step] + b[next];
				if (a[step] > b[next]) {
					ret += dfs(visited | (1 << next), step + 1, scoreA + plus, scoreB);
				} else if (a[step] < b[next]) {
					ret += dfs(visited | (1 << next), step + 1, scoreA, scoreB + plus);
				}

			}
		}
		memo[scoreA][visited] = ret;
		return ret;
	}
}