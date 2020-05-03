import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_8457_알덴테스파게티 { // 제출일 2020-05-03 23:38
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			int ans = 0;

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int timer = Integer.parseInt(st.nextToken());

				if ((timer <= (b + e)) && ((b % timer) <= e) || (b % timer) >= timer - e)
					ans++;
			}

			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
