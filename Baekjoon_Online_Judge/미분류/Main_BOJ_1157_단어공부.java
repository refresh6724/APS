import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1157
 */
public class Main_BOJ_1157_단어공부 { // 제출일 2020-10-22 23:06

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한 단어에서 가장 많이 사용된 알파벳, 대소문자 구분 없음
		int[] alphabet = new int[26];
		char[] s = br.readLine().toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= 'a') {
				alphabet[s[i] - 'a']++;
			} else {
				alphabet[s[i] - 'A']++;
			}
		}
		int max = 0;
		int maxIdx = 0;
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (max < alphabet[i]) {
				max = alphabet[i];
				maxIdx = i;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == max) {
				cnt++;
			}
		}
		if (cnt == 1) {
			System.out.println((char) (maxIdx + 'A'));
		} else {
			System.out.println('?');
		}
	}
}
