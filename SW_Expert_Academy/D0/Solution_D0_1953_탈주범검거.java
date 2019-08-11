import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D0_1953_탈주범검거 { // 제출일 2019-08-11 23:54

	static Scanner sc = new Scanner(System.in);
	// start, next
	static int T, n, m, sx, sy, len, x, y, nx, ny, cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0}; //{0,0,-1,1};// 상하좌우 2차원 컨트롤
	static int[] dy = {0,0,1,-1}; //{-1,1,0,0};// 우좌하상 
	static Queue<Node> q= null;
	
	static class Node {
		int x;
		int y;
		int time;
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			map = new int[50][50];
			visit = new boolean[50][50];
			q = new LinkedList<Node>();
			n =sc.nextInt();
			m =sc.nextInt();
			sx =sc.nextInt();
			sy =sc.nextInt();
			len =sc.nextInt(); // 소요시간
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();					
				}
			}		
			
			bfs(sx,sy);
			
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j]) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
		
	}
	
	static void bfs(int x, int y) {	
		q.add(new Node(x,y,1));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			//current
			int cx = q.peek().x;
			int cy = q.peek().y;
			int ctime = q.peek().time;
			q.poll();
			
			if(ctime == len) continue;
			for (int i = 0; i < 4; i++) {
	            nx = cx + dx[i];
	            ny = cy + dy[i];
	            if (nx >= 0 && ny >= 0 && nx < n&&ny < m) {
	                // i : 우좌하상   상하좌우 반대로
	                // 1 : 상하좌우
	                // 2 : 상하
	                // 3 : 좌우
	                // 4 : 상우
	                // 5 : 우하
	                // 6 : 좌하
	                // 7 : 좌상
	                if (!visit[nx][ny]) {
	                    if (map[cx][cy] == 2) { // 상하일때
	                        if (i == 2 || i == 3) continue; //하 상 이면 다음
	                    }
	                    else if (map[cx][cy] == 3) { // 좌우일때
	                        if (i == 0 || i == 1) continue; //우 좌 면 다음
	                    }
	                    else if (map[cx][cy] == 4) { // 상우일때
	                        if (i == 0 || i == 3) continue; //우 상 이면 다음
	                    }
	                    else if (map[cx][cy] == 5) {
	                        if (i == 1 || i == 3) continue;
	                    }
	                    else if (map[cx][cy] == 6) {
	                        if (i == 1 || i == 2) continue;
	                    }
	                    else if (map[cx][cy] == 7) {
	                        if (i == 0 || i == 2) continue;
	                    }
	 
	                    if (i == 0) { // 우
	                        if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
	                            q.add(new Node(nx, ny, ctime + 1));
	                            visit[nx][ny] = true;
	                        }
	                    }
	                    else if (i == 1) { // 좌
	                        if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
	                            q.add(new Node(nx, ny, ctime + 1));
	                            visit[nx][ny] = true;
	                        }
	                    }
	                    else if (i == 2) { // 하
	                        if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
	                            q.add(new Node(nx, ny, ctime + 1));
	                            visit[nx][ny] = true;
	                        }
	                    }
	                    else { // 상
	                        if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
	                            q.add(new Node(nx, ny, ctime + 1));
	                            visit[nx][ny] = true;
	                        }
	                    }
	                }
	            }
	        }
			
			
		}
		
	}
}
