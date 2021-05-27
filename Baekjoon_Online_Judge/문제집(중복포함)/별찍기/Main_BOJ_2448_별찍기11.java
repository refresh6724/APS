import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2448_별찍기11 { // 제출일 2020-02-21 22:10
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int row, col;

	public static void main(String[] args) throws IOException {
		row = Integer.parseInt(br.readLine().trim());
		col = (row << 1) - 1;
		map = new char[row][col];
		init();
		dfs(row, 0, row - 1);
		print();
	}

	private static void init() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = ' ';
			}
		}

	}

	private static void dfs(int n, int row, int col) {
		if (n == 3) {
			map[row++][col--] = '*';
			map[row][col + 2] = '*';
			map[row++][col--] = '*';
			map[row][col++] = '*';
			map[row][col++] = '*';
			map[row][col++] = '*';
			map[row][col++] = '*';
			map[row][col] = '*';
			return;
		}

		n >>= 1;

		dfs(n, row, col);
		dfs(n, row + n, col - n);
		dfs(n, row + n, col + n);

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i++) {
			sb.append(map[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}