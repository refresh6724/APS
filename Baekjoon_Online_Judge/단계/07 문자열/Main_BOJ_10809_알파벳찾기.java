import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10809
 */
public class Main_BOJ_10809_알파벳찾기 { // 제출일 2020-10-19 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문장S의 각 알파벳 위치를 출력, 없으면 -1
		char[] s = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		for (int i = 0; i < s.length; i++) {
			int c = s[i] - 'a';
			if (alphabet[c] == -1) {
				alphabet[c] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(alphabet[0]);
		for (int i = 1; i < alphabet.length; i++) {
			sb.append(' ').append(alphabet[i]);
		}
		System.out.println(sb.toString());
	}

}
