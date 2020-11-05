import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4153
 */
public class Main_BOJ_4153_직각삼각형 { // 제출일 2020-11-05 23:31

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		while (input.charAt(0) != '0') {

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// a b c 를 정렬
			if (a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			if (b > c) {
				int tmp = b;
				b = c;
				c = tmp;
			}
			if (a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}

			if (c * c == a * a + b * b) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

			input = br.readLine();
			st = new StringTokenizer(input);
		}
	}
}
