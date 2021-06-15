import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1407_숫자카드 { // 제출일 2021-06-15 23:22

	static String a;
	static int n;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1부터 34까지의 숫자 카드가 충분히 많이 있을 때
		a = br.readLine().trim();
		n = a.length();
		memo = new int[n];
		memo[0] = 1;
		int firstTwo = Integer.parseInt(a.substring(0, 2));
		memo[1] = (10 <= firstTwo && firstTwo <= 34) ? 2 : 1;
	}

	private static void go() {

		for (int i = 2; i < n; i++) {
			int one = a.charAt(i) - '0';
			int ten = (a.charAt(i - 1) - '0') * 10 + one;
			if (1 <= one && one <= 9) { // 자신이 1에서 9 사이 숫자라면
				memo[i] += memo[i - 1];
			}
			if (10 <= ten && ten <= 34) { // 앞칸과 자신 두 칸이 10에서 34 사이 숫자라면
				memo[i] += memo[i - 2];
			}
		}

		// BufferedWriter 사용시 출력이 안된다?
		System.out.println(memo[n - 1]);
	}

}