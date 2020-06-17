
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1491_원재의벽꾸미기 { // 제출일 2020-06-17 20:49 19,424 kb 113 ms

	static long N, A, B, min, m1, m2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(' ');

			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			min = Long.MAX_VALUE;
			for (int R = 1;; R++) {
				// 중간계산은 필요없고 하나의 R에 C=R 인 경우와 C=N/R인 경우만 비교
				int C = (int) N / R;
				if (C < R)
					break;
				m1 = B * (N - (R * R));
				m2 = A * (C - R) + B * (N - (C * R));
				if (m1 < m2) {
					min = Math.min(min, m1);
				} else {
					min = Math.min(min, m2);
				}
			}
			sb.append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}