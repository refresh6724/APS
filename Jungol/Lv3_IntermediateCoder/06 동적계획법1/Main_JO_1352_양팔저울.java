import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1352_양팔저울 { // 제출일 2021-06-21 23:59

	static int n, m;
	static int[] weight, bead, sumofweight;
	static boolean[][] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 추의 개수 1 이상 30 이하
		sumofweight = new int[n + 1];
		weight = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			weight[i] = Integer.parseInt(st.nextToken()); // 추의 무게 각 1 이상 500 이하
			sumofweight[i] = sumofweight[i - 1] + weight[i];
		}
		m = Integer.parseInt(br.readLine().trim()); // 구슬의 수 1 이상 7 이하
		bead = new int[m];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			bead[i] = Integer.parseInt(st.nextToken()); // 구슬의 무게 각 0 이상 4만 이하
		}
		memo = new boolean[n + 1][15000];
	}

	// 방법1
	// 구슬 + 추의 무게로 만들 수 있는 무게가 짝수이고
	// 둘로 나눈 무게를 2번 만들 수 있으면 Y 아니면 N

	// 방법2
	// 구슬 + 추 0개 = 나머지 추로 해당 무게를 만들 수 있는가
	// (구슬 + 추 1개 ) * 30 = 나머지 추로 해당 무게 만들기
	// (구슬 + 추 2개 ) * 30C2 = 나머지 추로 해당 무게 만들기

	private static void go() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int idx = 1; idx <= n; idx++) {
			// idx번째 추를 사용하면 weight[idx] 무게를 측정 가능
			memo[idx][weight[idx]] = true;

			// 무게추는 가벼운 것부터 순서대로 입력되고
			// idx를 사용하지 않을 때 만들 수 있는 최대 무게까지
			for (int test = 1; test <= sumofweight[idx - 1]; test++) {
				// idx를 사용하지 않은 추로 test무게를 만들 수 있다면
				if (memo[idx - 1][test]) {
					// 사용과 관계없이 만들 수 있고
					memo[idx][test] = true;
					// 어느쪽에 사용하는지에 따라 만들 수 있는 값이 달라진다
					memo[idx][test + weight[idx]] = true;
					memo[idx][Math.abs(test - weight[idx])] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {

			if (sumofweight[n] < bead[i]) {
				sb.append("N ");
			} else if (sumofweight[n] == bead[i] || bead[i] == 0) {
				sb.append("Y ");
			} else {
				if (memo[n][bead[i]]) {
					sb.append("Y ");
				} else {
					sb.append("N ");
				}
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

}