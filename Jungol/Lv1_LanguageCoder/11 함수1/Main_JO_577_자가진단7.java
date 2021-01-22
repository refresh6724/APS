import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_577_자가진단7 { // 제출일 2021-01-22 23:47

	static int a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		divide_and_multiply();
		sb.append(a).append(' ').append(b);
		bw.write(sb.toString());
		bw.flush();
	}

	private static void divide_and_multiply() {
		if (a > b) {
			a /= 2;
			b *= 2;
		} else {
			a *= 2;
			b /= 2;
		}

	}

}