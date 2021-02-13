import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_629_자가진단4 { // 제출일 2021-02-13 23:22

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 문자열을 두 번 입력받아
		// 길이가 작은 문자열과 긴 문자열의 순으로 출력하는 프로그램을 작성하시오.
		// 각 문자열의 길이는 100자를 넘지 않는다.
		// * 표준입출력방식으로 작성하세요.

		String a = br.readLine();
		String b = br.readLine();
		if (a.length() < b.length()) {
			sb.append(a).append('\n').append(b);
		} else {
			sb.append(b).append('\n').append(a);
		}

		bw.write(sb.toString());
		bw.flush();
	}

}