import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_2468_안전영역_BFS { // 제출일 2019-09-06 14:39
	
	static int answer;
	static int N;
	static int[][] map;
	static boolean[][] safe;
	static HashMap<Integer, Integer> height;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = 0;
		map = new int[N][N];
		safe = new boolean[N][N];
		int h = 0;
		height = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(!height.containsValue(map[i][j]))height.put(h++, map[i][j]);				
				if(map[i][j] > max) max = map[i][j];
				if(map[i][j] < min) min = map[i][j];
			}
		}
		
		if(min != max) {
			for (int i = 0; i < height.size(); i++) { // min 일때부터 잠기고 max일때 모두 잠긴다 
				calc(height.get(i));	
				System.gc();
			}
		}else {
			answer = 1;
		}
			
		System.out.println(answer);
	}

	static LinkedList<Node> q;
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static void calc(int rain) {
		for (int i = 0; i < N; i++) {			
			Arrays.fill(safe[i], false);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] <= rain) safe[i][j] = true;
			}
		}
		
		int row = 0;
		int col = 0;
		int nSafe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(safe[i][j] == false) {
					safe[i][j] = true;
					nSafe++;
					q=new LinkedList<Node>();
					q.add(new Node(i, j));
					while(!q.isEmpty()) {
						Node node = q.poll();
						row = node.r;
						col = node.c;
						
						if(row-1>=0 && !safe[row-1][col]) {
							safe[row-1][col] = true;
							q.add(new Node(row-1, col));
						}
						if(row+1<N && !safe[row+1][col]) {
							safe[row+1][col] = true;
							q.add(new Node(row+1, col));
						}
						if(col-1>=0 && !safe[row][col-1]) {
							safe[row][col-1] = true;
							q.add(new Node(row, col-1));
						}
						if(col+1<N && !safe[row][col+1]) {
							safe[row][col+1] = true;
							q.add(new Node(row, col+1));
						}
					}
				}
			}
		}
		
		if(nSafe > answer) answer = nSafe;
		
		
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
