
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호 { // 제출일 2020-06-11 00:28 17,684 kb 95 ms

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t);

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] origin = st.nextToken().toCharArray();
			char[] output = new char[N + 1];

			int idx = 1;
			char prev = 47;
			char next = 47;
			int count = 0;
			for (int i = 0; i < N; i++) {
				next = origin[i];
				if (prev != next) {
					output[idx++] = next;
					prev = next;
				} else {
					count++;
					output[--idx] = 0;
					prev = output[i - (count << 1) + 1];
				}
			}
//	           System.out.println(idx);
			sb.append(' ');
			for (int i = 1; i < idx; i++) {
				sb.append(output[i]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}