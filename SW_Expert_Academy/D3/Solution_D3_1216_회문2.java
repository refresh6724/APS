import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_1216_회문2 { // 제출일 2020-06-04 01:00 24,572 kb 132 ms
	
	static int max;
	static char[][] map = new char[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 10개의 테케가 주어진다고 문제에 명시
			sb.append('#').append(tc).append(' ');
			max = 1;
			// 입력
			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int lmin = 0;
			int rmin = 0;
			// 가로
			for (int row = 0; row < 100; row++) {
				for (int start = 0; start < 100; start++) {
					// 홀수개 체크
					lmin = start - ((max - 1) >> 1);
					rmin = start + ((max - 1) >> 1);
					if (lmin < 0 || rmin > 99 || map[row][lmin] != map[row][rmin]) {
						continue;
					}
					s1(row, start - 1, start + 1, 1);
				}
				for (int start = 0; start < 99; start++) {
					// 짝수개 체크
					lmin = start - ((max - 1) >> 1);
					rmin = start + ((max - 1) >> 1) + 1;
					if (lmin < 0 || rmin > 99 || map[row][lmin] != map[row][rmin]) {
						continue;
					}
					if (map[row][start] == map[row][start + 1]) {
						s1(row, start - 1, start + 2, 2);
					}
				}
			}

			// 세로
			for (int col = 0; col < 100; col++) {
				for (int start = 0; start < 100; start++) {
					// 홀수개 체크
					lmin = start - ((max - 1) >> 1);
					rmin = start + ((max - 1) >> 1);
					if (lmin < 0 || rmin > 99 || map[lmin][col] != map[rmin][col]) {
						continue;
					}
					s2(col, start - 1, start + 1, 1);
				}
				for (int start = 0; start < 99; start++) {
					// 짝수개 체크
					lmin = start - ((max - 1) >> 1);
					rmin = start + ((max - 1) >> 1) + 1;
					if (lmin < 0 || rmin > 99 || map[lmin][col] != map[rmin][col]) {
						continue;
					}
					if (map[start][col] == map[start + 1][col]) {
						s2(col, start - 1, start + 2, 2);
					}
				}
			}

			sb.append(max).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void s1(int row, int left, int right, int len) {
		if (left < 0 || right == 100) {
			if (max < len) {
				max = len;
			}
			return;
		}
		if (map[row][left] == map[row][right]) {
			s1(row, left - 1, right + 1, len + 2);
		} else {
			if (max < len) {
				max = len;
			}
			return;
		}
	}

	private static void s2(int col, int up, int down, int len) {
		if (up < 0 || down == 100) {
			if (max < len) {
				max = len;
			}
			return;
		}
		if (map[up][col] == map[down][col]) {
			s2(col, up - 1, down + 1, len + 2);
		} else {
			if (max < len) {
				max = len;
			}
			return;
		}
	}

}
