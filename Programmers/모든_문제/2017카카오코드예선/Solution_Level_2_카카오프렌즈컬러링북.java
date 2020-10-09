import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_2_카카오프렌즈컬러링북 { // 제출일 2020-10-09 21:47

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(6, 4, new int[][] { 
					{ 1, 1, 1, 0 }, 
					{ 1, 2, 2, 0 }, 
					{ 1, 0, 0, 1 }, 
					{ 0, 0, 0, 1 }, 
					{ 0, 0, 0, 3 }, 
					{ 0, 0, 0, 3 } }))); // [4,5]
	}
	
	static boolean[][] visited;
	static int area, size;

	public static int[] solution(int m, int n, int[][] picture) {

		visited = new boolean[m][n];
		area = 0;
		size = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(picture[i][j] != 0 && !visited[i][j]) {					
					bfs(m,n,picture,i,j);
					area++;
				}
			}
		}
		
		return new int[] {area, size};
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void bfs(int m, int n, int[][] picture, int i, int j) {
		
		int s = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i,j,picture[i][j]));
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(!visited[node.row][node.col]) {
				visited[node.row][node.col] = true;			
				s++;
				int nr = 0;
				int nc = 0;
				for (int k = 0; k < 4; k++) {
					nr = node.row + dr[k];
					nc = node.col + dc[k];
					if(nr >= 0 && nc >= 0 && nr < m && nc < n 
							&& picture[nr][nc] == node.color
							&& !visited[nr][nc]) {
						q.add(new Node(nr,nc,node.color));
					}
				}			
			}
		}
		size = Math.max(size, s);
	}

	static class Node {
		int row;
		int col;
		int color;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int row, int col, int color) {
			super();
			this.row = row;
			this.col = col;
			this.color = color;
		}	
	}
}