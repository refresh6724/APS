import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_6958_동철이의프로그래밍대회 { // 제출일 2020-05-12 23:22 16,084 kb 98 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 사람
			int m = Integer.parseInt(st.nextToken()); // 문제

//			int[][] solve = new int[n][m];
//			for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < m; j++) { // 풀었으면 1
//					solve[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}

			int[] solve = new int[n];
			for (int i = 0; i < n; i++) {
				String res = br.readLine();
				for (int j = 0; j < m; j++) {
					if (res.charAt(j << 1) == '1') {
						solve[i]++;
					}
				}
			}

			int first = 0;
			int problem = 0;

			for (int i = 0; i < n; i++) {
				if (problem < solve[i]) {
					problem = solve[i];
					first = 1;
				} else if (problem == solve[i]) {
					first++;
				}
			}

			// 가장 많이 문제를 푼 사람의 수와 그 문제의 숫자
			sb.append(first).append(" ").append(problem).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

}