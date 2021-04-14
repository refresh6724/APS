import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 
public class Main_JO_1300_숫자구슬 { // 제출일 2021-04-14 23:50 60/100

	static int n, m, ans;
	static int[] arr, sum, ansArr;
	static boolean hasZero;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 300 이하
		m = Integer.parseInt(st.nextToken()); // n 이하
		ans = 300 * 100;
		arr = new int[n];
		sum = new int[m];
		ansArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 100 이하
		}
		hasZero = false;
	}

	private static void go() {
		int low = 1;
		int high = ((n / m) + 1) * 100;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (split(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (low + high) / 2;
		}

		if (hasZero) {
			prove();
		}

	}

	private static boolean split(int mid) {
		//
		int prev = 0;
		int next = 0;
		int cnt = 0;
		int subSum = 0;
		while (cnt != m) {
			// 부분합이 mid 이하가 될 때까지 맞춰준다
			while (next != n && subSum + arr[next] <= mid) {
				subSum += arr[next++];
			}
			subSum = 0;
			sum[cnt++] = next - prev;
			prev = next;

			if (cnt == m) {
				if (next == n) {
					if (ans > mid) {
						ans = mid;
						for (int i = 0; i < m; i++) {
							ansArr[i] = sum[i];
							if (ansArr[i] == 0) {
								hasZero = true;
							}
						}
					}
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private static void prove() {
		// 6 4
		// 1 1 1 4 1 1
		// 3 1 2 0
		// 마지막이 0으로 끝나는 경우
		// 끝부분부터 2 이상이 발견될 때 1을 나눠준다
		for (int i = m - 2; i >= 0; i--) {
			if (ansArr[i] > 1) {
				ansArr[i] -= 1;
				for (int j = m - 1; j >= i + 2; j--) {
					ansArr[j] = ansArr[j - 1];
				}
				ansArr[i + 1] = 1;
				break;
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append('\n');
		for (int i = 0; i < m; i++) {
			sb.append(ansArr[i]).append(' ');
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}

}