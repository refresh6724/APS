import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_587_자가진단1 { // 제출일 2021-01-26 01:01

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 20 이하의 자연수 N을 입력받아 재귀함수를 이용해서 문자열 “recursive”를 N번 출력하는 프로그램을 작성하시오.

		int n = Integer.parseInt(br.readLine());

		recur(n);

//		bw.write(sb.toString().trim());
//		bw.flush();
	}

	private static void recur(int n) {
		if (n == 0) {
			return;
		}
		System.out.println("recursive");
		recur(n - 1);
	}

}