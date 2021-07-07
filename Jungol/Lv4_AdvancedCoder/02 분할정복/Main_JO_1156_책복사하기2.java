import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1156_책복사하기2 { // 제출일 2021-07-07 22:06

	static int m, k, max;
	static int[] page;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 책의 권수 500 => 10만 이하
		k = Integer.parseInt(st.nextToken()); // 서기공의 수 m 이하
		max = 0;
		page = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < m; j++) {
			page[j] = Integer.parseInt(st.nextToken()); // 페이지 수 각 1억 => 1천만 이하
			max = Math.max(max, page[j]);
		}
		// 가장 많은 페이지를 맡은 서기공의 페이지가 최소가 되도록 책을 배분

		long low = 0;
		long high = 1000000000000L; // 500억 => 1조 = 10만 명 * 1천만

		while (low + 1 < high) {
			long mid = (low + high) / 2;
			if (split(mid)) {
				high = mid;
			} else {
				low = mid;
			}
		}

		// 거꾸로 뒤에서부터 카운트
		long ans = high;
		long now = 0;
		int cnt = 1;
		boolean[] slash = new boolean[m];
		for (int j = m - 1; j >= 0; j--) {
			if (now + page[j] > high) {
				now = page[j];
				cnt++;
				slash[j] = true;
			} else {
				now += page[j];
			}
		}

		for (int j = 0; j < m; j++) {
			if (cnt >= k) {
				break;
			}
			if (!slash[j]) {
				slash[j] = true;
				cnt++;
			}
		}

		for (int j = 0; j < m; j++) {
			sb.append(page[j]).append(' ');
			if (slash[j]) {
				sb.append("/ ");
			}
		}
		sb.append('\n');

		bw.write(sb.toString());
		bw.flush();

	}

	/**
	 * 페이지 최대수 mid가 정해졌을때 k명이 나눌 수 있으면 true 아니면 false
	 * 
	 * @param mid
	 * @return
	 */
	private static boolean split(long mid) {
		if (mid < max) {
			return false;
		}
		int cnt = 1;
		long now = 0;
		for (int i = 0; i < m; i++) {
			if (now + page[i] > mid) {
				now = page[i];
				cnt++;
			} else {
				now += page[i];
			}
		}
		return (cnt <= k);
	}

}