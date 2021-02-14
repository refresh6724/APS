import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_208_형성평가4 { // 제출일 2021-02-14 20:54

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수 n(n≤10)을 입력받아 n!(팩토리얼)을 구하여 출력하시오.
		// n! = n * (n-1) * (n-2) * (n-3) …
		// 즉, 4! = 4 * 3 * 2 * 1 이다.

		int n = Integer.parseInt(br.readLine());
		int[] fac = new int[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i;
		}
		sb.append(fac[n]);
		bw.write(sb.toString());
		bw.flush();
	}

	// stackoverflow
	private static int fac_recursive(int n) {
		if (n == 1) {
			return 1;
		}
		return fac_recursive(n - 1) * n;
	}

}