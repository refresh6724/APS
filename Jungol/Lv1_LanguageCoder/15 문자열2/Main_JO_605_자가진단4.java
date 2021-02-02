import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_605_자가진단4 { // 제출일 2021-02-02 23:07

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열을 선언하고 다음과 같이
		// "Hong Gil Dong"이라는 이름을 복사하여 저장한 후 출력하는 프로그램을 작성하시오.
		// strcpy(문자열변수, "Hong Gil Dong");

		String a = "";
		String b = "Hong Gil Dong";
		a = String.copyValueOf(b.toCharArray());
		sb.append(a);
		bw.write(sb.toString());
		bw.flush();
	}

}