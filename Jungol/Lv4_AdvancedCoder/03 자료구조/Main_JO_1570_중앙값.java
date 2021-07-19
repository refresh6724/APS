import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_JO_1570_중앙값 { // 제출일 2021-07-19 23:37

	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine().trim()); // 3 이상 2만 미만 홀수
		m = (n - 1) >> 1;

		// 더블링크드리스트?
		// min heap + max heap
		PriorityQueue<Integer> morethanpivot = new PriorityQueue<Integer>();
		PriorityQueue<Integer> lessthanpivot = new PriorityQueue<Integer>(Collections.reverseOrder());

		int pivot, a, b;
		pivot = Integer.parseInt(br.readLine().trim());
		sb.append(pivot).append('\n');
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // -3만 ~ 3만
			b = Integer.parseInt(st.nextToken());
			if (pivot < a) {
				if (pivot < b) {
					morethanpivot.add(a);
					morethanpivot.add(b);
					lessthanpivot.add(pivot);
					pivot = morethanpivot.poll();
				} else if (pivot >= b) {
					morethanpivot.add(a);
					lessthanpivot.add(b);
				}
			} else if (pivot == a) {
				if (pivot < b) {
					morethanpivot.add(b);
					lessthanpivot.add(a);
				} else if (pivot == b) {
					morethanpivot.add(b);
					lessthanpivot.add(a);
				} else if (pivot > b) {
					lessthanpivot.add(b);
					morethanpivot.add(a);
				}
			} else if (pivot > a) {
				if (pivot <= b) {
					lessthanpivot.add(a);
					morethanpivot.add(b);
				} else if (pivot > b) {
					lessthanpivot.add(a);
					lessthanpivot.add(b);
					morethanpivot.add(pivot);
					pivot = lessthanpivot.poll();
				}
			}
			sb.append(pivot).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();

	}

}