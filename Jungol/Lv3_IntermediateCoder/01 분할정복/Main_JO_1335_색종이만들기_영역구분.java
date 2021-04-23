import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1335_색종이만들기_영역구분 { // 제출일 2021-04-23 21:45

	static int n, white, blue;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	private static void go() {

		dfs(n, 0, 0);

	}

	private static void dfs(int len, int r, int c) {
		int color = map[r][c];
		if (len != 1) {
			int hf = len / 2;
			for (int i = r; i < r + len; i++) {
				for (int j = c; j < c + len; j++) {
					if (map[i][j] != color) {
						dfs(hf, r, c);
						dfs(hf, r + hf, c);
						dfs(hf, r, c + hf);
						dfs(hf, r + hf, c + hf);
						return;
					}
				}
			}
		}

		if (color == 0) {
			white++;
		} else {
			blue++;
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(white).append('\n').append(blue).append('\n');
		bw.write(sb.toString());
		bw.flush();
	}

}