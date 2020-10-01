public class Solution_Level_3_배달 { // 제출일 2020-10-01 23:20

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } }, 3)); // 4
		System.out.println(solution(6, new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } }, 4)); // 4
	}

	public static int solution(int N, int[][] road, int K) {
		// 마을 개수 최대 50
		// 마을 a => 마을 b 가중치 c
		// 가중치 c는 최대 1만, a=>b 여러 경로가 있을 수 있다

		// 각 마을 이동거리를 max로 초기화
		int[][] adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = 100000000; // 1억
			}
		}
		for (int i = 0; i < N; i++) {
			adjMatrix[i][i] = 0;
		}
		// 주어진 가중치 정보를 입력
		// 중복 경로의 경우 더 짧은 경로로 덮어쓴다
		for (int i = 0; i < road.length; i++) {
			adjMatrix[road[i][0] - 1][road[i][1] - 1] = Math.min(adjMatrix[road[i][0] - 1][road[i][1] - 1], road[i][2]);
			adjMatrix[road[i][1] - 1][road[i][0] - 1] = Math.min(adjMatrix[road[i][1] - 1][road[i][0] - 1], road[i][2]);
		}
		// 플로이드 워셜 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
				}
			}
		}
		// 1번 마을에서 K 이하 시간으로 갈 수 있는 장소의 숫자를 리턴
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (adjMatrix[0][i] <= K) {
				ans++;
			}
		}
		return ans;
	}
}