import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7193_승현이의수학공부 { // 제출일 2020-05-07 23:25 127,388 kb 373 ms
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			// N진법의 수 1천만 자리 X가 입력될 때
			// X를 N-1로 나눈 나머지는?
			// 각 자리를 모두 더한 다음 N-1로 나눈다
			char[] tmp = br.readLine().trim().toCharArray();
			int len = tmp.length;
			int N = tmp[0] - '0';
			int X = 0;
			if (N == 1) {
				for (int i = 3; i < len; i++) {
					X += tmp[i];
				}
				X -= 48 * (len - 3);
				ans = X % 9;
			} else if (N == 2) {
				ans = 0;
			} else {
				for (int i = 2; i < len; i++) {
					X += tmp[i];
				}
				X -= 48 * (len - 2);
				ans = X % (N - 1);
			}

			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}