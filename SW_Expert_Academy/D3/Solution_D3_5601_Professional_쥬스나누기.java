import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5601_Professional_쥬스나누기 { // 제출일 2020-01-27 23:31

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T;
		T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			//
			int n = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			for (int i = 0; i < n; i++) {
				sb.append(" ").append("1/").append(n);
			}

			System.out.println(sb.toString());
		}
	}

}