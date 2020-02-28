import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_10997_별찍기22 { // 제출일 2020-02-28 20:55

	public static void main(String[] args) throws IOException {
		SeparateClass stc = new SeparateClass();
		stc.solution();
	}
}

class SeparateClass {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n, m, sr, sc;
	char[][] map;

	public void solution() throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println("*");
			return;
		}

		init();

		go(n, sr, sc);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < (n << 2) - 3; i++) {
			sb.append('*');
		}
		sb.append("\n").append("*");

		for (int i = 2; i < (n << 2) - 1; i++) {
			sb.append("\n").append(map[i]);
		}

		System.out.print(sb.toString());
	}

	private void init() {
		sr = n << 1;
		sc = sr - 2;
		m = n << 2;
		map = new char[m - 1][m - 3];
		for (int i = 0; i < m - 1; i++) {
			Arrays.fill(map[i], ' ');
		}
	}

	private void go(int n, int sr, int sc) {

		// 시작지점
		map[sr][sc] = '*';
		// 위로 두칸 우로 두칸
		map[sr - 1][sc] = map[sr - 2][sc] = map[sr - 2][sc + 1] = map[sr - 2][sc + 2] = '*';

		down(n - 1, sr - 2, sc + 2, 4);

	}

	private void down(int n, int sr, int sc, int len) {

		for (int i = 0; i < len; i++) {
			map[++sr][sc] = '*';
		}

		left(n, sr, sc, len);

	}

	private void left(int n, int sr, int sc, int len) {

		for (int i = 0; i < len; i++) {
			map[sr][--sc] = '*';
		}

		up(n, sr, sc, len + 2);
	}

	private void up(int n, int sr, int sc, int len) {

		for (int i = 0; i < len; i++) {
			map[--sr][sc] = '*';
		}

		right(n, sr, sc, len);
	}

	private void right(int n, int sr, int sc, int len) {

		if (n == 1) {

			for (int i = 0; i < len - 2; i++) {
				map[sr][++sc] = '*';
			}
			return;
		}

		for (int i = 0; i < len; i++) {
			map[sr][++sc] = '*';
		}

		down(n - 1, sr, sc, len + 2);

	}
}