import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10993_별찍기18 { // 제출일 2020-02-26 00:29
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static char[][] map;
	static int height, width, top, bottom, axis;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		init();
		if (n % 2 == 0) {
			dfs(n, axis, 0); // 꼭지점부터 위로 올라가면서 체크
		} else {
			dfs(n, 0, axis); // 꼭지점부터 아래로 내려가면서 체크
		}
		print3();
	}

	private static void init() {
		height = (1 << n) - 1;
		width = (1 << (n + 1)) - 3;
		top = 0; // 꼭지점
		bottom = 0; // 밑변
		axis = height - 1;
		map = new char[height][width];
		for (int i = 0; i < height; i++) {
			Arrays.fill(map[i], ' ');
		}
	}

	private static void dfs(int n, int top, int bottom) {
		if (n == 0)
			return;

		map[top][axis] = 0x2A;

		int step = (1 << n) - 2;
		int width = (1 << (n + 1)) - 3;

		if (top > bottom) { // 역삼각형
			for (int change = 1; change <= step; change++) {
				map[top - change][axis - change] = 0x2A;
				map[top - change][axis + change] = 0x2A;
			}
			int row = top - step;
			int col = axis - step;
			for (int j = 0; j < width; j++) {
				map[row][col + j] = 0x2A;
			}
			dfs(n - 1, bottom + 1, (top + bottom) / 2);

		} else if (top < bottom) { // 정삼각형
			for (int change = 1; change <= step; change++) {
				map[top + change][axis - change] = 0x2A;
				map[top + change][axis + change] = 0x2A;
			}
			int row = top + step;
			int col = axis - step;
			for (int j = 0; j < width; j++) {
				map[row][col + j] = 0x2A;
			}
			dfs(n - 1, bottom - 1, (top + bottom) / 2);
		}

	}

	private static void print3() {

		StringBuilder sb = new StringBuilder();
		int col = 0;
		if (n % 2 == 0) {
			col = width;
			for (int i = 0; i < height; i++) {
				sb.append(new String(map[i], 0, col--)).append("\n");

			}
		} else {
			col = width / 2 + 1;
			for (int i = 0; i < height; i++) {
				sb.append(new String(map[i], 0, col++)).append("\n");

			}
		}

		System.out.println(sb.toString());
	}
}