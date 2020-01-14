import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1989_초심자의회문검사 { // 제출일 2020-01-15 04:00

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

			// st = new StringTokenizer(br.readLine(), " ");

			String line = br.readLine().trim();
			int len = line.length();
			int mid = 0;
			boolean palindrome = true;
			mid = len / 2;
			for (int i = 0; i < mid; i++) {
				if (line.charAt(i) != line.charAt(len - 1 - i))
					palindrome = false;
			}

			System.out.println("#" + test_case + " " + (palindrome ? 1 : 0));
		}
	}

}