import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_178_형성평가4 { // 제출일 2021-01-24 23:37

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수 n을 입력받아 2^n의 값을 출력하는 프로그램을 작성하시오. (1 ≤ n ≤ 20)
		int n = Integer.parseInt(br.readLine());
		sb.append(base2(n));
		bw.write(sb.toString());
		bw.flush();
	}

	private static int base2(int n) {
		return 1 << n;
	}

}