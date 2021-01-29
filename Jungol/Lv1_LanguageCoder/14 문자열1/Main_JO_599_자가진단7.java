import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_599_자가진단7 { // 제출일 2021-01-29 22:14

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열을 입력받아 알파벳 문자만 모두 대문자로 출력하는 프로그램을 작성하시오.
		// 문자열의 길이는 100이하이다.

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isAlphabetic(a.charAt(i))) {
				sb.append(Character.toUpperCase(a.charAt(i)));
			}
		}

//		
		bw.write(sb.toString());
		bw.flush();
	}

}