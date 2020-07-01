import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_3408_세가지합구하기 { // 제출일 2020-07-01 22:35 27,452 kb 154 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc);

			// S1 = 양의 정수 중에서 작은 순서대로 N개의 합
			// S2 = 양의 정수 중 홀수인 것들 중에서 작은 순서대로 N개의 합
			// S3 = 양의 정수 중 짝수인 것들 중에서 작은 순서대로 N개의 합

			long N = Long.parseLong(br.readLine());

			long S1 = (N * (N + 1)) / 2;
			long S2 = (N * 2) * (N / 2) + ((N % 2 == 0) ? 0 : N); // N이 홀수라면 N을 더하고 짝수라면 0을 더한다
			long S3 = S2 + N;

			sb.append(' ').append(S1).append(' ').append(S2).append(' ').append(S3).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}