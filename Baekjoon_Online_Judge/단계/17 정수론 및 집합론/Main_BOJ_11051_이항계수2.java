import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_11051_이항계수2 { // 제출일 2020-12-02 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 이항 계수 N C K를 10007로 나눈 나머지를 출력
		// N 최대 1000

		StringTokenizer st = new StringTokenizer(br.readLine());
		// dp

		int[] fac = new int[1001];
		fac[0] = 1;
		for (int i = 1; i < 1001; i++) {
			fac[i] = i * (fac[i - 1] % 10007);
		}

		// 방법 1
		// 공식 nCk = n!/k!(n-k)!
		// 방법 2
		// 공식 nCk = n-1Ck + n-1Ck-1
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// fac[k] * t mod 10007 = 1
		int fac_k = fac[k] % 10007;
		int t1 = 0;
		for (t1 = 0; t1 < 10007; t1++) {
			if ((fac_k * t1) % 10007 == 1) {
				break;
			}
		}
		// fac[n-k] * t mod 10007 = 1
		int fac_nk = fac[n - k] % 10007;
		int t2 = 0;
		for (t2 = 0; t2 < 10007; t2++) {
			if ((fac_nk * t2) % 10007 == 1) {
				break;
			}
		}
		bw.write(Integer.toString(((fac[n] % 10007) * ((t1 * t2) % 10007) % 10007)));
		bw.flush();
	}

}
