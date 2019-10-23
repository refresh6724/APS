import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_5607_Professional_조합 { // 제출일 2019-10-23 17:12 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int MOD = 1234567891; // 소수
	static int SIZE = 1000000; // 백만
	static long[] fac;
	static int n;
	static int r;
	static int answer;

	public static void main(String[] args) throws Exception {
		// https://5stralia.tistory.com/4
		// https://lifeignite.tistory.com/43
		// https://m.blog.naver.com/1ilsang/221461026692

		// 소수 체크
		// primeCheck(MOD);

		// 11111. 팩토리얼을 미리 구한다.
		fac = new long[SIZE + 1];
		fac[0] = 1L;
		for (int i = 1; i <= SIZE; i++) {
			fac[i] = (fac[i - 1] * i) % MOD;
		}

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);

			// 페르마의 소정리 결론
			// a^(p-1) = 1 (mod p)

			// 조합 Combination
			// n C r = n! / r! (n-r)!

			// 나누기는 mod 연산이 안된다.
			// a = r! (n-r)! ^ (-1) 로 변환

			// 페르마의 소정리 식 양변에 a^(-1) 을 곱해주면
			// a^(p-2) = a^(-1) (mod p)
			// r! (n-r)! ^ (1234567891 - 2) = r! (n-r)! ^ (-1) (mod 1234567891)

			// 22222. 분모를 구한다
			long denominator = (fac[r] * fac[n - r]) % MOD;
			// 33333. 분모가 너무 크므로 페르마 소정리를 이용해 줄여준다
			long compact = fermat(denominator, MOD - 2);

			// 44444. 문제에서 요구한 값을 구한다			
			answer = (int) ((fac[n] * compact) % MOD);

			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}

	}

	private static long fermat(long denominator, int i) {
		if (i == 0)
			return 1;
		long tmp = fermat(denominator, i / 2);
		long ret = (tmp * tmp) % MOD;
		if (i % 2 == 0)
			return ret;
		else
			return (ret * denominator) % MOD;
	}

	private static void primeCheck(int n) {
		int i = 2;
		int max = (int) Math.sqrt(n);
		while (true) {
			if (i <= max) {
				if (n % i == 0) {
					System.out.println("소수 아님");
					break;
				} else {
					i++;
				}
			} else {
				System.out.println("소수");
				break;
			}
		}
	}

}
