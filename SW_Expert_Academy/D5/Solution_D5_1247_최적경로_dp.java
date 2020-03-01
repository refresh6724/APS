import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 { // 제출일 2020-03-01 15:25 // 30,544 kb 120ms // bitmasking 

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N;
	static int[][] coord;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			coord = new int[N + 2][2];
			dp = new int[N + 2][1 << N + 2];
			for (int i = 0; i < N + 2; i++) {
				Arrays.fill(dp[i], -1);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				coord[i][0] = Integer.parseInt(st.nextToken());
				coord[i][1] = Integer.parseInt(st.nextToken());
			}
			int answer = Integer.MAX_VALUE;
			for (int i = 2; i < N + 2; i++) { // 첫번째로 가는 고객의 좌표가 바뀔 때마다 정답을 갱신
				answer = Math.min(answer, distance(0, i) + findMinDistance(i, 1 << i));
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int findMinDistance(int node, int visited) {
		if (visited == (1 << N + 2) - 1 - 3) { // 마지막 집일 경우
			return distance(node, 1); 
		}
		if (dp[node][visited] != -1)
			return dp[node][visited];
		int ret = Integer.MAX_VALUE;
		for (int next = 2; next < N + 2; next++) {
			if ((visited & 1 << next) == 0) { // next번째 bit를 사용중이면(방문했다면) 1이므로 false
				ret = Math.min(ret, distance(node, next) + findMinDistance(next, visited | 1 << next));
			}
		}
		return dp[node][visited] = ret;
	}

	private static int distance(int from, int to) {
		return Math.abs(coord[to][0] - coord[from][0]) + Math.abs(coord[to][1] - coord[from][1]);
	}

}
