import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://github.com/refresh6724/APS/Baekjoon_Online_Judge
public class Main_JO_1009_분산처리 { // 제출일 2021-11-04 23:43

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 방법 1번
		// 모듈러 연산의 원리를 활용하여 2의 제곱수에 해당하는 값으로 처리하기
		// a^1 % 10 = a % 10
		// a^2 % 10 = (a % 10) * (a % 10) % 10
		// a^4 % 10 = (a^2 % 10) * (a^2 % 10) % 10
		// 1 ≤ a < 100, 1 ≤ b < 1,000,000

		int[] b2 = new int[21];
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Arrays.fill(b2, 0);
			b2[1] = a % 10;
			for (int j = 2; j < b2.length; j++) {
				b2[j] = (b2[j - 1] * b2[j - 1]) % 10;
			}
			int answer = 1;
			char[] sr = Integer.toBinaryString(b).toCharArray();
			for (int j = sr.length - 1, idx = 1; j >= 0; j--, idx++) {
				if (sr[j] == '1') {
					answer *= b2[idx];
					answer %= 10;
				}
			}
			sb.append((answer == 0) ? 10 : answer).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}