import java.util.Scanner;

public class Solution_D0_2382_미생물격리 { // 제출일 2019-08-12 00:44
	static Scanner sc = new Scanner(System.in);
	static int T, n, m, k, ans;// 테스트케이스, 크기, 시간, 미생물개수
	static class Node {
		int dir; // 방향 상하좌우
		int num; // 미생물 수
		int cx;
		int cy;
	}
	static int[][][] map;
	static Node[] data;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0, 0,0,-1,1};
	static int[] conversion = {0,2,1,4,3}; // 상하좌우 반전
	
	public static void main(String[] args) {
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;			
			data = new Node[1001]; // 1번부터 사용
			
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			for (int i = 1; i <= k ; i++) {
				data[i] = new Node();
				data[i].cx = sc.nextInt();
				data[i].cy = sc.nextInt();
				data[i].num = sc.nextInt();
				data[i].dir = sc.nextInt();
			}
			
			while(m-- != 0) { // m 시간동안
				map = new int[100][100][2];
				for (int i = 1; i <= k ; i++) {
					Node move = data[i];
					
					// 미생물 수가 0이면 통과
					if(move.num == 0) continue;
					
					move.cx += dx[move.dir];
					move.cy += dy[move.dir];
					
					// 경계에 닿으면 방향을 반대로 바꾸고 미생물 수를 반으로 줄임
					if(move.cx == 0 || move.cx == n-1 || move.cy == 0 || move.cy == n-1 ) {
						move.dir = conversion[move.dir];
						move.num /= 2;
					}					
					if(map[move.cx][move.cy][0] != 0) {
						// 해당 좌표에 이미 존재하는 미생물의 번호를 받는다
						int idx = map[move.cx][move.cy][0];
						data[idx].num += move.num;
						if(map[move.cx][move.cy][1] < move.num) {
							// 그 좌표에 3개 이상의 미생물이 모일때를 대비해 max값 갱신을 기록해둔다
							map[move.cx][move.cy][1] = move.num;
							data[idx].dir = move.dir;
						}
						move.num = 0;
					} else {
						map[move.cx][move.cy][0] = i;
						map[move.cx][move.cy][1] = move.num;
					}
				}				
			}
			
			// 살아남은 미생물 수
			for (int i = 1; i <= k ; i++) ans += data[i].num;
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}
