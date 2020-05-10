import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 기존 제출일 2020-05-10 23:03 20,064 kb 119 ms
// 개선 제출일 2020-05-10 23:11 19,460 kb 111 ms
public class Solution_D3_7102_준홍이의카드놀이 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc);

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n > m) {
				for (int i = m + 1; i <= n + 1; i++) {
					sb.append(" ").append(i);
				}
			} else {
				for (int i = n + 1; i <= m + 1; i++) {
					sb.append(" ").append(i);
				}
			}

			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

}