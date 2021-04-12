import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2498_공약수 { // 제출일 2021-04-12 00:35

	static int GCD, LCM, x, y;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		GCD = Integer.parseInt(st.nextToken());
		LCM = Integer.parseInt(st.nextToken());

		x = 0;
		y = 0;
	}

	private static void go() {
		// a+b가 최소가 되는 쌍
		// a = x * gcd;
		// b = y * gcd;
		// lcm = a/gcd*b = x*y*gcd;
		// x*y = lcm/gcd;
		int xy = LCM / GCD;
		for (int i = (int) (Math.sqrt(xy)); i >= 1; i--) {
			// 단, x, y는 서로소이다
			if (xy % i == 0 && gcd(i, xy / i) == 1) {
				x = i;
				y = xy / i;
				return;
			}
		}
	}

	private static int gcd(int a, int b) {
		return (b != 0) ? gcd(b, a % b) : a;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(x * GCD).append(' ').append(y * GCD);
		bw.write(sb.toString());
		bw.flush();
	}

}