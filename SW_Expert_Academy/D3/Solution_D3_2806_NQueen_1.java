import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_2806_NQueen_1 { // 제출일 2019-08-22 08:59
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static boolean map[][];
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map = new boolean[N][N];
			answer = 0;
			dfsQueen(0);
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
	}

	private static void dfsQueen(int startrow) {
		if (startrow == N) {
			answer++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if (isOK(startrow, c) == false) {
				continue;
			} else {
				map[startrow][c] = true;
				dfsQueen(startrow + 1);
				map[startrow][c] = false;
			}
		}
	}

	private static boolean isOK(int row, int col) {

		for (int i = 0; i < N; i++) {
			if (map[row][i] == true || map[i][col]) {
				return false;
			}
		}
		int a = row, b = col;
		while (true) {
			if (a - 1 >= 0 && b - 1 >= 0) {
				if (map[--a][--b] == true)
					return false;
			} else
				break;
		}
		a = row;
		b = col;
		while (true) {
			if (a - 1 >= 0 && b + 1 < N) {
				if (map[--a][++b] == true)
					return false;
			} else
				break;
		}
		return true;
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();

		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
