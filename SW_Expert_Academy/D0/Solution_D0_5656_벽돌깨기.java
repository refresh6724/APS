import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D0_5656_벽돌깨기 { // 제출일 2019-11-13 15:13

	static int N;
	static int W;
	static int H;
	static int answer;
	static int[][] map;
	static int[][] deliver;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} 
			} 
			// 입력 종료
			
			int fire = 0;
			int target = 0;			
			answer = H*W;
			for (target = 0; target < W; target++) {
				int[][] del = new int[H][W];
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						del[i][j] = map[i][j];
					}
				}
				dfs(fire, target, del);
			}
			
			System.out.println(String.format("#%d %d", t, answer));
		}

	}

	static class Pos {
		int r;
		int c;
		int len;
		public Pos(int r, int c, int len) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
		}
		
	}
	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void dfs(int fire, int target, int[][] del) {
		if(fire == N) {
			// 남은 벽돌의 개수
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(del[i][j] != 0) count++;
				}
			}
						
			if(count < answer) {
				answer = count;
				
//				System.out.println();
//				System.out.println(fire);
//				for (int i = 0; i < H; i++) {
//					for (int j = 0; j < W; j++) {
//						System.out.printf("%d ", del[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println(count);
//				System.out.println();
				
				
			}
			return;
		}
		
		int targetRow = -1;
		for (int i = 0; i < H; i++) {
			if(del[i][target] != 0) {
				targetRow = i;
				break;
			}
		}
		if(targetRow == -1) {
			dfs(N, 0, del);
			return; // 해당 열에 남은 벽돌이 없다면 더 진행하지 않는다
		}
		
		// 벽돌 깨기
		boolean[][] visited = new boolean[H][W];
		Queue<Pos> q = new LinkedList<Pos>();
		visited[targetRow][target] = true;
		q.add(new Pos(targetRow, target, del[targetRow][target]));
		Pos pos = null;
		int r = 0;
		int c = 0;
		int len = 0;
		int nr = 0;
		int nc = 0;
		
		while(!q.isEmpty()) {
			pos = q.poll();
			r= pos.r;
			c= pos.c;
			len = pos.len;
			del[r][c] = 0;
			if(len--> 1) {				
				for (int i = 1; i <= len; i++) {
					for (int j = 0; j < 4; j++) {
						nr = r+dr[j]*i;
						nc = c+dc[j]*i;
						if(nr>=0 && nr<H && nc>=0 && nc<W && del[nr][nc] != 0 &&!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Pos(nr, nc, del[nr][nc]));
						}
					}
				}
			}
		}
		
		// 재정렬
		for (int col = 0; col < W; col++) {
			Queue<Integer> qq = new LinkedList<Integer>();
			for (int row = H-1; row >=0 ; row--) {
				if(del[row][col]>0) {
					qq.add(del[row][col]);
					del[row][col] = 0;
				}
			}
			len = qq.size();
			for (int row = 1; row <= len; row++) {
				del[H-row][col] = qq.poll();
			}
		}
		
//		System.out.println();
//		System.out.println(fire);
//		for (int i = 0; i < W; i++) {
//			for (int j = 0; j < H; j++) {
//				System.out.printf("%d ", del[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println();
		
		// 다음 벽돌
		for (target = 0; target < W; target++) {
			int[][] next = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					next[i][j] = del[i][j];
				}
			}
			dfs(fire+1, target, next);
		}
		
	}

}
