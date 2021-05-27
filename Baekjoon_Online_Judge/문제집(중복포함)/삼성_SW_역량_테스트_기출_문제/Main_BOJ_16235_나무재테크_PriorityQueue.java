import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// 200MB 1100ms
public class Main_BOJ_16235_나무재테크 { // 제출일 2019-10-17 13:32
	
	static int answer;
	static int[][] map;
	static class Tree implements Comparable<Tree>{
		int r;
		int c;
		int age;
		public Tree() {
			super();
		}
		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}		
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
		@Override
		public String toString() {
			return "Tree [위치 : " + r + ", " + c + ", age=" + age + "]";
		}
		
		
	}
	static PriorityQueue<Tree> pq;
	static Queue<Tree> dead;
	static LinkedList<Tree> alive;
	static int N; // 땅의 크기 10이하
	static int M; // 주어지는 나무의 수 100이하
	static int K; // 돌려야 하는 시간 1000이하 
	static int[][] A; // 매년 겨울 주어지는 양분 100 이하, 즉 각 땅에서 키울 수 있는 나무 나이의 합은 양분을 포함해 150 이하로 조절된다.
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		// r과 c는 1부터 시작한다		
		map = new int[N][N]; // 영양분을 저장할 땅
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5); // 가장 처음 주어지는 양분 5
		}
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
	
		int r=0;
		int c=0;
		int a=0;
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			r = sc.nextInt()-1;
			c = sc.nextInt()-1;
			a = sc.nextInt();
			pq.add(new Tree(r, c, a));
		}		
		while(--K != -1) {
			dead = new LinkedList<>();
			alive = new LinkedList<>();
			Tree tree = null;
			//spring
			while(!pq.isEmpty()) {
				tree = pq.poll();
				if(tree.age <= map[tree.r][tree.c]) {
					map[tree.r][tree.c] -= tree.age++;
					alive.add(tree);
				} else {
					dead.add(tree);
				}
			}
			//summer
			while(!dead.isEmpty()) {
				tree = dead.poll();
				map[tree.r][tree.c] += tree.age/2;
			}			
			//fall
			while(!alive.isEmpty()) {
				tree = alive.poll();
				if(tree.age%5==0) {
					r = tree.r;
					c = tree.c;
					int nr = 0;
					int nc = 0;
					for (int i = 0; i < 8; i++) {
						nr = r + dr[i];
						nc = c + dc[i];
						if(nr>=0 && nc>=0 && nr<N && nc<N) {
							pq.add(new Tree(nr, nc, 1));
						}								
					}					
				}
				pq.add(tree);
			}
			//디버그
			//printMap();
			//winter
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += A[i][j];					
				}
			}
			//printMap();
			//pq.forEach((value)-> {System.out.println(value);});
		}
		answer = pq.size();
		System.out.println(answer);
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
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
