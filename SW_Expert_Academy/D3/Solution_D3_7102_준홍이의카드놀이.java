import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7102_준홍이의카드놀이 { // 제출일 2020-05-10 23:03 20,064 kb 119 ms

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

			int[] arr = new int[n + m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					arr[i + j]++;
				}
			}

			int max = 0;
			for (int i = 2; i < n + m + 1; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}

			for (int i = 2; i < n + m + 1; i++) {
				if (max == arr[i]) {
					sb.append(" ").append(i);
				}
			}

			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

}