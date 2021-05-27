import java.util.Scanner;

public class Main_BOJ_17070_파이프옮기기1 { // 제출일 2019-11-13 11:30 
	static int N; // 3이상 16이하
	static boolean[][] map; // 첫 두칸은 무조건 0
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt() == 0;
			}
		}

		// 입력 종료

		int r = 0;
		int c = 1;
		int pos = 0; // 가로 1 세로 2 대각
		answer = 0;
		dfs(r, c, pos);
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int pos) {
		if (r == N - 1 && c == N - 1) {
			answer++;
			return;
		}

		//
		int dr = r + 1;
		int dc = c + 1;
		if (pos == 2) {
			if (dr < N && dc < N && map[r][dc] && map[dr][c] && map[dr][dc]) {
				// 대각선 아래
				dfs(dr, dc, 2);
			} 
			if (dr < N && map[dr][c]) {
				dfs(dr, c, 1);
			}
			if (dc < N && map[r][dc]) {
				dfs(r, dc, 0);
			}
		} else if (pos == 1) {
			if (dr < N && dc < N && map[r][dc] && map[dr][c] && map[dr][dc]) {
				// 대각선 아래
				dfs(dr, dc, 2);
			} 
			if (dr < N && map[dr][c]) {
				dfs(dr, c, 1);
			}
		} else { // pos == 0 가로
			if (dr < N && dc < N && map[r][dc] && map[dr][c] && map[dr][dc]) {
				// 대각선 아래
				dfs(dr, dc, 2);
			}
			if (dc < N && map[r][dc]) {
				dfs(r, dc, 0);
			}
		}

	}

}
