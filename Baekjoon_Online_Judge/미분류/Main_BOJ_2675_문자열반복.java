import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2675
 */
public class Main_BOJ_2675_문자열반복 { // 제출일 2020-10-21 23:07

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			String input = br.readLine();
			int repeat = input.charAt(0) - '0';
			char[] s = input.substring(2).toCharArray();
			for (int j = 0; j < s.length; j++) {
				for (int j2 = 0; j2 < repeat; j2++) {
					sb.append(s[j]);
				}				
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
