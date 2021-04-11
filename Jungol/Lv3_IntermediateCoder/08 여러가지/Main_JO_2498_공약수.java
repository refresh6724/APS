import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2498_공약수 { // 제출일 2021-04-11 23:59

	static int GCD, LCM, a, b, x, y;

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
		a = 0;
		b = 0;
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
		int min = 200000000;
		for (int i = (int) (Math.sqrt(xy)); i >= 1; i--) {
			if (xy % i == 0 && gcd(i*GCD, xy/i*GCD) == GCD) {
				x = i;
				y = xy / i;				
				if (min > x * GCD + y * GCD) {
					a = x * GCD;
					b = y * GCD;
					min = a + b;
				}
			}
		}
	}

	private static int gcd(int a, int b) {

		return (b != 0) ? gcd(b, a % b) : a;

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(' ').append(b);
		bw.write(sb.toString());
		bw.flush();
	}

}