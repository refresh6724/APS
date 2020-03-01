import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Solution_D3_2814_최장경로 { // 제출일 2020-03-01 22:39
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int M;
	static boolean[][] map;
	static int max;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
				map[b][a] = true;
			}
			
			max = 0;
			
			for (int start = 1; start <= N; start++) {
				dfs(start, 0 | (1<<start), 1);
			}			

			sb.append("#").append(tc).append(" ").append(max).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void dfs(int here, int bitmask, int len) {
		if(max < len) max = len;
		
		for (int next = 1; next <= N; next++) {
			if((map[here][next]) && ((bitmask & (1<<next)) == 0)) {
				dfs(next, bitmask | (1<<next), len+1);
			}
		}
		
	}

}
