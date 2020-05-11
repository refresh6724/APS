import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_7087_문제제목붙이기 { // 제출일 2020-05-11 23:06 17,152 kb 108 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int n = Integer.parseInt(br.readLine());

			int[] alphabet = new int[26];
			for (int i = 0; i < n; i++) {
				alphabet[br.readLine().charAt(0) - 'A']++;
			}

			int idx = 0;
			while (idx < 26) {
				if (alphabet[idx] == 0) {
					sb.append(idx);
					break;
				}
				idx++;
			}
			if (idx == 26) {
				sb.append(idx);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

}