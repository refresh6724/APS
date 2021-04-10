import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1382_동전바꿔주기 { // 제출일 2021-04-10 23:36

	static int T, K;
	static int[] p, n;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine().trim()); // 목표액 1 이상 1만 이하
		K = Integer.parseInt(br.readLine().trim()); // 가짓수 1 이상 100 이하
		p = new int[K + 1];
		n = new int[K + 1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken()); // 금액 1 이상 T 이하
			n[i] = Integer.parseInt(st.nextToken()); // 개수 1 이상 1000 이하
		}

		// 전체 경우의 수 k^n 최대 100^1000
		// i번째 코인으로 j원 만들기
		memo = new int[101][10001];
		for (int i = 0; i < 101; i++) {
			// i번째 코인으로 0원 만드는 방법은 딱 1가지
			memo[i][0] = 1;
		}

	}

	private static void go() {

		for (int coinIdx = 1; coinIdx <= K; coinIdx++) {
			for (int sum = 1; sum <= T; sum++) {
				for (int select = 0; select <= n[coinIdx]; select++) {
					if (p[coinIdx] * select > sum) {
						// 계산 범위를 넘어가면 의미 없는 계산
						break;
					}
					// i번째 코인까지 사용했을때 j원 만드는 방법은
					// i-1번째 코인까지 써서 만든 j-'이번에 만들 수 있는 수'원 만드는 방법을 포함한다
					memo[coinIdx][sum] += memo[coinIdx - 1][sum - p[coinIdx] * select];
				}
			}
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(memo[K][T]);
		bw.write(sb.toString());
		bw.flush();
	}

}