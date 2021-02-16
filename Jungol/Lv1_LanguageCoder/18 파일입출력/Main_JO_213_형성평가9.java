import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_213_형성평가9 { // 제출일 2021-02-16 23:18

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 한 문장을 입력받아서 전체 길이와 가장 긴 단어를 출력하시오.
		// 단, 문장의 길이는 최대 100자 이내이고, 길이가 가장 긴 단어가 여러 개인 경우 공백으로 분리하여 한 줄에 입력 받은 순서대로 모두
		// 출력하시오.
		// 이 문제에서의 단어란? 공백으로 분리하는 문자열을 뜻한다.
		// "i am a boy." 문자열의 경우
		// "i", "am", "a", "boy."가 각각 단어이다.

		String input = br.readLine();
		String[] words = input.split(" ");
		String longest = "";
		int len = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > len) {
				longest = words[i];
				len = longest.length();
			} else if (words[i].length() == len) {
				longest = longest.concat(" ").concat(words[i]);
			}
		}
		sb.append(input.length()).append('\n');
		sb.append(longest);

		bw.write(sb.toString());
		bw.flush();
	}

}