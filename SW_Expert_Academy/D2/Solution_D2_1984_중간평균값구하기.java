import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1984_중간평균값구하기 { // 제출일 2020-01-14 23:10

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

			st = new StringTokenizer(br.readLine(), " ");
			int max = 0;
			int min = 10001;
			double sum = 0;
			int tmp = 0;
			
			for (int i = 0; i < 10; i++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp>max) max = tmp;
				if(tmp<min) min = tmp;
				sum += tmp;
			}
			sum -= min;
			sum -= max;
			
			System.out.println("#" + test_case + " " + Math.round(sum/8));
		}
	}

}