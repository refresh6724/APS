import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 { // 제출일 2020-01-06 22:33

	static int LEN = 9;
	static int[][] map;
	static boolean[] failCheck;
	static boolean check = true;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 스도쿠 검증

			map = new int[LEN][LEN];
			failCheck = new boolean[10];
			check = true;

			for (int i = 0; i < LEN; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < LEN; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					failCheck[map[i][j]] = check;
				}
				// 행 체크
				for (int j = 1; j <= LEN; j++) {
					if (!failCheck[j])
						check = false;
				}
				// 초기화
				failCheck = new boolean[10];
			}

			if (check) { // 열 체크
				for (int col = 0; col < LEN; col++) { // 열
					for (int row = 0; row < LEN; row++) {
						failCheck[map[row][col]] = check;
					}
					// 체크
					for (int j = 1; j <= LEN; j++) {
						if (!failCheck[j])
							check = false;
					}
					// 초기화
					failCheck = new boolean[10];
				}
			}

			// 구역 체크
			if (check && !EbyE(0, 0))
				check = false;
			if (check && !EbyE(0, 3))
				check = false;
			if (check && !EbyE(0, 6))
				check = false;
			if (check && !EbyE(3, 0))
				check = false;
			if (check && !EbyE(3, 3))
				check = false;
			if (check && !EbyE(3, 6))
				check = false;
			if (check && !EbyE(6, 0))
				check = false;
			if (check && !EbyE(6, 3))
				check = false;
			if (check && !EbyE(6, 6))
				check = false;

			System.out.printf("#%d %d\n", test_case, check ? 1 : 0);
		}
	}

	private static boolean EbyE(int row, int col) {
		failCheck = new boolean[10];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				failCheck[map[row + i][col + j]] = check;
			}
		}

		for (int j = 1; j <= LEN; j++) {
			if (!failCheck[j])
				return false;
		}
		// 구역 검증에 통과하면
		return true;
	}
}
