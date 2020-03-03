import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_formula { // 제출일 2020-03-03 15:52
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());

			int lx = Math.abs(sx - fx);
			int ly = Math.abs(sy - fy);

			int ans = 0;
			int diff = lx - ly;
			if (diff > 0) {
				ans += ly << 1;
				ans += diff << 1;
				if (diff % 2 != 0) {
					ans -= 1;
				}
			} else if (diff < 0) {
				diff *= -1;
				ans += lx << 1;
				ans += diff << 1;
				if (diff % 2 != 0) {
					ans -= 1;
				}
			} else {
				ans = lx << 1;
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
