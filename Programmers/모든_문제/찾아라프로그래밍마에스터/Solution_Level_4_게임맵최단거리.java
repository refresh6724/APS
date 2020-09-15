import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_3_게임맵최단거리 { // 제출일 2020-09-14 23:19

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } })); // 11
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } })); // 11
	}

	public static int solution(int[][] maps) {

		int n = maps.length;
		int m = maps[0].length;	
		
		// 캐릭터는 0,0 도착 위치 n-1, m-1
		// 최단거리 구하기
		boolean[][] visited = new boolean[n][m];
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(0,0,1);
		int r, c, nr, nc;
		q.add(node);
		while(!q.isEmpty()) {
			node = q.poll();
			r = node.row;
			c = node.col;
			if(!visited[r][c]) {
				visited[r][c] = true;
				if(r == n-1 && c == m-1) {
					return node.len;
				}				
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if(nr >= 0 && nc >= 0 && nr < n && nc < m && maps[nr][nc] == 1) {
						q.add(new Node(nr, nc, node.len+1));
					}
				}				
			}			
		}
		return -1;	
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Node {
		int row;
		int col;
		int len;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int row, int col, int len) {
			super();
			this.row = row;
			this.col = col;
			this.len = len;
		}	
		
	}

}