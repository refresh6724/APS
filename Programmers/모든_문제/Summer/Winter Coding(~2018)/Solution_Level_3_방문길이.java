public class Solution_Level_3_방문길이 { // 제출일 2020-09-30 21:54

	// test
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU")); // 7
		System.out.println(solution("LULLLLLLU")); // 7
	}

	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static int solution(String dirs) {

		// 11*11 판에서 중복 없는 이동거리
		// 각 위치에서 4방향, 단 a->b b->a 둘은 같다

		boolean[][][] map = new boolean[11][11][4];
		int idx, dir, rev, ans;
		idx = dir = rev = ans = 0;
		int r, c, nr, nc;
		r = c = nr = nc = 5;

		while (idx != dirs.length()) {
			switch (dirs.charAt(idx)) {
			case 'U':
				nr = r + dr[UP];
				nc = c + dc[UP];
				dir = UP;
				rev = DOWN;
				break;
			case 'D':
				nr = r + dr[DOWN];
				nc = c + dc[DOWN];
				dir = DOWN;
				rev = UP;
				break;
			case 'L':
				nr = r + dr[LEFT];
				nc = c + dc[LEFT];
				dir = LEFT;
				rev = RIGHT;
				break;
			case 'R':
				nr = r + dr[RIGHT];
				nc = c + dc[RIGHT];
				dir = RIGHT;
				rev = LEFT;
				break;
			}
			idx++;
			if (nr < 0 || nc < 0 || nr == 11 || nc == 11) {
				continue;
			}
			if(!map[r][c][dir]) {
				map[r][c][dir] = true;
				map[nr][nc][rev] = true;
				ans++;
			}
			r = nr;
			c = nc;
		}
		return ans;
	}
}