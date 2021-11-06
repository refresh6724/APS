import java.io.IOException;
import java.util.Scanner;

public class Main_BOJ_1019_책페이지 { // 제출일 2021-11-06 23:01

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 1페이지부터 n페이지까지 0에서 9까지 몇번씩 나오는지 출력

		// 한자리 : 1~n까지 한번씩
		// 두자리 : 예를 들어 75라면
		// 0~9가 7번, 1~6이 10번, 7이 6번, 0에서 5가 1번
		// 세자리 : 275라면
		// 1의 자리에서 0~9가 27번돌고 -[0]*1, 0~4가 1번, 5가 (0+1)번
		// 10의 자리에서 0~9가 2*10번 -[0]*10, 0~6이 10번, 7이 (5+1)번
		// 100의 자리에서 0~9가 0*100번 -[0]*100, 0~1이 100번, 2가 (75+1)번

		int[] cnt = new int[10];
		int split = 1;
		while (split <= n) {
			int mok = n / (split * 10);
			int nam = n % (split * 10);
			int nammok = nam / split;
			int namnam = nam % split;
			for (int i = 0; i < cnt.length; i++) {
				cnt[i] += mok * split;
			}
			cnt[0] -= split;
			for (int i = 0; i < nammok; i++) {
				cnt[i] += split;
			}
			cnt[nammok] += namnam + 1;			
			
			split *= 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt.length; i++) {
			sb.append(cnt[i]).append(' ');
		}
		System.out.println(sb.toString());

	}

}