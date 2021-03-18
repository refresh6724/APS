import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1733_오목 { // 제출일 2021-03-18 22:42

	static int[][] board = new int[19][19];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 승리 판별
		// 검정 1 흰색 2 승부가 나지 않은 경우 0
		// 6목은 승부가 나지 않은 것
		// 바둑판 전체에 대해서 해당 돌
		// 좌상이 없다면 우하로 체크
		// 위가 없다면 아래로 체크
		// 우상이 없다면 좌하로 체크
		// 좌가 없다면 우로 체크

		// 오답 수정
		// 가장 왼쪽에 있는 것을 출력하므로 좌하가 없다면 우상으로 체크해야함

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (!go()) {
			sb.append(0);
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static boolean go() {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						if (makeFive(i, j, dir)) {
							sb.append(board[i][j]).append('\n');
							sb.append(i + 1).append(' ').append(j + 1);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean makeFive(int i, int j, int dir) {
		if (dir == 0) { // 좌->우
			// 0번돌이 존재할 때 1번돌이 0번돌과 같은 색이면 안된다
			if (j - 1 >= 0 && board[i][j - 1] == board[i][j]) {
				return false;
			}
			// 6번돌이 존재할 때 1번돌이 6번돌과 같은 색이면 안된다
			if (j + 5 < 19 && board[i][j] == board[i][j + 5]) {
				return false;
			}
			// 범위
			if (j + 5 > 19) {
				return false;
			}
			for (int k = 1; k < 5; k++) {
				if (board[i][j] != board[i][j + k]) {
					return false;
				}
			}
			return true;
		} else if (dir == 1) { // 좌상 -> 우하
			// 0번돌이 존재할 때 1번돌이 0번돌과 같은 색이면 안된다
			if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == board[i][j]) {
				return false;
			}
			// 6번돌이 존재할 때 1번돌이 6번돌과 같은 색이면 안된다
			if (i + 5 < 19 && j + 5 < 19 && board[i][j] == board[i + 5][j + 5]) {
				return false;
			}
			// 범위
			if (i + 5 > 19 || j + 5 > 19) {
				return false;
			}
			for (int k = 1; k < 5; k++) {
				if (board[i][j] != board[i + k][j + k]) {
					return false;
				}
			}
			return true;
		} else if (dir == 2) { // 상 -> 하
			// 0번돌이 존재할 때 1번돌이 0번돌과 같은 색이면 안된다
			if (i - 1 >= 0 && board[i - 1][j] == board[i][j]) {
				return false;
			}
			// 6번돌이 존재할 때 1번돌이 6번돌과 같은 색이면 안된다
			if (i + 5 < 19 && board[i][j] == board[i + 5][j]) {
				return false;
			}
			// 범위
			if (i + 5 > 19) {
				return false;
			}

			for (int k = 1; k < 5; k++) {
				if (board[i][j] != board[i + k][j]) {
					return false;
				}
			}
			return true;
		} else if (dir == 3) { // 우상 -> 좌하 ==> 좌하 -> 우상
			// 0번돌이 존재할 때 1번돌이 0번돌과 같은 색이면 안된다
			if (i + 1 < 19 && j - 1 >= 0 && board[i + 1][j - 1] == board[i][j]) {
				return false;
			}
			// 6번돌이 존재할 때 1번돌이 6번돌과 같은 색이면 안된다
			if (i - 5 >= 0 && j + 5 < 19 && board[i][j] == board[i - 5][j + 5]) {
				return false;
			}
			// 범위
			if (i - 5 < 0 || j + 5 > 19) {
				return false;
			}
			for (int k = 1; k < 5; k++) { // 우 상
				if (board[i][j] != board[i - k][j + k]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}