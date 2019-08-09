import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 { // 제출일 2019-08-09 17:45

	public static Scanner sc = new Scanner(System.in);
	// public static StringBuilder sb = new StringBuilder();
	public static int Answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			Answer = 0;
			int N = Integer.parseInt(sc.nextLine());
			String[] tmp;
			int[][] map = new int[N][N];
			for (int row = 0; row < N; row++) {
				tmp = sc.nextLine().split("");
				for (int col = 0; col < N; col++) {
					map[row][col] = Integer.parseInt(tmp[col]);
				}
			}

			if (N == 1) {
				Answer = map[0][0];
				System.out.printf("#%d %d\n", t, Answer);
				continue;
			}

			for (int row = 0; row <= N / 2; row++) {
				for (int col = 0; col <= N / 2; col++) {
					if (row + col == N / 2) {
						int rowT = row;
						int colT = col;
						while (rowT + colT < N + N / 2) {
							Answer += map[rowT++][colT++];
						}
					} else if (row + col == N / 2 + 1) {
						int rowT = row;
						int colT = col;
						while (rowT + colT < N + N / 2) {
							Answer += map[rowT++][colT++];
						}
					}
				}
			}
			// sb.append("#").append(t).append(" ").append(Answer);
			System.out.printf("#%d %d\n", t, Answer);
		} // test case end
			// System.out.println(sb);
	}

}
