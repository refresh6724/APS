import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution_Level_3_퍼즐조각채우기 { // 제출일 2021-09-01 23:35

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 }, { 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } },
				new int[][] { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } })); // 14

		System.out.println(solution(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } }, new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 0, 0, 0 } })); // 0
	}

	static int n, blockCnt, spaceCnt, answer;
	static Map<String, Integer> blocks;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class BlockRange {
		int r1;
		int c1;
		int r2;
		int c2;

		public BlockRange() {
			r1 = 51;
			c1 = 51;
			r2 = -1;
			c2 = -1;
		}

		public void push(int r, int c) {
			r1 = Math.min(r1, r);
			r2 = Math.max(r2, r);
			c1 = Math.min(c1, c);
			c2 = Math.max(c2, c);
		}
	}

	public static int solution(int[][] game_board, int[][] table) {

		n = table.length;
		answer = 0;
		// 게임보드와 테이블을 같은 함수로 다루기 위해서 비교 대상인 블럭과 빈칸을 -1로 바꿉니다
		game_board = preprocess1(game_board);
		table = preprocess2(table);
		// 테이블에서 블록 찾기
		blockCnt = 0;
		table = paintBlockByBFS(table);
		// 블록 모양을 저장하기
		blocks = new HashMap<>();
		saveBlockShape(table);

		// 게임보드의 빈칸 체크
		blockCnt = 0;
		game_board = paintBlockByBFS(game_board);
		// 게임보드의 빈칸 모양을 확인하여 블럭 모양과 일치하는지 확인
		checkBlockShape(game_board);

		return answer;
	}

	private static int[][] preprocess1(int[][] game_board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (game_board[i][j] == 1) {
					game_board[i][j] = 0;
				} else {
					game_board[i][j] = -1;
				}
			}
		}
		return game_board;
	}

	private static int[][] preprocess2(int[][] table) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (table[i][j] == 1) {
					table[i][j] = -1;
				}
			}
		}
		return table;
	}

	private static int[][] paintBlockByBFS(int[][] table) {

		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && table[i][j] == -1) {
					visited[i][j] = true;
					table[i][j] = ++blockCnt;
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] now = q.poll();
						for (int k = 0; k < 4; k++) {
							int nr = now[0] + dr[k];
							int nc = now[1] + dc[k];
							if (nr < 0 || nc < 0 || nr == n || nc == n || visited[nr][nc] || table[nr][nc] == 0) {
								continue;
							}
							visited[nr][nc] = true;
							table[nr][nc] = blockCnt;
							q.add(new int[] { nr, nc });
						}
					}
				}
			}
		}
		return table;
	}

	private static void saveBlockShape(int[][] table) {

		BlockRange[] temp = new BlockRange[blockCnt + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new BlockRange();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (table[i][j] != 0) {
					temp[table[i][j]].push(i, j);
				}
			}
		}

		for (int b = 1; b <= blockCnt; b++) {
			BlockRange br = temp[b];
			StringBuilder sb = new StringBuilder();
			for (int i = br.r1; i <= br.r2; i++) {
				for (int j = br.c1; j <= br.c2; j++) {
					if (table[i][j] == b) {
						sb.append('b'); // block
					} else {
						sb.append('s'); // space
					}
				}
				sb.append('n'); // new line
			}
			// 해당 모양의 블럭 개수를 1개 더해준다
			blocks.put(sb.toString(), blocks.getOrDefault(sb.toString(), 0) + 1);
		}
	}

	private static void checkBlockShape(int[][] game_board) {
		BlockRange[] temp = new BlockRange[blockCnt + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new BlockRange();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (game_board[i][j] != 0) {
					temp[game_board[i][j]].push(i, j);
				}
			}
		}

		nextBlock: for (int b = 1; b <= blockCnt; b++) {
			BlockRange br = temp[b];
			int bCnt = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = br.r1; i <= br.r2; i++) {
				for (int j = br.c1; j <= br.c2; j++) {
					if (game_board[i][j] == b) {
						bCnt++;
						if (bCnt > 6) {
							continue nextBlock;
						}
						sb.append('b'); // block
					} else {
						sb.append('s'); // space
					}
				}
				sb.append('n'); // new line
			}

			String d0 = sb.toString();
			if (match(d0)) {
				answer += bCnt;
				continue;
			}
			String d90 = rotate(d0);
			if (match(d90)) {
				answer += bCnt;
				continue;
			}
			String d180 = rotate(d90);
			if (match(d180)) {
				answer += bCnt;
				continue;
			}
			String d270 = rotate(d180);
			if (match(d270)) {
				answer += bCnt;
				continue;
			}
		}
	}

	private static boolean match(String shape) {
		if (blocks.containsKey(shape) && blocks.get(shape) > 0) {
			blocks.put(shape, blocks.get(shape) - 1);
			return true;
		}
		return false;
	}

	private static String rotate(String shape) {
		// bsnbbn 과 같은 형태
		String[] line = shape.split("n");
		int row = line.length;
		int col = line[0].length();
		// bs
		// bb
		// nn
		char[][] newShape = new char[row][col];
		for (int i = 0; i < row; i++) {
			newShape[i] = line[i].toCharArray();
		}
		// sbnbbn 으로 바꾸어 리턴
		StringBuilder sb = new StringBuilder();
		for (int c = col - 1; c >= 0; c--) {
			for (int r = 0; r < row; r++) {
				sb.append(newShape[r][c]);
			}
			sb.append('n');
		}
		return sb.toString();
	}

}
