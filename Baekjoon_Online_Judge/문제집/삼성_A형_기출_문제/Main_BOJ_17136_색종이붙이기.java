import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17136_색종이붙이기 { // 제출일 2019-10-17 10:57

//	static class Node {
//		boolean isCan1;
//		boolean isCan2;
//		boolean isCan3;
//		boolean isCan4;
//		boolean isCan5;
//		public Node() {
//			super();
//			this.isCan1 = false;
//			this.isCan2 = false;
//			this.isCan3 = false;
//			this.isCan4 = false;
//			this.isCan5 = false; 
//		}		
//	}
//	static void check(int i, int j) {
//		Node temp = node[i][j];
//		if(isCan1(i,j)) {
//			temp.isCan1 = true;
//			if(isCan2(i,j)) {
//				temp.isCan2 = true;
//				if(isCan3(i,j)) {
//					temp.isCan3 = true;
//					if(isCan4(i,j)) {
//						temp.isCan4 = true;
//						if(isCan5(i,j)) {
//							temp.isCan5 = true;							
//						}
//					}
//				}
//			}
//		}
//	}
	
	static int answer;
	static int N;
	static int[][] map;
	static boolean[][] visited;
//	static Node[][] node;
	static boolean isCan;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		
		// n*n (n<=5) 색종이 각 5장
		N = 10;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		node = new Node[N][N];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				check(i,j);
//			}
//		}
		answer = 26; // 5*5 +1
		visited = new boolean[N][N];
		isCan = false;
		dfs(0, 0, 0, 0, 0, 0, 0);
		if(isCan) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	private static void dfs(int i, int j, int cnt1, int cnt2, int cnt3, int cnt4, int cnt5) {
		// 기저조건
		//if(isCan) return;
		if(cnt1>5 || cnt2>5 || cnt3>5 || cnt4>5 || cnt5>5) return;
		if(i == N & j == 0) {
			int sum = cnt1+cnt2+cnt3+cnt4+cnt5;
			isCan = true;
			if(answer > sum) answer = sum;			
			return;
		}
		// 진행가능 확인
		if(isCan1(i,j)) {
			visit(i, j, 1);
			if (j + 1 < N)
				dfs(i, j + 1, cnt1 + 1, cnt2, cnt3, cnt4, cnt5);
			else
				dfs(i + 1, 0, cnt1 + 1, cnt2, cnt3, cnt4, cnt5);
			reverse(i, j, 1);
			//cnt1 -= 1;
			if (isCan2(i, j)) {
				visit(i, j, 2);
				if (j + 2 < N)
					dfs(i, j + 2, cnt1, cnt2 + 1, cnt3, cnt4, cnt5);
				else
					dfs(i + 1, 0, cnt1, cnt2 + 1, cnt3, cnt4, cnt5);
				reverse(i, j, 2);
				//cnt2 -= 1;
				if (isCan3(i, j)) {
					visit(i, j, 3);
					if (j + 3 < N)
						dfs(i, j + 3, cnt1, cnt2, cnt3 + 1, cnt4, cnt5);
					else
						dfs(i + 1, 0, cnt1, cnt2, cnt3 + 1, cnt4, cnt5);
					reverse(i, j, 3);
					//cnt3 -= 1;
					if (isCan4(i, j)) {
						visit(i, j, 4);
						if (j + 4 < N)
							dfs(i, j + 4, cnt1, cnt2, cnt3, cnt4 + 1, cnt5);
						else
							dfs(i + 1, 0, cnt1, cnt2, cnt3, cnt4 + 1, cnt5);
						reverse(i, j, 4);
						//cnt4 -= 1;
						if (isCan5(i, j)) {
//							if(cnt1==0 && cnt2==0 && i==0 && j ==0)
//								System.out.println("0,0");
//							if(cnt1==0 && cnt2==0 &&i==5 && j ==0)
//								System.out.println("5,0");
//							if(cnt1==0 && cnt2==0 &&i==5 && j ==5)
//								System.out.println("5,5");							
							visit(i, j, 5);
							if (j + 5 < N)
								dfs(i, j + 5, cnt1, cnt2, cnt3, cnt4, cnt5 + 1);
							else
								dfs(i + 1, 0, cnt1, cnt2, cnt3, cnt4, cnt5 + 1);
							reverse(i, j, 5);
							//cnt5 -= 1;
						}
					}
				}
			}		
		} else { // 1이 아니거나 visited 처리가 되어있다면
			if(j+1<N) dfs(i,j+1, cnt1, cnt2, cnt3, cnt4, cnt5);
			else dfs(i+1, 0, cnt1, cnt2, cnt3, cnt4, cnt5);
		}

	}

	private static void reverse(int i, int j, int action) {
		for (int dr = 0; dr < action; dr++) {
			for (int dc = 0; dc < action; dc++) {
				visited[i+dr][j+dc] = false;
			}
		}
	}
	private static void visit(int i, int j, int action) {
		for (int dr = 0; dr < action; dr++) {
			for (int dc = 0; dc < action; dc++) {
				visited[i+dr][j+dc] = true;
			}
		}
	}


	private static boolean isCan1(int i, int j) {
		if (!visited[i][j] && map[i][j] == 1)
			return true;
		return false;
	}

	private static boolean isCan2(int i, int j) {
		if (i + 1 < N && j + 1 < N	
		//&& isCan1(i,j)
		&& !visited[i+1][j] && map[i+1][j] == 1 
		&& !visited[i][j+1] && map[i][j+1] == 1 
		&& !visited[i+1][j+1] && map[i+1][j+1] == 1
		) return true;
		return false;
	}

	private static boolean isCan3(int i, int j) {
		if (i + 2 < N && j + 2 < N		
		//&& isCan2(i,j)
		&& !visited[i+2][j] && map[i+2][j] == 1 
		&& !visited[i+2][j+1] && map[i+2][j+1] == 1
		&& !visited[i+2][j+2] && map[i+2][j+2] == 1 
		&& !visited[i+1][j+2] && map[i+1][j+2] == 1
		&& !visited[i][j+2] && map[i][j+2] == 1
		) return true;
		return false;
	}

	private static boolean isCan4(int i, int j) {
		if (i + 3 < N && j + 3 < N		
		//&& isCan3(i,j)
		&& !visited[i+3][j] && map[i+3][j] == 1 
		&& !visited[i+3][j+1] && map[i+3][j+1] == 1 
		&& !visited[i+3][j+2] && map[i+3][j+2] == 1 
		&& !visited[i+3][j+3] && map[i+3][j+3] == 1 
		&& !visited[i+2][j+3] && map[i+2][j+3] == 1 
		&& !visited[i+1][j+3] && map[i+1][j+3] == 1 
		&& !visited[i][j+3] && map[i][j+3] == 1 
		) return true;
		return false;
	}

	private static boolean isCan5(int i, int j) {
		if (i + 4 < N && j + 4 < N		
		//&& isCan4(i,j)
		&& !visited[i+4][j] && map[i+4][j] == 1 
		&& !visited[i+4][j+1] && map[i+4][j+1] == 1 
		&& !visited[i+4][j+2] && map[i+4][j+2] == 1 
		&& !visited[i+4][j+3] && map[i+4][j+3] == 1 
		&& !visited[i+4][j+4] && map[i+4][j+4] == 1 
		&& !visited[i+3][j+4] && map[i+3][j+4] == 1 
		&& !visited[i+2][j+4] && map[i+2][j+4] == 1 
		&& !visited[i+1][j+4] && map[i+1][j+4] == 1 
		&& !visited[i][j+4] && map[i][j+4] == 1 		
		) return true;
		return false;
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
