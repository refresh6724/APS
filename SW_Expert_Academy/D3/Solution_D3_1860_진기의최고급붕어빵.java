import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1860_진기의최고급붕어빵 { // 제출일 2020-06-19 23:27 32,764 kb 215 ms

	static int[] stack = new int[1 << 14];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(' ');

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 100
			int m = Integer.parseInt(st.nextToken()); // 100
			int k = Integer.parseInt(st.nextToken()); // 100

			// m 초가 지나면 k 개가 쌓인다
			Arrays.fill(stack, 0);
			for (int i = m; i < stack.length; i += m) {
				stack[i] = k;
			}
			st = new StringTokenizer(br.readLine());
			k = 0;
			m = 0;
			for (int i = 0; i < n; i++) {
				// 손님 도착시간은 섞여있다
				k = Integer.parseInt(st.nextToken());
				stack[k]--;
				m = (k > m) ? k : m;
			}

			//
			boolean isP = true;
			k = 0;
			for (int i = 0; i <= m; i++) {
				k += stack[i];
				if (k < 0) {
					isP = false;
					break;
				}
			}
			sb.append(isP ? "Possible" : "Impossible").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
	}

}