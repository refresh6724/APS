import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9839_최고의쌍 { // 제출일 2020-05-01 23:52 108,420kb 700ms
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			n = Integer.parseInt(br.readLine());
			// n 개의 숫자가 주어지면 그 중 둘을 골라 곱하고
			// 그 수가 오름차순이면 정답 후보다
			// n이 1000이므로 nC2 = 499,500

			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			ans = -1;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					calc(i, j);
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void calc(int i, int j) {
		// 1 일단 완전탐색

		int num = arr[i] * arr[j];
		// 이 숫자가 한자리라면 후보에 들어가고
		// 두 자리 이상일 경우 연속 오름차순이어야한다.

		// 10000 * 10000 = 100000000 억 (len == 9)
		// 123456789 불가능
		// len이 3이라면 123, 234, 345, 456, 567, 678, 789 5가지 경우의 수가 있다
		// len이 4라면 1234, 2345, ... , 6789
		// 1의 자리수가 len 이상이어야 한다

		if (num < 10) {
			ans = Math.max(ans, num);
		} else {
			char[] nums = Integer.toString(num).toCharArray();

			int len = nums.length;
			char last = nums[len - 1];
			int l = last - '0';
			if (l < len) { // last가 len보다 작다면
				return;
			} else {
				l--;
				for (int k = len - 2; k >= 0; k--, l--) {
					if (nums[k] != l + '0') {
						return;
					}
				}
				ans = Math.max(num, ans);
			}
		}
	}
}
