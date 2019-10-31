import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
	
	static int answer;
	static int N; // 정점의 개수
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		N = sc.nextInt();
		answer = 100 * N * N;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) map[i][j] = answer;				
			}
		}
		// 입력 종료
		
		// 전형적인 TSP 문제
		// 백트래킹
		// 1번에서 출발 ~ 1번으로 돌아오기 
		visited = new boolean[N];
		int num=0;
		int sum=0;
		int cnt=0;
		visited[0] = true;
		go(num, cnt, sum);
		
		System.out.println(answer);
	}

	private static void go(int num, int cnt, int sum) {
		if(answer < sum) return;
		if(cnt == N-1) {
			sum += map[num][0];
			if(answer>sum) answer = sum;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				go(i, cnt+1, sum+map[num][i]);
				visited[i] = false;				
			}			
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
