import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1002_최대공약수최소공배수 { // 제출일 2021-03-02 22:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = 0;
		int g = a;
		int l = a;
		for (int i = 1; i < n; i++) {
			b = Integer.parseInt(st.nextToken());
			g = gcd(g, b);
			l = lcm(l, b);
		}
		sb.append(g).append(' ').append(l);

		bw.write(sb.toString());
		bw.flush();
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

}