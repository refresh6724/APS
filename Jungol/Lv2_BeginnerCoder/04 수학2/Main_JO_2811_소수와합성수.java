import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2811_소수와합성수 { // 제출일 2021-03-03 23:30

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a < 2) {
				sb.append("number one\n");
			} else if (isPrime(a)) {
				sb.append("prime number\n");
			} else {
				sb.append("composite number\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static boolean isPrime(int a) {
		for (int i = 2; i <= a / i; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}