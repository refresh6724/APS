import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1092_제곱수출력 { // 제출일 2021-04-19 23:34

	// X를 Y번 곱한 값을 찾는 프로그램
	// 결과 값을 20091024로 나눈 나머지를 출력
	// 각 수는 0 이상 2^31 - 1 이하의 정수이다
	// 편의상 0을 0번 곱한것은 1로 정한다

	// x = 2 y = 10 일 때
	// x^(8+2) 가 되고
	// ((x^8 % MOD) * (x^2 % MOD)) % MOD 가 정답이 된다.
	// 따라서 각 x의 2의 배수 제곱에 대한 값을 dp로 풀면 된다

	static final int MOD = 20091024;
	static int x, y, ans;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		memo = new int[33];
		memo[0] = 1;
		memo[1] = x;
		for (int i = 2; i < memo.length; i++) {
			memo[i] = (int) (((long) memo[i - 1] * memo[i - 1]) % MOD);
		}
		ans = 1;
	}

	private static void go() {

		char[] b = Integer.toBinaryString(y).toCharArray();
		for (int i = b.length - 1, j = 1; i >= 0; i--, j++) {
			if (b[i] != '0') {
				ans = (int) (((long) memo[j] * ans) % MOD);
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}