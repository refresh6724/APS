import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_JO_1082_화염에서탈출 { // 제출일 2019-11-08 17:48

	static final int inf = 25000;
	static int answer;
	static int R;
	static int C;
	static Queue<int[]> q;
	static char[][] map;
	static int[][] water;
	static boolean[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int SR = 0;
		int SC = 0;
		q = new LinkedList<int[]>();
		map = new char[R][C];
		water = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] line = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if (line[j] == '.') {
					map[i][j] = line[j];
				} else if (line[j] == 'S') {
					map[i][j] = '.';
					SR = i;
					SC = j;
				} else if (line[j] == '*') {
					map[i][j] = line[j];
					water[i][j] = 1;
					q.add(new int[] { i, j, 2 });
				} else if (line[j] == 'D') {
					map[i][j] = line[j];
					water[i][j] = inf;
				} else { // X
					map[i][j] = line[j];
					water[i][j] = -1;
				}
			}
		}
		// 입력 종료

		// 물이 채워지는 시간에 따른 지도
		bfs();

//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(water[i]));
//		}

		answer = inf;
		q = new LinkedList<int[]>();
		visited[SR][SC] = true;
		q.add(new int[] { SR, SC, 1 });
		run();
		System.out.println(answer == inf ? "impossible" : answer - 1);

	}

	private static void run() {
		int r = 0;
		int c = 0;
		int nr = 0;
		int nc = 0;
		int time = 0;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			r = pos[0];
			c = pos[1];
			time = pos[2];
			if (map[r][c] == 'D') {
				answer = time;
				return;
			}
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]
						&& (water[nr][nc] == 0 || water[nr][nc] > time + 1)) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, time + 1 });
				}
			}
		}
	}

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		int r = 0;
		int c = 0;
		int nr = 0;
		int nc = 0;
		int time = 0;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			r = pos[0];
			c = pos[1];
			time = pos[2];
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && water[nr][nc] == 0) {
					water[nr][nc] = time;
					q.add(new int[] { nr, nc, time + 1 });
				}
			}
		}
	}

}
