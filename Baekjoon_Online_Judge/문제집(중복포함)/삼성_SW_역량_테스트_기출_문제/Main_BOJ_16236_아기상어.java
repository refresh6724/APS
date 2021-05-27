import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Fish {
	int r;
	int c;
	int time; // 거리 최솟값

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public int getTime() {
		return time;
	}

	public Fish(int r, int c, int time) {
		super();
		this.r = r;
		this.c = c;
		this.time = time;
	}

}

class Shark {
	int r;
	int c;
	int size;
	int eat;

	public Shark(int r, int c) {
		super();
		this.r = r;
		this.c = c;
		this.size = 2;
		this.eat = 0;
	}

}

public class Main { // 제출일 2019-09-04 14:06
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N;
	static List<Fish> list;
	static int[][] input;
	static boolean[][] map;
	static Shark shark;

	public static void main(String[] args) throws Exception {
		sc.init();

		N = sc.nextInt();

		// 1. 자신의 크기보다 작은 물고기 중 가장 가까운 물고기를 타겟으로 정한다
		// 이 때 거리가 같다면 위가 우선, 왼쪽이 우선이다.
		// 거리는 최단 경로를 의미한다

		list = new ArrayList<Fish>();
		input = new int[N][N];
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
				if (input[i][j] != 9) {
					if (input[i][j] != 0) {
						// list.add(new Fish(i, j, input[i][j]));
						if (input[i][j] > 2)
							map[i][j] = true; // true가 벽, 갈 수 없음
					}
				} else {
					shark = new Shark(i, j);
					input[i][j] = 0;
				}
			}
		}

		path();
		// 1-1. 경로 계산
//			for (Fish fish : list) {
//				if (fish.size >= shark.size)
//					fish.time = Integer.MAX_VALUE;
//				else
//					path(fish);
//			}/	
		while (list.size() != 0) {
			list.sort(Comparator.comparing(Fish::getTime).thenComparing(Fish::getR).thenComparing(Fish::getC));
			Fish target = list.get(0);
			list.clear();
			answer += target.time;
			shark.r = target.r;
			shark.c = target.c;
			input[target.r][target.c] = 0;
			shark.eat++;
			if (shark.eat == shark.size) {
				shark.size++;
				shark.eat = 0;
			}
			// 맵 리셋
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (input[i][j] == 0 || input[i][j] <= shark.size) {
						map[i][j] = false; // true가 벽, 갈 수 없음
					}
				}
			}
			path();
		}

		bw.write(String.format("%d", answer));
		bw.flush();
	}

	private static void path() {
		// bfs
		int startRow = shark.r; // 출발 지점
		int startCol = shark.c;
		// int endRow = fish.r; // 도착 지점
		// int endCol = fish.c;
		// int time = 0; // 저장할 값
		int curDistance = 0; // while내부에서 사용할 거리변수
		int low = 0;
		boolean islow = false;

		LinkedList<Coord> queue = new LinkedList<Coord>();
		queue.add(new Coord(startRow, startCol, curDistance));
		while (!queue.isEmpty()) {
			Coord coord = (Coord) queue.poll();
			startRow = coord.row;
			startCol = coord.col;
			curDistance = coord.dist;

			// time = curDistance;
			if (map[startRow][startCol])
				continue;
			map[startRow][startCol] = true; // 벽으로 만들어 되돌아가지 못하게 만듬

			// 목적지
			if (input[startRow][startCol] != 0 && input[startRow][startCol] < shark.size) {
				if (islow && curDistance != low)
					break;
				// 물고기가 있고 상어 크기보다 작을 것
				list.add(new Fish(startRow, startCol, curDistance));
				low = curDistance;
				islow = true;
			}

			// 위로
			if (startRow - 1 >= 0 && !map[startRow - 1][startCol]) {
				queue.add(new Coord(startRow - 1, startCol, curDistance + 1));
			}
			// 아래로
			if (startRow + 1 < N && !map[startRow + 1][startCol]) {
				queue.add(new Coord(startRow + 1, startCol, curDistance + 1));
			}
			// 왼쪽으로
			if (startCol - 1 >= 0 && !map[startRow][startCol - 1]) {
				queue.add(new Coord(startRow, startCol - 1, curDistance + 1));
			}
			// 오른쪽으로
			if (startCol + 1 < N && !map[startRow][startCol + 1]) {
				queue.add(new Coord(startRow, startCol + 1, curDistance + 1));
			}
		}
		queue.clear();
//		fish.time = time;
	}

	static class Coord {
		int row;
		int col;
		int dist;

		public Coord(int row, int col, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
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