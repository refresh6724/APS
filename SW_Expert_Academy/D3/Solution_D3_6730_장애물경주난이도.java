import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_6730_장애물경주난이도 { // 제출일 2020-05-05 23:52

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			int left = 0, right = 0;
			if (n != 1) {
				int prev = Integer.parseInt(st.nextToken());
				int next = 0;
				for (int i = 1; i < n; i++) {
					next = Integer.parseInt(st.nextToken());
					if (next > prev && left < next - prev) {
						left = next - prev;
					} else if (next < prev && right < prev - next) {
						right = prev - next;
					}
					prev = next;
				}
			} else {
				int block = Integer.parseInt(st.nextToken());
			}

			sb.append("#").append(tc).append(" ").append(left).append(" ").append(right).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
