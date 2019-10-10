import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-10-10 15:17
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	static int N;
	static int M;
	static int[][] input;
	static int[][] map;
	static int[][] adjMatrix;
	static int num;
	static int[] parents;
	static boolean isCan;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
//		int TC = sc.nextInt();
//		for (int tc = 1; tc <= TC; tc++) {
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		// 섬 번호 붙이기
		num = 1;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != 0 && map[i][j] == 0)
					numbering(i, j, num++);
			}
		}

		// 디버그) 번호 붙은 섬 출력

//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		num--;
		// 섬 간 간격 파악 및 인접 행렬 생성
		adjMatrix = new int[num][num];

		// 행렬 모두 최댓값으로 채우기
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				adjMatrix[i][j] = 111;
			}
		}

		measure();
		list = new LinkedList<Coord>();
		// 길이가 111이면 끊기
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(adjMatrix[i][j] == 111) adjMatrix[i][j] = 0;
				else list.add(new Coord(i, j, adjMatrix[i][j])); // i를 시작점 j를 도착점으로 하는 길이 l의 리스트 삽입
			}
		}

		// 디버그) 인접 행렬 출력
//		System.out.println();
//		for (int i = 0; i < num; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}

		answer = 0; // 백준은 Integer.max 쓰면 실패함
		path();
		System.out.println(answer);
	}

//	static LinkedList<Integer> list;
	static LinkedList<Coord> list;

	private static void path() {
		
		// bfs 풀이 틀림
/*
		private static void path(int start) {
		int length = 0;		
		visited = new boolean[num];
		list = new LinkedList<Integer>();
		visited[start] = true;
		list.add(start);
		while (!list.isEmpty()) {
			int i = list.poll();
			for (int j = 0; j < num; j++) {
				if (!visited[j] && adjMatrix[i][j] != 0) {
					visited[j] = true;
					length += adjMatrix[i][j];
					list.add(j);
				}
			}
		}		 

		if (length == 0)
			return;
		if (answer > length)
			answer = length;
*/
		// 크루스칼
		// 연결된 정점에 대해 모든 연결을 오름차순으로 정렬
		
		list.sort(Comparator.comparing(Coord::getLen));
		
		// 디버그		
		//System.out.println(list);
		
		parents = new int[num];
		Arrays.fill(parents, -1);		
		int listsize = list.size();
		for (int i = 0; i < listsize; i++) {
			Coord coord = list.poll(); 		
			if(union(coord.r, coord.c)) {
				answer += coord.len;
			}			
		}		
		int count1=0;
		for (int i = 0; i < num; i++) {
			if(parents[i] == -1) count1++;
			if(count1 > 1) { // 방문하지 못한 정점이 있다면 -1
				answer = -1;
				return;
			}
		}		
	}
	static int find(int a) {
		if(parents[a] < 0 ) return a;
		else return parents[a] = find(parents[a]);
	}	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;		
		return true;
	}	
	private static void measure() {
		int start = -1;
		int end = -1;
		int startIdx = -1;
		int endIdx = -1;
		for (int row = 0; row < N; row++) { // 각 행 측정
			for (int col = 0; col < M - 1; col++) {
				// 0에서 1이 되면 섬 시작
				// 1에서 0이 되면 섬 끝

				// 1 0 0 1 0 0 1
				// 1 0 0 2 0 0 3 기준
				if (input[row][col] == 1 && input[row][col + 1] == 0) {
					start = col;
					startIdx = map[row][start];
					for (int nextCol = col + 1; nextCol < M - 1; nextCol++) {
						if (input[row][nextCol] == 0 && input[row][nextCol + 1] == 1) {
							end = nextCol + 1;
							endIdx = map[row][end];
							// 기존 길이보다 짧으면 교체 단 1이면 바꾸지 않음
							int length = nextCol - col;
							if (startIdx != endIdx && length > 1) {
								if (adjMatrix[startIdx - 1][endIdx - 1] > length) {
									adjMatrix[startIdx - 1][endIdx - 1] = length;
									adjMatrix[endIdx - 1][startIdx - 1] = length;
								}
							}
							col = nextCol;
							break;
						}
					}
				}
			}
		}
		for (int col = 0; col < M; col++) { // 각 열 측정
			for (int row = 0; row < N - 1; row++) {
				// 0에서 1이 되면 섬 시작
				// 1에서 0이 되면 섬 끝

				// 1 0 0 1 0 0 1
				// 1 0 0 2 0 0 3 기준
				if (input[row][col] == 1 && input[row + 1][col] == 0) {
					start = row;
					startIdx = map[start][col];
					for (int nextRow = row + 1; nextRow < N - 1; nextRow++) {
						if (input[nextRow][col] == 0 && input[nextRow + 1][col] == 1) {
							end = nextRow + 1;
							endIdx = map[end][col];
							// 기존 길이보다 짧으면 교체 단 1이면 바꾸지 않음
							int length = nextRow - row;
							if (startIdx != endIdx && length > 1) {
								if (adjMatrix[startIdx - 1][endIdx - 1] > length) {
									adjMatrix[startIdx - 1][endIdx - 1] = length;
									adjMatrix[endIdx - 1][startIdx - 1] = length;
								}
							}
							row = nextRow;
							break;
						}
					}
				}
			}
		}
	}
	static class Coord {
		int r;
		int c;
		int len;		
		public int getLen() {
			return len;
		}
		public Coord(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Coord(int r, int c, int len) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
		}
		@Override
		public String toString() {
			return "Coord [start=" + r + ", end=" + c + ", len=" + len + "]";
		}
	}
	static LinkedList<Coord> q;
	private static void numbering(int i, int j, int k) {
		q = new LinkedList<Coord>();
		map[i][j] = k;
		q.add(new Coord(i, j));
		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			// 백준 테케에 모양제한이 풀려서 상하좌우 모두 가야한다
			// 직사각형 모양 제한이 붙어있으므로 아래와 오른쪽만 가도 OK
			if (r + 1 < N && input[r + 1][c] == 1 && map[r + 1][c] == 0) { // 아래
				map[r + 1][c] = k;
				q.add(new Coord(r + 1, c));
			}
			if (r - 1 >= 0 && input[r - 1][c] == 1 && map[r - 1][c] == 0) { // 상
				map[r - 1][c] = k;
				q.add(new Coord(r - 1, c));
			}
			if (c + 1 < M && input[r][c + 1] == 1 && map[r][c + 1] == 0) { // 오른쪽
				map[r][c + 1] = k;
				q.add(new Coord(r, c + 1));
			}
			if (c - 1 >= 0 && input[r][c - 1] == 1 && map[r][c - 1] == 0) { // 왼쪽
				map[r][c - 1] = k;
				q.add(new Coord(r, c - 1));
			}
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
			} catch (IOException e) {}
			return null;
		}
		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {}
			}
			return st.nextToken();
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
