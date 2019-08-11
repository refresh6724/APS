import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D0_1949_등산로조성 { // 제출일 2019-08-11 22:42
	
	static Scanner sc = new Scanner(System.in);
	static int T, N, K; // 테스트케이스, 맵크기, 공사가능
	static int[][] map = new int[8][8]; // N 최대 8
	static boolean[][] visit = new boolean[8][8]; // 경로확인
	static int ans = 0;
	static int[] dx = {0,0,-1,1};// 상하좌우 2차원 컨트롤
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {		
		
		T = sc.nextInt();		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			int M = 0;
			// 이차원 배열에 맵을 입력하면서 높이 최대값을 확인한다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] > M) M = map[i][j];
				}
			}			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == M) {
						// 각 위치에 대해  dfs를 실행한다
						dfs(i,j,1,false);
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,ans);
			ans = 0;
		}
	}
	
	static void dfs(int x, int y, int len, boolean flag) {
		
		// 현재 진행길이가 answer보다 길다면 갱신 후 탐색 재개 (탐색 후 자동 return)
		if(len>ans) ans = len;
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>= N || visit[nx][ny])
				continue;

			// 해당위치에서 각 방향이 존재한다면  && 각 방향이 낮다면 재귀적으로 dfs 호출
			if(map[x][y]>map[nx][ny])
				dfs(nx,ny,len+1,flag);
			// 각 방향이 존재하는데 && 공사로 통과할 수 있는 높이라면 && 공사 플래그 false
			else if(!flag && map[x][y]>map[nx][ny]-K) {
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] -1;
				dfs(nx, ny, len+1, true);
				map[nx][ny] = tmp;
			}
			
		}
		visit[x][y] = false; // 백트래킹
		
		
	}

}
