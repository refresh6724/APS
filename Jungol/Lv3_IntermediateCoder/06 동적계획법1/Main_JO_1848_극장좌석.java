import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_JO_1848_극장좌석 { // 제출일 2021-05-12 23:39

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		// 고정 좌석이 없을 경우 fib 수열을 따름
		// 고정 좌석을 기준으로 부분을 서로 곱한 것과 같은 결과
		// 예제 풀이
		// 123456789
		// OOOXOOXOO
		// fib[3] * fib[2] * fib[2]
		int[] fib = new int[41];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		char[] numArr = new char[n + 1];
		Arrays.fill(numArr, 'O');
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			numArr[Integer.parseInt(br.readLine())] = 'X';
		}
		String num = String.copyValueOf(numArr, 1, n);

		st = new StringTokenizer(num, "X");
		int ans = 1;
		while (st.hasMoreTokens()) {
			ans *= fib[st.nextToken().length()];
		}
		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
	}

}