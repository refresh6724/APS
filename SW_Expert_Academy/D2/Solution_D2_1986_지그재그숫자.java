import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1986_지그재그숫자 { // 제출일 2020-01-14 23:48

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			// 홀수 합 - 짝수 합
			if(n%2 == 0) n = -(n+1)/2;
			else n = (n+1)/2;			
			
			System.out.println("#" + test_case + " " + n);
		}
	}

}