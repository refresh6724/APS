import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 { // 제출일 2021-04-05 23:32

	static int answer;
	static int n; // 정점의 개수
	static int[][] map;

	public static void main(String[] args) throws Exception {
		input();
		tsp();
		System.out.println(answer);
	}

	private static void tsp() {
		// 전형적인 TSP 문제
		// 백트래킹
		// 1번에서 출발 ~ 1번으로 돌아오기
		int num = 0;
		int sum = 0;
		int cnt = 0;
		int visited = 0;
		go(num, cnt, sum, visited);
	}

	private static void go(int num, int cnt, int sum, int visited) {
		if (answer < sum) {
			return;
		}
		if (cnt == n - 1) { // 마지막이라면 0으로 가는 길을 체크
			if (map[num][0] != 0) {
				sum += map[num][0];
				if (answer > sum) {
					answer = sum;
				}
			}
			return;
		}
		for (int i = 1; i < n; i++) { // 0 으로 가는길을 제외
			if ((visited & (1 << i)) == 0 // 둘 다 1이면 1 아니면 0
					&& map[num][i] != 0) { // 길이 0 이 아니어야 함
				go(i, cnt + 1, sum + map[num][i], visited | (1 << i));
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim()); // 1 이상 12 이하
		answer = 100 * 13 * 13; // 최댓값보다 큰 값
		map = new int[n][n];
		for (int i = 0; i < n; i++) { // 비용 각 0 이상 100 미만
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
