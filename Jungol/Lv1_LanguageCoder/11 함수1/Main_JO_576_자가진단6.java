import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_576_자가진단6 { // 제출일 2021-01-22 23:44

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		char pmmd = st.nextToken().charAt(0);
		int b = Integer.parseInt(st.nextToken());

		sb.append(String.format("%d %c %d = %d", a, pmmd, b, calc(pmmd, a, b)));

		bw.write(sb.toString());
		bw.flush();
	}

	private static int calc(char pmmd, int a, int b) {
		if (pmmd == '+') {
			return a + b;
		} else if (pmmd == '-') {
			return a - b;
		} else if (pmmd == '*') {
			return a * b;
		} else if (pmmd == '/') {
			return a / b;
		} else {
			return 0;
		}
	}

}