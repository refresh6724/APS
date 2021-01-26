import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_592_자가진단4 { // 제출일 2021-01-26 01:12

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 9자리 이하의 자연수를 입력받아 재귀함수를 이용하여
		// 각 자리 숫자의 제곱의 합을 출력하는 프로그램을 작성하시오.
		// ( main()함수에 변수 하나, 재귀함수에 매개변수 하나만을 사용할 수 있다.)

		int n = Integer.parseInt(br.readLine());

		sb.append(square_sum(n));

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static int square_sum(int n) {
		if (n == 0) {
			return 0;
		}
		int a = n % 10;
		return square_sum(n / 10) + a * a;
	}

}