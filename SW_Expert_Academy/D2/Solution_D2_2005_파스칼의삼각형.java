import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2005_파스칼의삼각형 { // 제출일 2020-01-23 23:21

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

//			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(br.readLine().trim());
			int[] print = new int[n];
			print[0] = 1;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				// 1
				for (int j = 0; j <= i; j++) {
					sb.append(print[j]).append(" ");
				}
				sb.append("\n");
				for (int j = n-1; j >= 1; j--) {
					print[j] += print[j-1];
				}
			}


			System.out.println("#" + test_case);
			System.out.print(sb.toString());
		}
	}

}