import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5086
 */
public class Main_BOJ_5086_배수와약수 { // 제출일 2020-11-24 01:34

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (a != 0) {
			if (b % a == 0) {
				sb.append("factor").append('\n');
			} else if (a % b == 0) {
				sb.append("multiple").append('\n');
			} else {
				sb.append("neither").append('\n');
			}

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		System.out.print(sb.toString());
	}

}
