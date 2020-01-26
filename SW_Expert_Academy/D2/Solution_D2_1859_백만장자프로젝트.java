import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 { // 제출일 2020-01-25

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T;
		T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			//
			int n = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}
			long answer = 0;
			int max = 0;
			for (int i = n-1; i >= 0 ; i--) {
				if(m[i] > max) {
					max = m[i];
				}
				else {
					answer += max-m[i];
				}
			}			

			System.out.println("#"+test_case+" "+answer);
		}
	}

}