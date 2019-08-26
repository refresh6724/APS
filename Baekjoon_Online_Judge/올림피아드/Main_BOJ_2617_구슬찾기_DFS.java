import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Olympiad > 한국정보올림피아드 > KOI 2003 > 중등부 1번 
public class Main { // 제출일 2019-08-26 10:37

	static int N, M, H, L;
	static int answer;
	static int[] light;
	static int[] heavy;
	static boolean[][] hmap;
	static boolean[][] lmap;
	static boolean[] visited;
	static int mid;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		sc.init();
		N = sc.nextInt();
		M = sc.nextInt();
		H = 0;
		L = 0;
		answer = 0;
		light = new int[N + 1];
		heavy = new int[N + 1];
		hmap = new boolean[N + 1][N + 1];
		lmap = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			H = sc.nextInt();
			L = sc.nextInt();
			hmap[L][H] = lmap[H][L] = true;
		}
		mid = (N + 1) / 2;
		for (int i = 1; i <= N; i++) {
			hdfs(i, i);
			Arrays.fill(visited, false);
			ldfs(i, i);
			Arrays.fill(visited, false);
		}
		answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += light[i] >= mid ? 1 : 0;
			answer += heavy[i] >= mid ? 1 : 0;
		}

		bw.write(String.format("%d", answer));
		bw.flush();

	}

	private static void ldfs(int parentNode, int startNode) {
		visited[startNode] = true;
		for (int i = 1; i <= N; i++) {
			if(lmap[startNode][i] && !visited[i]) {
				light[parentNode]++;
				ldfs(parentNode, i);
			}
		}
		
	}

	private static void hdfs(int parentNode, int startNode) {
		visited[startNode] = true;
		for (int i = 1; i <= N; i++) {
			if(hmap[startNode][i] && !visited[i]) {
				heavy[parentNode]++;
				hdfs(parentNode, i);
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
			} catch (Exception e) {

			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
