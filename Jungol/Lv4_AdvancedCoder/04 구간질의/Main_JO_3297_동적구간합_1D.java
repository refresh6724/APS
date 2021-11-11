import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 자바는 시간초과로 못푸는 문제인가?
public class Main_JO_3297_동적구간합_1D { // 제출일 2021-11-11 23:19

	static int[] arr;
	static long[] seg;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 10 ≤ N ≤ 1,000,000
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // -1,000,000 ≤ Ai ≤ 1,000,000
		}
		// 세그먼트 트리
		// 주어진 n의 4배 크기의 저장 공간을 생성
		seg = new long[n << 2];
		dfs(1, n, 1);

		int t = Integer.parseInt(br.readLine()); // 10 ≤ M ≤​ 300,000
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int change = b - arr[a];
			if (order == 1) {
				replace(1, n, 1, a, change); // a 위치 값을 b로 대체
			} else {
				sb.append(sum(1, n, 1, a, b)).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void replace(int start, int end, int idx, int a, int change) {
		if (a < start || end < a) {
			return;
		}
		seg[idx] += change;
		if (start == end) {
			return;
		}
		int mid = (start + end) / 2;
		// return
		replace(start, mid, idx * 2, a, change);
		replace(mid + 1, end, idx * 2 + 1, a, change);
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