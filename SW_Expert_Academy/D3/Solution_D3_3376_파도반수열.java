import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3376_파도반수열 { // 제출일 2020-06-30 22:57 18,700 kb 110 ms

	static long[] p = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = null;

		wave();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			answer.append('#').append(tc).append(' ').append(p[n]).append("\n");
		}
		bw.write(answer.toString());
		bw.flush();
	}

	static void wave() {
		// p1 ~ 10
		// 1 1 1 2 2 / 3 4 5 7 9

		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;

		// 수열의 규칙
		for (int i = 6; i < 101; i++) {
			p[i] = p[i - 1] + p[i - 5];
		}

	}

}
