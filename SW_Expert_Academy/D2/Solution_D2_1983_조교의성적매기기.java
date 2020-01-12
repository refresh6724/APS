import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D2_1983_조교의성적매기기 { // 제출일 2020-01-12 05:43

	static String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			ArrayList<Integer> total = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				total.add(Integer.parseInt(st.nextToken()) * 35 + Integer.parseInt(st.nextToken()) * 45
						+ Integer.parseInt(st.nextToken()) * 20);
			}
			int answer = total.get(k - 1);
			Collections.sort(total);
			answer = Arrays.binarySearch(total.toArray(), answer);
			answer = answer / (n / 10);

			System.out.print("#" + test_case + " " + grade[answer]);
			System.out.println();
		}
	}

}