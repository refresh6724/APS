import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1926_간단한369게임 { // 제출일 2020-01-25 23:11

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//		int T;
//		T = Integer.parseInt(st.nextToken());

//		for (int test_case = 1; test_case <= T; test_case++) {
		//

//			st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= k; i++) {
			// 1부터 순서대로 해당 수에 3,6,9가 포함되어있는지 확인하고 그 숫자개수만큼 -를 출력한다.
			// 없으면 그 숫자 그대로 출력
			char[] number = Integer.toString(i).toCharArray();
			int len = number.length;
			int hyphen = 0;
			for (int j = 0; j < len; j++) {
				switch (number[j]) {
				case '3':
					hyphen++;
					break;
				case '6':
					hyphen++;
					break;
				case '9':
					hyphen++;
					break;
				}
			}
			if (hyphen > 0) {
				for (int j = 0; j < hyphen; j++) {
					sb.append("-");
				}
			} else {
				sb.append(i);
			}
			sb.append(" ");

		}

		System.out.println(sb.toString());
	}
//	}

}