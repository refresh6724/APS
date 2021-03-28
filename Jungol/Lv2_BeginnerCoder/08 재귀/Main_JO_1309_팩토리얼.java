import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1309_팩토리얼 { // 제출일 2021-03-28 19:27

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 재귀로 1~15 ! 구하기

		int n = Integer.parseInt(br.readLine());
		sb.append(fac(n));

		bw.write(sb.toString());
		bw.flush();
	}

	private static long fac(int n) {
		if (n == 1) {
			sb.append("1! = 1\n");
			return 1;
		}
		sb.append(String.format("%d! = %d * %d!\n", n, n, n - 1));
		return fac(n - 1) * n;
	}

}