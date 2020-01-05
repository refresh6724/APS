import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_D2_1966_숫자를정렬하자 { // 제출일 2020-01-05 22:54
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// N 길이의 숫자를 오름차순 정렬 출력
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] input = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(input);
			
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < n; i++) {
				System.out.printf("%d ", input[i]);
			}
			System.out.println();
		}
	}
}
