import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_11050_이항계수1 { // 제출일 2020-11-30 23:43

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 이항 계수 N C K를 출력
		// N 최대 10

		StringTokenizer st = new StringTokenizer(br.readLine());
		// dfs or dp
		
//		int[] fac = new int[11];
//		fac[0] = 0;
//		fac[1] = 1;
//		for (int i = 2; i < 11; i++) {
//			fac[i] = i*fac[i-1];
//		}
		
		// 방법 1
		// 공식 nCk = n!/k!(n-k)!
		// 방법 2
		// 공식 nCk = n-1Ck + n-1Ck-1
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		bw.write(Integer.toString((fac(n) / (fac(k) * fac(n - k)))));
		bw.flush();
		
	}

	private static int fac(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * fac(n - 1);
	}
}
