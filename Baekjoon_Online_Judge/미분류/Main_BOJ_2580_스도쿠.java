import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BOJ_2580_스도쿠 { // 제출일 2020-12-13 23:47 21440 kb 300 ms

	static boolean find;
	static int[][] map;
	static boolean[][] garo, sero, sect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(2 * j) - '0';
			}
		}
		garo = new boolean[10][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				garo[i][map[i][j]] = true;
			}
		}
		sero = new boolean[10][10];
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				sero[j][map[i][j]] = true;
			}
		}
		sect = new boolean[10][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int s = (i / 3) * 3 + (j / 3) + 1;
				sect[s][map[i][j]] = true;
			}
		}

		go(0, 0);
		br.close();
	}

	private static void go(int row, int col) throws IOException {
		if (find) {
			return;
		}
		if (col == 9) {
			go(row + 1, 0);
			return;
		}
		if (row == 9) {
			print();
			find = true;
			return;
		}
		if (map[row][col] != 0) {
			go(row, col + 1);
			return;
		} else {
			int s = (row / 3) * 3 + (col / 3) + 1;
			for (int next = 1; next < 10; next++) {
				if (find) {
					return;
				}
				if (!garo[row][next] && !sero[col][next] && !sect[s][next]) {
					map[row][col] = next;
					garo[row][next] = true;
					sero[col][next] = true;
					sect[s][next] = true;
					go(row, col + 1);
					map[row][col] = 0;
					garo[row][next] = false;
					sero[col][next] = false;
					sect[s][next] = false;
				}
			}
		}
	}

	private static void print() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			sb.append(map[i][0]);
			for (int j = 1; j < 9; j++) {
				sb.append(' ').append(map[i][j]);
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
