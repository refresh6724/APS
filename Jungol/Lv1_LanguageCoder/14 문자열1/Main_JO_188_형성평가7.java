import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_188_형성평가7 { // 제출일 2021-01-31 19:01

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 문자열을 입력받아 다음과 같이 분리하여 번호와 함께 출력하는 프로그램을 작성하시오.
		// 문자열의 길이는 100자 이하이다.​

		int cnt = 1;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			sb.append(cnt++).append(". ").append(st.nextToken()).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}