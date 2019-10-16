import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1868_파핑파핑지뢰찾기 { // 제출일 2019-10-16 14:45
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N;
	static char[][] input;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			N = sc.nextInt();
			input = new char[N][N];
			for (int i = 0; i < N; i++) {
				input[i] = sc.readLine().toCharArray();
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = paintMap(i,j);
				}
			}
			
			//디버그
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			// 0을 만나면 0을 따라서 상하좌우 탐색
			bfs1();
			
			//디버그
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			
			// 0을 모두 돌았다면 -1이 아닌 숫자를 탐색
			bfs2();
			
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}

	}

	
	static class xy {
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static Queue<xy> list;

	private static void bfs1() {		
		visited = new boolean[N][N];		
		int r=0;
		int c=0;
		int nr = 0;
		int nc = 0;
		// 0을 만나면 bfs 시작 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					answer++; // 1회 클릭
					list = new LinkedList<xy>();
					visited[i][j] = true;
					list.add(new xy(i, j));
					while(!list.isEmpty()) {
						r = list.peek().x;
						c = list.poll().y;
						
						for (int k = 0; k < 8; k++) {
							nr = r + dr[k];
							nc = c + dc[k];
							if(nr>=0 && nr<N && nc>=0 && nc<N 
									&& !visited[nr][nc]
											&& map[nr][nc] != -1) {
								visited[nr][nc] = true;
								if(map[nr][nc] == 0) list.add(new xy(nr, nc));
							}
						}											
					}
				}
			}
		}
	}
	private static void bfs2() {
		// 0을 모두 돌았으므로 -1이 아닌 숫자의 개수를 찾아 answer에 더한다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] != -1) answer++;
			}
		}		
	}
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static int paintMap(int i, int j) {
		if(input[i][j] == '*') return -1;
		else {
			int count = 0;
			int nr = 0;
			int nc = 0;
			for (int k = 0; k < 8; k++) {
				nr = i+dr[k];
				nc = j+dc[k];
				if(nr>=0 && nr<N && nc>=0 && nc<N && input[nr][nc] == '*') count++;
			}
			return count;
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
