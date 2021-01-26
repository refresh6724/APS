import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_232_형성평가2 { // 제출일 2021-01-26 23:03

	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 자연수 N을 입력받아 N이 홀수인 경우에는 1부터 N까지의 홀수를 짝수인 경우는 2부터 N까지의 짝수를 모두 출력하는 프로그램을 재귀함수로
		// 작성하시오.

		n = Integer.parseInt(br.readLine());
		int num = 0;
		if (n % 2 == 0) {
			num = 2;
		} else {
			num = 1;
		}
		while (num != n) {
			sb.append(num).append(' ');
			num += 2;
		}
		sb.append(num);
		bw.write(sb.toString().trim());
		bw.flush();
	}

}