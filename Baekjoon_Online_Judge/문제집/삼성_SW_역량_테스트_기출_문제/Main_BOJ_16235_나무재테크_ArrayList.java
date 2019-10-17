import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 20MB 600ms
public class Main_BOJ_16235_나무재테크 { // 제출일 2019-10-17 18:34
	
	static int answer;	
	static int N; // 땅의 크기 10이하
	static int M; // 주어지는 나무의 수 100이하
	static int K; // 돌려야 하는 시간 1000이하 
	static int[][] A; // 매년 겨울 주어지는 양분 100 이하, 즉 각 땅에서 키울 수 있는 나무 나이의 합은 양분을 포함해 150 이하로 조절된다.
	static int[][] map; // 영양분을 저장할 땅
	static ArrayList<Integer>[][] Map; // 각 좌표에 나무를 저장할 배열 리스트
	static int[][] fall; // 매년 번식할 나무의 개수
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();		
		A = new int[N][N];
		map = new int[N][N]; 
		Map = new ArrayList[N][N];
		fall = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
				map[i][j] = 5; // 가장 처음 주어지는 양분 5			
				Map[i][j] = new ArrayList<Integer>();
			}
		}

		// r과 c는 1부터 시작한다
		int r=0 , c=0 ,age=0;
		for (int i = 0; i < M; i++) {
			r = sc.nextInt()-1;
			c = sc.nextInt()-1;
			age = sc.nextInt();
			Map[r][c].add(age);
		}		
		ArrayList<Integer> Trees = null;
		int treeIdx = 0;
		int tree = 0;
		int dead = 0;
		while(K-->0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//spring
					Trees = Map[i][j];
					treeIdx = Trees.size(); // 해당 위치에 있는 나무 개수
					dead = 0;
					fall[i][j] = 0;
					while(treeIdx-->0) {
						tree = Trees.get(treeIdx);
						if(tree > map[i][j]) { // 영양분 체크
							dead += tree/2;
							Map[i][j].remove(treeIdx);
						} else {
							map[i][j] -= tree++;
							Map[i][j].set(treeIdx, tree);
							if(tree % 5 == 0) fall[i][j]++;
						}
					}
					//summer and winter
					map[i][j] += A[i][j] + dead;
				}
			}
						
			//fall
			int nr = 0;
			int nc = 0;
			for (int sr = 0; sr < N; sr++) {
				for (int sc = 0; sc < N; sc++) {
					for (int k = 0; k < 8; k++) {
						nr = sr + dr[k];
						nc = sc + dc[k];
						if(nr>=0 && nc>=0 && nr<N && nc<N) {
							for (int falls = fall[sr][sc]; falls > 0 ; falls--) {
								Map[nr][nc].add(1);
							}
						}								
					}	
				}
			}	
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += Map[i][j].size();					
			}
		}		
		System.out.println(answer);
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
	}
}
