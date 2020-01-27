import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5603_Professional_건초더미 { // 제출일 2020-01-27 23:12

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T;
		T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			//
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			int answer = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(br.readLine());
				sum += num[i];
			}
			sum /= n;
			for (int i = 0; i < n; i++) {
				if(num[i] > sum)
					answer += num[i] - sum;
			}
			

			System.out.println("#"+test_case+" "+answer);
		}
	}

}