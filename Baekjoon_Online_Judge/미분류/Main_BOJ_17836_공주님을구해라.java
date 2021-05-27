import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17836_공주님을구해라 { // 제출일 2019-11-13 09:40

	static int N;
	static int M;
	static int T;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		
		//
		visited = new boolean[N][M];
		int t1 = bfs1();
		visited = new boolean[N][M];
		int t2 = bfs2();
		
		//System.out.println(t1);
		//System.out.println(t2);
		int answer = min(t1, t2);
		
		if(answer > T) System.out.println("Fail");
		else System.out.println(answer);
	}
	
	static class Pos {
		int r;
		int c;
		int time;
		public Pos() {
			// TODO Auto-generated constructor stub
		}
		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}

	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	private static int bfs1() {
		Queue<Pos> q = new LinkedList<Pos>();
		visited[0][0] = true;
		q.add(new Pos(0, 0, 0));
		Pos pos = null;
		boolean find = false;
		int nr = 0;
		int nc = 0;		
		while(!q.isEmpty()) {
			pos = q.poll();
			if(pos.time > T) continue;
			if(pos.r == N-1 && pos.c == M-1) {
				find = true;				
				break;
			}
			
			
			for (int i = 0; i < 4; i++) {
				nr = pos.r + dr[i];
				nc = pos.c + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc, pos.time+1));
				}
			}
			
		}
		if(find) return pos.time;
		else return (T<<1);
	}

	private static int bfs2() {
		Queue<Pos> q = new LinkedList<Pos>();
		visited[0][0] = true;
		q.add(new Pos(0, 0, 0));
		Pos pos = null;
		boolean find = false;
		int nr = 0;
		int nc = 0;	
		int time = 0;
		while(!q.isEmpty()) {
			pos = q.poll();
			if(pos.time > T) continue;
			if(map[pos.r][pos.c] == 2) {
				find = true;				
				break;
			}
			
			
			for (int i = 0; i < 4; i++) {
				nr = pos.r + dr[i];
				nc = pos.c + dc[i];
				time = pos.time;
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc, time+1));
				}
			}
			
		}
		if(find) return (pos.time + N - pos.r + M - pos.c - 2);
		else return (T<<1);
	}

	private static int min(int t1, int t2) {		
		return t1>t2?t2:t1;
	}

}
