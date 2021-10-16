import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Level_2_부분팰린드롬문자열 { // 제출일 2020-09-09 22:55
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1000 문자에서 가장 긴 팰린드롬 길이

		char[] input = br.readLine().toCharArray();
		int ans = 0;
		int tmp, left, right;

		// 짝수인 경우
		for (int i = 0; i < input.length - 1; i++) {
			tmp = 0;
			left = i;
			right = i + 1;
			while (input[left] == input[right]) {
				left--;
				right++;
				tmp += 2;
				if (left < 0 || right == input.length) {
					break;
				}
			}
			ans = Math.max(ans, tmp);
		}
		// 홀수인 경우
		for (int i = 1; i < input.length - 1; i++) {
			tmp = 1;
			left = i - 1;
			right = i + 1;
			while (input[left] == input[right]) {
				left--;
				right++;
				tmp += 2;
				if (left < 0 || right == input.length) {
					break;
				}
			}
			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);
	}
}