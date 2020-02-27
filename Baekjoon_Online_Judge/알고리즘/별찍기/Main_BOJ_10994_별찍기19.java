import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10994_별찍기19 { // 제출일 2020-02-27 21:11
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int m;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		// 1 => 1,1
		// 2 => 5,5
		// 3 => 9,9
		// 4 => 13,13
		// n => 4n-3
		m = (n<<2)-3;

		init();
		dfs(n, 0, m);
		print();
	}

	private static void init() {

		map = new char[m][m];
		for (int i = 0; i < m; i++) {
			Arrays.fill(map[i], ' ');
		}
	}

	private static void dfs(int n, int pos, int len) {
		if (n == 1) {
			map[pos][pos] = '*';
			return;
		}

		// 사각형 모양으로 체크
		// 위 아래 두줄
		for (int i = pos + 1; i < pos + len - 1; i++) {
			map[pos][i] = '*';
			map[pos + len - 1][i] = '*';
		}
		// 양 옆 두줄
		for (int i = pos; i < pos + len; i++) {
			map[i][pos] = '*';
			map[i][pos + len - 1] = '*';
		}

		// 다음
		dfs(n - 1, pos + 2, len - 4);

	}

	private static void print() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			sb.append(map[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}