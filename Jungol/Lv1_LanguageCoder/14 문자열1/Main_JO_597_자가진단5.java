import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_597_자가진단5 { // 제출일 2021-01-29 21:41

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 개의 문자열을 입력받아서 두 문자열의 길이의 합을 출력하는 프로그램을 작성하시오.
		// 각 문자열의 길이는 20자 미만이다.

		Scanner sc = new Scanner(System.in);
		int a = sc.next().length();
		int b = sc.next().length();
		sb.append(a + b);

//		
		bw.write(sb.toString());
		bw.flush();
	}

}