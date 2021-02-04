
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_608_자가진단7 { // 제출일 2021-02-03 22:54

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 100개 이하의 문자로 구성된 한 개의 문자열을 입력받아서
		// 그 문자열에 문자 'c'와 문자열 "ab"의 포함여부를
		// "Yes", "No"로 구분하여 출력예처럼 출력하는 프로그램을 작성하시오.
		// abdef
		// No Yes

		String a = br.readLine();
		if (a.contains("c")) {
			sb.append("Yes ");
		} else {
			sb.append("No ");
		}
		if (a.contains("ab")) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}

		bw.write(sb.toString());
		bw.flush();
	}

}