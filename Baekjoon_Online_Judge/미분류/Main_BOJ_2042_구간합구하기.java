import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2042_구간합구하기 { // 제출일 2021-11-13 23:30

	static long[] arr;
	static long[] seg;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1 이상 1백만 이하
		int m = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하
		int k = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하
		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine()); // -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수
		}
		// 세그먼트 트리
		// 주어진 n에 가장 가까운 제곱수의 2배 크기 =>
		// 주어진 n의 4배 크기의 저장 공간을 생성
		seg = new long[n << 2];
		dfs(1, n, 1);

		for (int i = 1; i <= m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(1, n, 1, b, diff); // b 위치 값을 c로 대체				
			} else {
				sb.append(sum(1, n, 1, b, (int) c)).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void update(int start, int end, int idx, int a, long change) {

		if (a < start || end < a) { // idx 제한 추가?
			return;
		}
		seg[idx] += change;
		if (start == end) { // start > end 불가
			return;
		}
		int mid = (start + end) / 2;
		// return
		update(start, mid, idx * 2, a, change);
		update(mid + 1, end, idx * 2 + 1, a, change);
	}

	private static long sum(int start, int end, int idx, int a, int b) {
		if (end < a || b < start) {
			return 0;
		}
		if (a <= start && end <= b) {
			return seg[idx];
		}
		int mid = (start + end) / 2;
		return sum(start, mid, idx * 2, a, b) + sum(mid + 1, end, idx * 2 + 1, a, b);
	}

	private static long dfs(int start, int end, int idx) {
		if (start == end) {
			return seg[idx] = (long) arr[start];
		}
		int mid = (start + end) / 2;
		return seg[idx] = dfs(start, mid, idx * 2) + dfs(mid + 1, end, idx * 2 + 1);
	}

}