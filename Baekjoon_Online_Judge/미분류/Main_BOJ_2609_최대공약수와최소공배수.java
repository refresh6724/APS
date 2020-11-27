import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2609
 */
public class Main_BOJ_2609_최대공약수와최소공배수 { // 제출일 2020-11-27 23:17

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 두 개의 자연수를 받아 최대 공약수와 최소 공배수를 출력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		System.out.println(gcd(n, m));
		System.out.println(lcm(n, m));
	}

	private static int lcm(int n, int m) {
		return n * m / gcd(n, m);
	}

	private static int gcd(int n, int m) {
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}
}
