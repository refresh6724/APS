import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 기존 제출일 2020-05-14 02:23 19,964 kb 4,761 ms
// 개선 제출일 2020-05-15 00:08 20,168 kb 177 ms
public class Solution_D4_9942_순열2 {

	static int[] fac = new int[11];
	static int[][] memo = new int[11][81];
	static int[] min, max, arr;
	static int n, tmp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		factorial();
		memoization();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 10 이하
			int k = Integer.parseInt(st.nextToken()); // 100 이하

			if (k <= min[n]) {
				sb.append((long) fac[n] * fac[n]).append("\n");
			} else if (k > max[n]) {
				sb.append(0).append("\n");
			} else {
				tmp = 0;
				for (int i = k; i <= max[n]; i++) {
					tmp += memo[n][i];
				}
				sb.append((long) tmp * fac[n]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void memoization() {
		min = new int[11];
		max = new int[11];
		for (n = 1; n < 11; n++) {
			min[n] = n * (n + 1) / 2;
			max[n] = n * (n + 1) - ((n % 2 == 1) ? (n + 1) / 2 : 0) - (n / 2) * (n / 2 + 1);
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}

			for (int i = 0; i < fac[n]; i++) {
				calc();
				nextPermutaion();
			}
		}
	}

	private static void factorial() {
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i <= 10; i++) {
			fac[i] = fac[i - 1] * i;
		}
	}

	private static void calc() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.max(i + 1, arr[i]);
		}
		memo[n][sum]++;
	}

	private static void nextPermutaion() {
		// 처음으로 꺾이는 지점
		int pt = n - 2;
		while (pt >= 0) {
			if (arr[pt] < arr[pt + 1]) {
				break;
			}
			pt--;
		}

		if (pt < 0) {
			return;
		}

		// 바꿔야 하는 숫자의 위치
		int idx = n - 1;
		for (int i = n - 1; i > pt; i--) {
			if (arr[i] > arr[pt]) {
				idx = i;
				break;
			}
		}
		swap(pt, idx);
		reverse(pt + 1, n - 1);
	}

	private static void swap(int i, int j) {
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void reverse(int i, int j) {
		while (i < j) {
			swap(i++, j--);
		}
	}

}