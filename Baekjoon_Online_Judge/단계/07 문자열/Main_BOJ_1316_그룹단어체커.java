import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1316
 */
public class Main_BOJ_1316_그룹단어체커 { // 제출일 2020-10-28 23:15

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최대 100자 입력
		// 그룹 단어란 단어 내의 모든 문자가 1이상 연속으로 나타나는 경우를 말한다
		// 비연속적인 경우 그룹단어가 아니다
		int testcase = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < testcase; i++) {
			boolean[] alphabet = new boolean[26];
			char[] input = br.readLine().toCharArray();
			char prev = input[0];
			alphabet[prev - 'a'] = true;
			boolean ans = true;
			for (int j = 0; j < input.length; j++) {
				// prev 와 달라지는 경우에 중복 체크
				if (input[j] == prev) {
					continue;
				} else {
					if (alphabet[input[j] - 'a']) {
						ans = false;
						break;
					} else {
						alphabet[input[j] - 'a'] = true;
						prev = input[j];
					}
				}
			}
			if (ans) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
