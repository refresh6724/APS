import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_575_자가진단5 { // 제출일 2021-01-22 23:40

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int base = Integer.parseInt(st.nextToken());
		int exp = Integer.parseInt(st.nextToken());

		sb.append(calc(base, exp));

		bw.write(sb.toString());
		bw.flush();
	}

	private static int calc(int base, int exp) {
		int ret = 1;
		for (int i = 0; i < exp; i++) {
			ret *= base;
		}
		return ret;
	}

}