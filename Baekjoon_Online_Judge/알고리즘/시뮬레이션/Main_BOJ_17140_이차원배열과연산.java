import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 제출일 2020-01-08 17:50

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] map;
	static int[] count;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken()) -1;
		int c = Integer.parseInt(st.nextToken()) -1;
		int k = Integer.parseInt(st.nextToken());
		
		int time = 0;
		boolean find = false;
		int maxR = 3;
		int maxC = 3;
		int next = 0;
		
		map = new int[101][101];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[r][c] == k) {
			find = true;
			System.out.println(0);
		}
		
		while(!find && time < 100) {	
			
			if(maxR >= maxC) { // R 연산 
				for (int i = 0; i < maxR; i++) {
					q = new PriorityQueue<Node>();
					// 행 읽기
					count = new int[101];
					int col = 0;
					while(col < maxC) {
						count[map[i][col++]]++;
					}
					
					// 카운트 대기
					for (int j = 1; j < 101; j++) {
						if(count[j] != 0) q.add(new Node(j, count[j]));
					}
					
					// 행 초기화
					map[i] = new int[101];
					
					col = 0;
					while(!q.isEmpty() && col<100) {
						Node node = q.poll();
						map[i][col++] = node.num;
						map[i][col++] = node.count;
					}
					q.clear();
					
					if (i == 0) {
						next = col;
					} else if(col > next) {
						next = col;
					}						
				}
				maxC = next;
			} else { // C 연산				
				for (int i = 0; i < maxC; i++) {
					q = new PriorityQueue<Node>();
					// 열 읽기
					count = new int[101];
					int row = 0;
					while(row < maxR) {
						count[map[row++][i]]++;
					}
					
					// 카운트 대기
					for (int j = 1; j < 101; j++) {
						if(count[j] != 0) q.add(new Node(j, count[j]));
					}
					
					// 열 초기화
					for (int j = 0; j < 101; j++) {
						map[j][i] = 0;
					}
					
					row = 0;
					while(!q.isEmpty() && row<100) {
						Node node = q.poll();
						map[row++][i] = node.num;
						map[row++][i] = node.count;
					}
					q.clear();
					
					if (i == 0) {
						next = row;
					} else if(row > next) {
						next = row;
					}						
				}
				maxR = next;
			}
			
			time++;
			if(map[r][c] == k) {
				find = true;
				System.out.println(time);
			}
			
			// 디버그
			//debug();

			
			
		}		
		if(!find) {
			System.out.println(-1);
		}
	}

	private static void debug() {
		// TODO Auto-generated method stub
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
	}

	static PriorityQueue<Node> q;

	static class Node implements Comparable<Node>{
		int num;
		int count;

		public Node() {
			super();
		}	
		
		public Node(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}  
		
		@Override
		public int compareTo(Node node) {
			if(this.count > node.count) {
				return 1;
			} else if(this.count == node.count) {
				return this.num - node.num;
			} else {
				return -1;
			}
		}
	}
}
