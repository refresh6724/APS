import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 { // 제출일 2020-01-18 23:28

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int size = n - m + 1;
			int[][] score = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					for (int i2 = 0; i2 < m; i2++) {
						for (int j2 = 0; j2 < m; j2++) {
							score[i][j] += map[i + i2][j + j2];
						}
					}
				}
			}

			int max = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (max < score[i][j])
						max = score[i][j];
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

}