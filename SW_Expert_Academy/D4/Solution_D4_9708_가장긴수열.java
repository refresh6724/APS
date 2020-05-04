import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//제출일 2020-05-04 17:42 95,424 kb 413 ms
public class Solution_D4_9708_가장긴수열 { 

	static int n;
	static int[] arr;
	static int[] memo = new int[1000001];
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());

			parse();

			int ans = 1;
			if (n != 1) {
				Arrays.sort(arr);
				fillOne();
				if (arr[0] == 1) {
					ans = getMax(1);
					ans++;
				} else {
					ans = getMax(0);
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
//          System.out.println(String.format("#%d %d", tc, ans));
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void fillOne() {
		for (int i = 0; i < n; i++) {
			memo[arr[i]] = 1;
		}
	}

	private static void parse() {
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static int getMax(int idx) {
		int max = 0;
		for (int i = idx; i < n; i++) {
			for (int j = arr[i] << 1; j <= arr[n - 1]; j += arr[i]) {
				if (memo[j] != 0 && memo[j] <= memo[arr[i]]) {
					memo[j] = memo[arr[i]] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (max < memo[arr[i]]) {
				max = memo[arr[i]];
			}
		}
		return max;
	}
}