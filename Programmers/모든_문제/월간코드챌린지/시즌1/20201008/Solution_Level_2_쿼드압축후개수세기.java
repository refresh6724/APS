import java.util.Arrays;

public class Solution_Level_2_쿼드압축후개수세기 { // 제출일 2020-10-20 19:50

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } }))); // [4,9]
		System.out.println(Arrays.toString(
				solution(new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } }))); // [10,15]
	}

	static int zero, one;

	public static int[] solution(int[][] arr) {
		// 쿼드 트리로 압축할 경우 남은 0과 1의 개수를 리턴
		// 행 길이는 최대 1024
		// 현재 범위 전체 압축이 가능한가 ? => 가능 => 숫자 하나를 리턴
		// => 불가능 => 범위를 넷으로 나눠 dfs, 범위가 1이라면 해당 수를 리턴
		int n = arr[0].length;
		zero = 0;
		one = 0;
		dfs(arr, 0, 0, n);
		return new int[] { zero, one };
	}

	private static void dfs(int[][] arr, int row, int col, int n) {

		int num = arr[row][col];

		if (n == 1) {
			if (num == 1) {
				one++;
			} else {
				zero++;
			}
			return;
		}

		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (num != arr[i][j]) {
					n /= 2;
					dfs(arr, row, col, n);
					dfs(arr, row + n, col, n);
					dfs(arr, row, col + n, n);
					dfs(arr, row + n, col + n, n);
					return;
				}
			}
		}

		if (num == 1) {
			one++;
		} else {
			zero++;
		}
		return;
	}

}