import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1932
 */
public class Main_BOJ_1932_정수삼각형 { // 제출일 2020-12-22 23:37

	static int n;
	static int[] num, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		sum = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = i; j >= 1; j--) {
				sum[j] = Math.max(sum[j - 1], sum[j]) + num[j];
			}
			sum[0] = sum[0] + num[0];
		}

		bw.write(String.valueOf(Arrays.stream(sum).max().getAsInt()));
		bw.flush();
	}

}
