import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Olympiad > 한국정보올림피아드 > KOI 2003 > 중등부 1번 
public class Main { // 제출일 2019-08-28 09:37

	static int N, M;
	static int answer;
	static int[] light;
	static int[] heavy;
	static boolean[][] map;
	static int mid;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		sc.init();
		N = sc.nextInt(); // 최대 99개
		M = sc.nextInt();
		mid = (N + 1) / 2;
		
		map = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			map[i][i] = true;
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
		}
		
		// 플로이드 워셜 응용
		// 중간 경로 체크
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = map[i][j] || map[i][k] && map[k][j];
				}
			}
		}
				
		answer = 0;
		light = new int[N + 1];
		heavy = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j]) {
					heavy[i]++;
					light[j]++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if(heavy[i]> mid || light[i]> mid) answer++;
		}

		bw.write(String.format("%d", answer));
		bw.flush();

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
