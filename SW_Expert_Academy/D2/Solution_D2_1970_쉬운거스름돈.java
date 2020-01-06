import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1970_쉬운거스름돈 { // 제출일 2020-01-06 21:51
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// N 을 5만부터 10까지 돈의 단위로 나눈 숫자를 출력 
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());			
			
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] output = new int[8];
			
			for (int i = 0; i < 8; i++) {
				output[i] = n/money[i];
				n %= money[i];
			}			
			
			System.out.printf("#%d\n", test_case);
			for (int i = 0; i < 8; i++) {
				System.out.printf("%d ", output[i]);
			}
			System.out.println();
		}
	}
}
