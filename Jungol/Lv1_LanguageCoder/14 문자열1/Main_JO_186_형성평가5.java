import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_186_형성평가5 { // 제출일 2021-01-31 18:42

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 개의 단어를 입력받아서 길이가 긴 단어의 문자 개수를 출력하는 프로그램을 작성하시오.
		// 단어의 길이는 100자 이하다.

		st = new StringTokenizer(br.readLine());
		int a = st.nextToken().length();
		int b = st.nextToken().length();
		sb.append(Math.max(a, b));

		bw.write(sb.toString());
		bw.flush();
	}

}