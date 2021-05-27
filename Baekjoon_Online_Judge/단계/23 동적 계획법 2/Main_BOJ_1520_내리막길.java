import java.util.Scanner;

public class Main { // 제출일 2019-09-30 18:33
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static long go(int[][] map, int[][] check, int x, int y) {
		if (x == map[0].length - 1 && y == map.length - 1) { // 도착지점이면
			check[y][x] = 1;
			return check[y][x];
		}
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx > -1 && nx < map[0].length && ny > -1 && ny < map.length && map[ny][nx] < map[y][x]) {
				if (check[ny][nx] > 0) {
					res = res + check[ny][nx];
				} else if (check[ny][nx] == -1) {

				} else {
					res += go(map, check, nx, ny); // 해당 지점까지 올 수 있는 경우의 수
				}
			}
		}
		if (res == 0) {
			check[y][x] = -1;
		} else {
			check[y][x] = res;
		}
		return res;
	}

	public static void main(String[] args) {
		int result = -1;
		Scanner sc = new Scanner(System.in);
		// 구현하세요.

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[][] check = new int[N][M];

		go(map, check, 0, 0);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(i + " : " + Arrays.toString(check[i]));
//		}

		result = check[0][0]; // 출발지점에서 도착지점까지 이어지는 경로의 수
		if (result == -1) // 경로가 이어지지 않으면
			result = 0;
		sc.close();

		System.out.println(result);
	}

}