import java.util.Scanner;

public class Main_BOJ_2447_별찍기10 { // 제출일 2020-02-16 01:57
	static char[][] map;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		init();
		dfs(n, 0, 0);
		print();
	}

	private static void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = ' ';
			}
		}

	}

	private static void dfs(int n, int row, int col) {
		if (n == 1) {
			map[row][col] = '*';
			return;
		}

		n /= 3;

		dfs(n, row, col);
		dfs(n, row, col + n);
		dfs(n, row, col + (n << 1));

		dfs(n, row + n, col);
		dfs(n, row + n, col + (n << 1));

		dfs(n, row + (n << 1), col);
		dfs(n, row + (n << 1), col + n);
		dfs(n, row + (n << 1), col + (n << 1));

	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(map[i]);
		}
	}
}