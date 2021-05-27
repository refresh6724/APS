import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs 시간초과
// bfs 메모리초과
// visited * jump

// 
public class Main_BOJ_1600_말이되고픈원숭이 { // 제출일 2019-11-13 16:48
	static int K; // 30이하
	static int W; // 200이하
	static int H; // 200이하
	static int[][] map;
	static boolean[][][] visited;
	static int answer;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		// 입력 종료 
		
		visited = new boolean[H][W][K+1];
		answer = W*H;
//		visited[0][0] = true;
//		dfs(0, 0, 0, 0);
		
		for (int i = 0; i < K; i++) {			
			visited[H-1][W-1][i] = true;
		}
		bfs(H-1, W-1);
		
		if(answer == W*H) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}
	
	static class Pos {
		int r;
		int c; 
		int jump;
		int move;
		public Pos(int r, int c, int jump, int move) {
			super();
			this.r = r;
			this.c = c;
			this.jump = jump;
			this.move = move;
		}
		
	}
	
	private static void bfs(int sr, int sc) {
		int jump = 0;
		int move = 0;
		int r =0;
		int c =0;
		int nr=0;
		int nc=0;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(sr, sc, jump, move));		
		Pos pos = null;
		while(!q.isEmpty()) {
			pos = q.poll();
			r = pos.r;
			c = pos.c;
			jump = pos.jump;
			move = pos.move;
			
			if(r == 0 && c == 0) {
				answer = move;
				return;
			}
			
			if(jump<K) {
				for (int i = 0; i < 8; i++) {
					nr = r + jr[i];
					nc = c + jc[i];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 1 && !visited[nr][nc][jump+1]) {
						visited[nr][nc][jump+1] = true;
						q.add(new Pos(nr, nc, jump+1, move+1));
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 1 && !visited[nr][nc][jump]) {
					visited[nr][nc][jump] = true;
					q.add(new Pos(nr, nc, jump, move+1));
				}
			}
		}
		
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int[] jr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] jc = {-1, 1, -2, 2, -2, 2, -1, 1};
		
//	private static void dfs(int r, int c, int jump, int move) {
//		if(r==W-1 && c == H-1) { // 도착
//			if(answer > move) answer = move;
//			return;
//		}		
//		int nr = 0;
//		int nc = 0;
//		
//		// 점프할 수 있다면 점프하거나 하지 않거나		
//		if(jump<K) {
//			for (int i = 0; i < 8; i++) {
//				nr = r + jr[i];
//				nc = c + jc[i];
//				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 1 && !visited[nr][nc]) {
////					visited[nr][nc] = true;
//					dfs(nr, nc, jump+1, move+1);
////					visited[nr][nc] = false;
//				}
//			}
//		}
//		
//		for (int i = 0; i < 4; i++) {
//			nr = r + dr[i];
//			nc = c + dc[i];
//			if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 1 && !visited[nr][nc]) {
////				visited[nr][nc] = true;
//				dfs(nr, nc, jump, move+1);
////				visited[nr][nc] = false;
//			}
//		}
//		
//	}

}
