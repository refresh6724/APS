import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-09-26 09:50
	static int answer;
	static int N;
	static boolean[][] connect;

	static int[] p;
	static boolean[] group;
	static boolean[][] group1;
	static boolean[][] group2;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
//		int TC = sc.nextInt();
//		for (int tc = 1; tc <= TC; tc++) {
		// 1번 a그룹 b그룹 선거인원수 최소 차이 계산
		answer = 100000;
		// 마을 수
		N = sc.nextInt();
		// 사람 수
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}

		// 각 마을 연결시 true
		connect = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			connect[i][i] = true;
		}

		// 1번 마을부터 연결되는 수 + 연결 되는 마을 * 수
		for (int i = 0; i < N; i++) {
			int loof = sc.nextInt();
			for (int j = 0; j < loof; j++) {
				int next = sc.nextInt()-1;
				connect[i][next] = true;
				connect[next][i] = true;
			}
		}
		
		//디버그 
//		for (int row = 0; row < N; row++) {
//			System.out.println(Arrays.toString(connect[row]));			
//		}

		group = new boolean[N];
		// 양 그룹 나누기
		dfs(0);

//			bw.write(String.format("#%d %d\n", tc, answer));
		if(answer == 100000)
			System.out.println(-1);
		else System.out.println(answer);
//		}

	}

	private static void dfs(int cnt) {
		if (answer == 0)
			return;
		if (cnt == N) {
			// 모든 마을이 같은 그룹이라면 계산하지 않는다
			for (int i = 1; i < N; i++) {
				if (group[0] != group[i]) {
					connectProve();
					return;
				}
			}
			return;
		}

		dfs(cnt + 1);
		group[cnt] = true;
		dfs(cnt + 1);
		group[cnt] = false;

	}

	private static void connectProve() {
		// 연결 검증
		// false 그룹
		group1 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!group[i] && !group[j])
					group1[i][j] = connect[i][j];
			}
		}

		// floyd : k를 경유하는 i->j, k,i,j는 모두 false 그룹원이어야 한다

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					group1[i][j] = group1[i][j] || (group1[i][k] && group1[k][j]);
				}
			}
		}

		// 이 과정이 끝나면 모든 false 그룹원은 연결되어있어야 한다.
		// 만약 연결되어있지 않다면 그룹이 끊겨 있는 것이다.
		for (int i = 0; i < N; i++) {
			if (group[i])
				continue;
			for (int j = 0; j < N; j++) {
				if (group[j])
					continue;
				if (!group1[i][j])
					return;
			}
		}

		// true 그룹
		group2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (group[i] && group[j])
					group2[i][j] = connect[i][j];
			}
		}
		// floyd : k를 경유하는 i->j, k,i,j는 모두 true 그룹원이어야 한다

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					group2[i][j] = group2[i][j] || (group2[i][k] && group2[k][j]);
				}
			}
		}

		// 이 과정이 끝나면 모든 true 그룹원은 연결되어있어야 한다.
		// 만약 연결되어있지 않다면 그룹이 끊겨 있는 것이다.
		for (int i = 0; i < N; i++) {
			if (!group[i])
				continue;
			for (int j = 0; j < N; j++) {
				if (!group[j])
					continue;
				if (!group2[i][j])
					return;
			}
		}

		calc();
	}

	private static void calc() {
		int a = 0;
		int b = 0;

		for (int i = 0; i < N; i++) {
			if (group[i])
				a += p[i];
			else
				b += p[i];
		}

		answer = Integer.min(answer, Math.abs(a - b));
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
