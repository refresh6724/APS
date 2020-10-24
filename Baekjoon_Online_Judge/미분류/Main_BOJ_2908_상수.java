import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2908
 */
public class Main_BOJ_2908_상수 { // 제출일 2020-10-24 23:08

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 주어진 두 세자리 수를 거꾸로 읽어서 큰 수를 출력한다
		char[] input = br.readLine().toCharArray();
		int a = 100 * (input[2] - '0') + 10 * (input[1] - '0') + (input[0] - '0');
		int b = 100 * (input[6] - '0') + 10 * (input[5] - '0') + (input[4] - '0');
		System.out.println(Math.max(a, b));
	}
}
