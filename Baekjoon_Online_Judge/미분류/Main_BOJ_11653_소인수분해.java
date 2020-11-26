import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11653
 */
public class Main_BOJ_11653_소인수분해 { // 제출일 2020-11-26 23:13

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정수 N이 주어졌을때 소인수분해 결과를 오름차순으로 출력 (n은 최대 1천만)
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = 2;
		while (n != 1) {
			if (n % a == 0) {
				sb.append(a).append('\n');
				n /= a;
			} else {
				a++;
			}
		}
		System.out.println(sb.toString());
	}
}
