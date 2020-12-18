import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1075
 */
public class Main_BOJ_1075_나누기 { // 제출일 2020-12-19 00:02

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 100 이상
		int f = Integer.parseInt(br.readLine()); // 100 이하?
		//
		n = n / 100;
		n = n * 100;
		int ans = 0;
		while (true) {
			if (n % f == 0) {
				break;
			}
			n++;
			ans++;
		}
		if (ans == 0) {
			System.out.println("00");
		} else if (ans < 10) {
			System.out.println(String.format("0%d", ans));
		} else {
			System.out.println(ans);
		}
	}
}
