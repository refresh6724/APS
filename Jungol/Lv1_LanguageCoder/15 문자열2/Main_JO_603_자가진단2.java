import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_603_자가진단2 { // 제출일 2021-02-02 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 문장을 입력 받아서 홀수 번째 단어를 차례로 출력하는 프로그램을 작성하시오.
		// 문장의 길이는 100자 이하이다.

		st = new StringTokenizer(br.readLine(), " ");
		int len = st.countTokens();
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				sb.append(st.nextToken()).append('\n');
			} else {
				st.nextToken();
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}