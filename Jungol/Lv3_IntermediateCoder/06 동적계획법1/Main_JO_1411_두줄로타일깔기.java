import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1411_두줄로타일깔기 { // 제출일 2021-05-11 23:17

	static final int MOD = 20100529;
	static int n;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 가로 2칸 세로 n칸을 2x2와 2x1 타일로 채우는 방법
		n = Integer.parseInt(br.readLine()); // 1 이상 10만 이하
		memo = new int[n + 1];
		memo[0] = 0; // 0칸을 채우는 방법은 없다
		memo[1] = 1; // 첫 한칸을 채우는 방법은 1가지이다.
		memo[2] = 3; // 2x2를 채우는 방법은 2x2를 사용하는 방법과 2x1을 가로로 2번 또는 세로로 2번 사용하는 방법니다.
		memo[3] = memo[2] * 1 + memo[1] * 2; // 2칸을 채우고 1칸을 채우는 방법과 1칸을 채우고 2칸을 채우는 방법이다
		for (int i = 4; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2] * 2) % MOD;
		}
		sb.append(memo[n]);

		bw.write(sb.toString());
		bw.flush();
	}

}