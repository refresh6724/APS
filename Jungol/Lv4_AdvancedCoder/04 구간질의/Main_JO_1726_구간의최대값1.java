import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1726_구간의최대값1 { // 제출일 2021-07-27 23:30

	static int n, q;
	static int[] arr, segmentTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 원소 최대 5만개
		q = Integer.parseInt(st.nextToken()); // 구간 최대 20만개
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim()); // 각 원소 최대 1백만
		}
		int lgn = (int) Math.ceil(Math.log10(n) / Math.log10(2));
		segmentTree = new int[(int) Math.pow(2, lgn + 1)];
		build(1, 1, n);

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(query(1, 1, n, a, b)).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static int query(int now, int start, int end, int a, int b) {
		if (end < a || b < start) { // 구간 밖
			return 0;
		}
		if (a <= start && end <= b) { // 완전히 구간 내라면
			return segmentTree[now];
		}

		int left = now << 1;
		int right = left + 1;
		int mid = (start + end) / 2;
		return Math.max(query(left, start, mid, a, b), query(right, mid + 1, end, a, b));
	}

	private static void build(int i, int start, int end) {
		if (start > n) {
			return;
		}
		if (start == end) {
			segmentTree[i] = arr[start];
			return;
		}
		int j = i << 1;
		int mid = (start + end) / 2;
		build(j, start, mid);
		build(j + 1, mid + 1, end);
		segmentTree[i] = Math.max(segmentTree[j], segmentTree[j + 1]);
	}

}