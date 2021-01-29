import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_596_자가진단4 { // 제출일 2021-01-29 21:39

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열을 입력받고 정수를 입력 받아서
		// 문자열의 맨 뒤부터 정수만큼 출력하는 프로그램을 작성하시오.
		// 만약 입력받은 정수가 문자열의 길이보다 크다면 맨 뒤부터 맨 처음까지 모두 출력한다.
		// (문자열 길이는 최대 100자 이하이다. )

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int cnt = sc.nextInt();
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= ((cnt > len) ? len : cnt); i++) {
			sb.append(s.charAt(len - i));
		}

//		
		bw.write(sb.toString());
		bw.flush();
	}

}