import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_593_자가진단1 { // 제출일 2021-01-29 21:15

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 33부터 127 까지의 숫자를 계속 입력받아
		// 입력받은 숫자의 아스키코드에 해당하는 문자를 출력하다가
		// 범위를 벗어나는 입력이 들어오면
		// 종료하는 프로그램을 작성하시오.

		// ASCII code =? 66
		// B
		// ASCII code =? 122
		// z
		// ASCII code =? 0

		// 왜 입출력 예제가 답과 다른가
		// => Input Data top 100 lines
		// 66
		// 122
		// 0
		//
		// => Solution Data top 100 lines
		// ASCII code =? B
		// ASCII code =? z
		// ASCII code =?
		//
		//
		// => User Output top 100 lines
		// ASCII code =?
		// B
		// ASCII code =? ASCII code =?
		// z
		// ASCII code =? ASCII code =?

		Scanner sc = new Scanner(System.in);
		int n = 33;
		System.out.print("ASCII code =? ");
		while (true) {
			n = sc.nextInt();
			if (n >= 33 && n <= 127) {
				System.out.print(String.format("%c\nASCII code =? ", n, n));
			} else {
				break;
			}
		}

//		
//		bw.write(sb.toString());
//		bw.flush();
	}

}