import java.util.Arrays;

public class Solution_Level_2_행렬테두리회전하기 { // 제출일 2021-08-29 23:09

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } }))); // {8,10,25}
	}

	static int[][] map;

	public static int[] solution(int rows, int columns, int[][] queries) {
		map = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = num++;
			}
		}

		int[] ret = new int[queries.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = rotate(queries[i]);
		}
		return ret;
	}

	private static int rotate(int[] query) {

		int x1 = query[0] - 1;
		int y1 = query[1] - 1;
		int x2 = query[2] - 1;
		int y2 = query[3] - 1;

		// 원래 해당 자리의 수를 저장하고
		// 저장되어있는 수를 불러와 저장
		// 다음 칸으로 이동
		int save = map[x1 + 1][y1];
		int min = save;
		for (int i = y1; i < y2; i++) {
			int tmp = map[x1][i];
			map[x1][i] = save;
			save = tmp;
			min = Math.min(min, save);
		}
		for (int i = x1; i < x2; i++) {
			int tmp = map[i][y2];
			map[i][y2] = save;
			save = tmp;
			min = Math.min(min, save);
		}
		for (int i = y2; i > y1; i--) {
			int tmp = map[x2][i];
			map[x2][i] = save;
			save = tmp;
			min = Math.min(min, save);
		}
		for (int i = x2; i > x1; i--) {
			int tmp = map[i][y1];
			map[i][y1] = save;
			save = tmp;
			min = Math.min(min, save);
		}
		map[x1][y1] = save;
		return min;
	}
}
