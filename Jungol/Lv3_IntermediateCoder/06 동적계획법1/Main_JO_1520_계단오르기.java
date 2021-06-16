import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_1520_계단오르기 { // 제출일 2021-06-16 23:14

	static int n;
	static int[] stair;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		stair = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine().trim());
		}
		memo = new int[n + 1][3];
		memo[1][1] = stair[1];
	}

	// 계단 오르기 규칙
	// 1. 한 번에 한 계단 또는 두 계단
	// 2. 연속인 세 계단을 밟으면 안된다
	// 3. 마지막 계단은 반드시 밟아야 한다
	private static void go() {
		// 0을 시작점이라 할 때
		// i번째를 안밟으면 0 밟으면 1 이전칸에 이어 연속으로 밟았다면 2
		for (int i = 2; i <= n; i++) {
			memo[i][0] = Math.max(memo[i - 1][1], memo[i - 1][2]);
			memo[i][1] = memo[i - 1][0] + stair[i];
			memo[i][2] = memo[i - 1][1] + stair[i];
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// 마지막 계단은 반드시 밟아야 한다
//		sb.append(Math.max(memo[n][0], Math.max(memo[n][1], memo[n][2])));
		sb.append(Math.max(memo[n][1], memo[n][2]));
		bw.write(sb.toString());
		bw.flush();
	}

}