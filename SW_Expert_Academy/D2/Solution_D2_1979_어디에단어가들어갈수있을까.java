import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1979_어디에단어가들어갈수있을까 { // 제출일 2020-01-12 23:17

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 0이 불가능 1이 가능

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()) + 2;
			int k = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			for (int i = 1; i < n-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < n-1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;
			int[][] count = new int[n][n];
			// 행 계산
			for (int row = 1; row < n; row++) {
				for (int col = 1; col < n; col++) {
					count[row][col] = (count[row][col - 1] + map[row][col]) * map[row][col];
					if (count[row][col] == k && map[row][col + 1] != 1)
						answer++;
				}
			}
			
			// 열 계산
			for (int row = 1; row < n; row++) {
				for (int col = 1; col < n; col++) {
					count[row][col] = (count[row-1][col] + map[row][col]) * map[row][col];
					if (count[row][col] == k && map[row+1][col] != 1)
						answer++;
				}
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
