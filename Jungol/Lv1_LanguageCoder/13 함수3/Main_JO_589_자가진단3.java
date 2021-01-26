import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_589_자가진단3 { // 제출일 2021-01-26 01:09

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 100 이하의 자연수 N을 입력받아 재귀함수를 이용하여 1부터 N까지의 합을 구하는 프로그램을 작성하시오.

		int n = Integer.parseInt(br.readLine());

		sb.append(recur(n, 0));

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static int recur(int n, int sum) {
		if (n == 0) {
			return sum;
		}
		return recur(n - 1, sum + n);
	}

}