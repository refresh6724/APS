import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1003_피보나치함수 { // 제출일 2020-06-13 21:13 12988 kb 72 ms
	
	static int[] dp = new int[42];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i < 42; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append(' ').append(dp[n+1]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}