import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_4534_트리흑백색칠 { // 제출일 2020-03-09 09:00
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static final int MOD = 1000000007; // 10억 7
	static final int ROOT = 0;
	static final int NODE = 1;
	static final int LEAF = 1;
	static final int WHITE = 0;
	static final int BLACK = 1;

	static int[][] dp;
	static ArrayList<Integer>[] edges = null;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			// 1. 정점 Vertex의 수
			int N = Integer.parseInt(br.readLine());
			// 2. white와 black에 대한 경우의 수 저장
			dp = new int[2][N + 1];
			Arrays.fill(dp[WHITE], -1);
			Arrays.fill(dp[BLACK], -1);
			// 3. 간선 정보 저장을 위한 리스트
			edges = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				edges[i] = new ArrayList<>();
			}
			// 4. 간선 정보 입력
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			// 5. 1을 root로 하여 계산 시작
			int ans = (dp(ROOT, NODE, WHITE) + dp(ROOT, NODE, BLACK)) % MOD;

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static int dp(int parent, int node, int color) {

		// 현재 노드가 부모 이외의 노드와 연결점이 있다면 자식 노드가 있는 것이고
		// 현재 노드가 부모 이외의 노드가 없다면 현재 노드는 리프 노드이다.
		// 따라서 현재 노드의 간선 사이즈가 1이면 리프 노드이다.
		if (parent != ROOT && edges[node].size() == LEAF) {
			return 1;
		}

		// dp 적인 문제의 특성을 고려하여 같은 계산을 반복하는 경우를 체크한다
		if (dp[color][node] != -1) {
			return dp[color][node];
		}
		// 저장된 값이 없을 경우 계산한다
		long children = 1;
		for (int i = 0; i < edges[node].size(); i++) {
			int branch = edges[node].get(i);
			if (branch != parent) {

				long child = dp(node, branch, WHITE);

				if (color == WHITE) {
					child += dp(node, branch, BLACK);
					child %= MOD;
				}

				children *= child;
				children %= MOD;
			}
		}

		dp[color][node] = (int) children;
		return (int) children;
	}
}
