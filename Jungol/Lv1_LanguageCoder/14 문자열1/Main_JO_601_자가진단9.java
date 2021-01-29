import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_601_자가진단9 { // 제출일 2021-01-29 23:22

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열을 입력 받아서
		// 문자수만큼 오른쪽으로 한 바퀴 회전하여 출력하는 프로그램을 작성하시오.
		// 문자열의 길이는 100이하이다.

		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		for (int i = 0; i < a.length(); i++) {
			sb.append(a.substring(a.length() - 1 - i, a.length()));
			sb.append(a.substring(0, a.length() - 1 - i));
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}