import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_600_자가진단8 { // 제출일 2021-01-29 22:29

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 100글자 이하의 문자열을 입력받아
		// 문장을 이루는 단어의 개수를 출력하는 프로그램을 작성하시오.
		// * 문장입력 할 때 gets()함수 대신 fgets() 함수를 사용하세요. C++14 적용!​

		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().trim().split(" ");
		System.out.println(a.length);

//		
		bw.write(sb.toString());
		bw.flush();
	}

}