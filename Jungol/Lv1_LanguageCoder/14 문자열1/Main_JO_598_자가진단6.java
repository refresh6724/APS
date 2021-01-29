import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_598_자가진단6 { // 제출일 2021-01-29 22:10

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자를 입력받아 알파벳 문자인 경우에는
		// 그대로 출력하고 숫자인 경우는 아스키코드값을 출력하는 작업을 반복하다가
		// 기타의 문자가 입력되면
		// 종료하는 프로그램을 작성하시오.
		// *입출력예에서 진한글씨가 출력

		// A
		// *A
		// 1
		// *49
		// @

		Scanner sc = new Scanner(System.in);
		while (true) {
			String a = sc.next();
			if (Character.isAlphabetic(a.charAt(0))) {
				System.out.println(a);
			} else if (Character.isDigit(a.charAt(0))) {
				System.out.println((int) a.charAt(0));
			} else {
				break;
			}
		}

//		
		bw.write(sb.toString());
		bw.flush();
	}

}