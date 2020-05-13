import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9940_순열1 { // 제출일 2020-05-13 23:10 92,272 kb 267 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];

			boolean is = true;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int a = Integer.parseInt(st.nextToken());
				if (arr[a] != 0) {
					is = false;
					break;
				} else {
					arr[a]++;
				}
			}
			if (is) {
				sb.append("Yes").append("\n");
			} else {
				sb.append("No").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}