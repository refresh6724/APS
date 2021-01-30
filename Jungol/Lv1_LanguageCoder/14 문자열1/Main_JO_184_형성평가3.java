import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_184_형성평가3 { // 제출일 2021-01-30 23:39

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 100개 이하의 문자열을 입력받아서
		// 영문자와 숫자만 출력하되 영문자는 모두 소문자로 출력하는 프로그램을 작성하시오.

		String a = br.readLine();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isAlphabetic(a.charAt(i))) {
				sb.append(Character.toLowerCase(a.charAt(i)));
			} else if (Character.isDigit(a.charAt(i))) {
				sb.append(a.charAt(i));
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}