import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_4534_트리흑백색칠 { // 제출일 2020-03-02 14:05
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static final int MOD = 1000000007; // 10억 7
	static final int WHITE = 0;
	static final int BLACK = 1;
	
	static int N;
	static int[] dp_white;
	static int[] dp_black;
	static ArrayList<Integer>[] edges = null;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			// 1. 정점 Vertex의 수
			N = Integer.parseInt(br.readLine());
			// 2. white와 black에 대한 경우의 수 저장
			dp_white = new int[N + 1];
			dp_black = new int[N + 1];
			Arrays.fill(dp_white, -1);
			Arrays.fill(dp_black, -1);
			// 3. 간선 정보 저장을 위한 리스트
			edges = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				edges[i] = new ArrayList<>();
			}
			// 4. 간선 정보 입력
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			// 5. 1을 root로 하여 계산 시작

			int parent = 0;
			int node = 1;

			int ans = (dp(parent, node, WHITE) + dp(parent, node, BLACK)) % MOD;

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static int dp(int parent, int node, int color) {

		// 현재 노드가 부모 이외의 노드와 연결점이 있다면 자식 노드가 있는 것이고
		// 현재 노드가 부모 이외의 노드가 없다면 현재 노드는 리프 노드이다.
		// 따라서 현재 노드의 간선 사이즈가 1이면 리프 노드이다.
		if (parent != 0 && edges[node].size() == 1) {
			return 1;
		}

		// dp 적인 문제의 특성을 고려하여 같은 계산을 반복하는 경우를 체크한다
		if (color == WHITE && dp_white[node] != -1) {
			return dp_white[node];
		} else if (color == BLACK && dp_black[node] != -1) {
			return dp_black[node];			
		}
		
		// 저장된 값이 없을 경우 계산한다
		long children = 1;
		for (int i = 0; i < edges[node].size(); i++) {
			long child = 0;
			int branch = edges[node].get(i);
			if(branch!=parent) {
				if(color == WHITE) {
					child = (dp(node, branch, WHITE) + dp(node, branch, BLACK)) % MOD;
				} else if(color == BLACK) {
					child = dp(node, branch, WHITE);
				}
				
				children *= child;
				children %= MOD;
			}			
		}
		
		if(color == WHITE) {
			dp_white[node] = (int)children;
		} else if(color == BLACK) {
			dp_black[node] = (int)children;
		}
		
		return (int)children;
	}
}
