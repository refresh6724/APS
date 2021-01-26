import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_588_자가진단2 { // 제출일 2021-01-26 01:07

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 자연수 N을 입력받아 재귀함수를 이용하여 N부터 1까지 차례대로 출력하는 프로그램을 작성하시오.
		// N은 50이하의 자연수이다.

		int n = Integer.parseInt(br.readLine());

		recur(n);

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void recur(int n) {
		if (n == 0) {
			return;
		}
		sb.append(n).append(' ');
		recur(n - 1);
	}

}