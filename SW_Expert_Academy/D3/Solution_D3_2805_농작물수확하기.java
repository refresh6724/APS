import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 최초 제출일 2019-08-09 17:45 35,932 kb 194 ms
// 개선 제출일 2020-06-09 23:49 19,880 kb 101 ms

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 1) {
				sb.append('#').append(i).append(' ').append(Integer.parseInt(br.readLine())).append('\n');
				continue;
			}
			int half = n >> 1;
			int start = half;
			int len = 1;
			int ans = 0;
			char[] a = new char[n];
			for (int j = 0; j < n; j++) {
				a = br.readLine().toCharArray();
				for (int k = 0; k < len; k++) {
					ans += a[start + k] - '0';
				}
				if (start-- == 0) { // start는 -1이 된다
					break; // len은 그대로 n
				} else {
					len += 2;
				}
			}
			start = 1;
			len = n - 2;
			for (int j = 0; j < n; j++) {
				a = br.readLine().toCharArray();
				for (int k = 0; k < len; k++) {
					ans += a[start + k] - '0';
				}
				if (start++ == half) { // start는 n이 된다
					break;
				} else {
					len -= 2;
				}
			}
			sb.append('#').append(i).append(' ').append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
