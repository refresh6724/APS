import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_594_자가진단2 { // 제출일 2021-01-29 21:24

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열을 입력받은 뒤 그 문자열을 이어서 두 번 출력하는 프로그램을 작성하시오.
		// 문자열의 길이는 100이하이다.

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s + s);

//		
//		bw.write(sb.toString());
//		bw.flush();
	}

}