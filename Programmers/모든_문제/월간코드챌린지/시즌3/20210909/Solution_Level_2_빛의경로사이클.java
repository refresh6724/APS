import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_Level_2_빛의경로사이클 { // 제출일 2021-09-13 23:46

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "SL", "LR" })));
		// 16
		System.out.println(Arrays.toString(solution(new String[] { "S" })));
		// 1,1,1,1
		System.out.println(Arrays.toString(solution(new String[] { "R", "R" })));
		// 4,4
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	/**
	 * SLR로 이루어진 각 문자열의 길이 1 이상 500 이하 <br>
	 * Straight, Left, Right <br>
	 * 존재하는 모든 사이클 경로의 길이를 오름차순으로 정렬하여 리턴 <br>
	 * 
	 * @param grid 길이 1 이상 500 이하, 모든 문자열의 길이는 동일
	 * @return
	 */
	public static int[] solution(String[] grid) {
		int r = grid.length;
		int c = grid[0].length();
		char[][] map = new char[r][];
		for (int i = 0; i < r; i++) {
			map[i] = grid[i].toCharArray();
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean[][][] light = new boolean[r][c][4];
		int nr, nc, nk = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < 4; k++) {
					if (!light[i][j][k]) {
						int[] now = { i, j, k, 0 };
						while (!light[now[0]][now[1]][now[2]]) {
							light[now[0]][now[1]][now[2]] = true;
							if (map[now[0]][now[1]] == 'L') {
								nk = (now[2] - 1 + 4) % 4;
							} else if (map[now[0]][now[1]] == 'R') {
								nk = (now[2] + 1) % 4;
							} else {
								nk = now[2];
							}
							nr = now[0] + dr[nk];
							if (nr < 0) {
								nr += r;
							} else if (nr >= r) {
								nr -= r;
							}
							nc = now[1] + dc[nk];
							if (nc < 0) {
								nc += c;
							} else if (nc >= c) {
								nc -= c;
							}
							now = new int[] { nr, nc, nk, now[3] + 1 };
						}
						pq.add(now[3]);
					}
				}
			}
		}

		int[] ret = new int[pq.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = pq.poll();
		}
		return ret;

	}

}
