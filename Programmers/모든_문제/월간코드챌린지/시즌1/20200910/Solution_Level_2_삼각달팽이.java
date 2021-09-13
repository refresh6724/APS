import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_Level_2_삼각달팽이 { // 제출일 2020-09-19 23:28

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4))); // [1,2,9,3,10,8,4,5,6,7]
		System.out.println(Arrays.toString(solution(5))); // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
		System.out.println(Arrays.toString(solution(6))); // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
	}

	static final int DOWN = 0;
	static final int RIGHT = 1;
	static final int UP = 2;

	static int[] dr = { 1, 0, -1 };
	static int[] dc = { 0, 1, -1 };

	public static int[] solution(int n) {

		// n은 1000 이하
		int[][] arr = new int[n][n]; //
		// 4 byte * 1000 * 1000 = 4MB

		int num = 1;
		int max = n * (n + 1) / 2;
		int dir = 0;
		int r = 0;
		int c = 0;
		int nr = 0;
		int nc = 0;
		while (num <= max) {
			
			arr[r][c] = num++;
			
			nr = r + dr[dir];
			nc = c + dc[dir];
			if (nr < 0 || nc < 0 || nr == n || nc == n || arr[nr][nc] != 0) {
				dir += 1;
				dir %= 3;
				nr = r + dr[dir];
				nc = c + dc[dir];				
			}
			
			r = nr;
			c = nc;
		}

		int[] ret = new int[max];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				ret[idx++] = arr[i][j];
			}
		}
		return ret;
	}

}