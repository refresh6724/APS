import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_214_형성평가10 { // 제출일 2021-02-16 23:20

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 10개의 단어를 입력받고 문자 하나를 더 입력 받는다.
		// 문자를 포함하는 단어를 모두 찾아 사전 순으로 출력하시오.
		// 단어는 100자 이하다.

		String[] words = new String[10];
		for (int i = 0; i < words.length; i++) {
			words[i] = br.readLine();
		}
		String find = br.readLine();
		ArrayList<String> li = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains(find)) {
				li.add(words[i]);
			}
		}
		Collections.sort(li);
		for (String a : li) {
			sb.append(a).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}