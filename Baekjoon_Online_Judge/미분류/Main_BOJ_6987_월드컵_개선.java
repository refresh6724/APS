import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 백준 6987 월드컵
public class Main { // 제출일 2019-10-10 09:59
	static int[][] matches;
	static int[] A;
	static int[] B;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		res = new int[4];
		makingMatch();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			matches = new int[6][3];
			boolean overSix = false;
			for (int j = 0; j < 6; j++) { // A B C D E F
				int sum = 0;
				for (int j2 = 0; j2 < 3; j2++) { // win draw lose
					int tmp = Integer.parseInt(st.nextToken());
					sum += tmp;
					matches[j][j2] = tmp;
				}
				if (sum > 5)
					overSix = true;
			}
			if (overSix) {

			} else {
				match(i, 0);
			}
		}
		System.out.println(String.format("%d %d %d %d", res[0], res[1], res[2], res[3]));
	}

	private static void makingMatch() {
		A = new int[15];
		B = new int[15];
		int match = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				A[match] = i;
				B[match++] = j;
			}
		}
	}

	private static void match(int idx, int cnt) {
		if (res[idx] == 1)
			return;
		if (cnt == 15) {
			res[idx] = 1;
			return;
		}

		int country1 = A[cnt];
		int country2 = B[cnt];
		if (matches[country1][0] > 0 && matches[country2][2] > 0) {
			matches[country1][0]--;
			matches[country2][2]--;
			match(idx, cnt + 1);
			matches[country1][0]++;
			matches[country2][2]++;
		}

		if (matches[country1][1] > 0 && matches[country2][1] > 0) {
			matches[country1][1]--;
			matches[country2][1]--;
			match(idx, cnt + 1);
			matches[country1][1]++;
			matches[country2][1]++;
		}

		if (matches[country1][2] > 0 && matches[country2][0] > 0) {
			matches[country1][2]--;
			matches[country2][0]--;
			match(idx, cnt + 1);
			matches[country1][2]++;
			matches[country2][0]++;
		}

	}
}