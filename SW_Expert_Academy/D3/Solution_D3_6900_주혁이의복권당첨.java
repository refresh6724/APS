import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_6900_주혁이의복권당첨 { // 제출일 2020-05-16 23:36 28,772 kb 136 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String[] 당첨번호 = new String[n];
			int[] 당첨금 = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				당첨번호[i] = st.nextToken();
				당첨금[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			for (int i = 0; i < m; i++) {
				String 복권 = br.readLine();
				for (int j = 0; j < n; j++) {
					if (match(복권, 당첨번호[j])) {
						sum += 당첨금[j];
					}
				}

			}
			sb.append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static boolean match(String 복권, String 당첨번호) {
		for (int i = 0; i < 8; i++) {
			if (당첨번호.charAt(i) != '*' && 복권.charAt(i) != 당첨번호.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
