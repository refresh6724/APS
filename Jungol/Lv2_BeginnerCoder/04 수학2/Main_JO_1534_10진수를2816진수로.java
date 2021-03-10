import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1534_10진수를2816진수로 { // 제출일 2021-03-10 22:38

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 10만 이하 자연수
		int b = Integer.parseInt(st.nextToken()); // 2, 8, 16

		sb.append(change(n, b));

		bw.write(sb.toString());
		bw.flush();
	}

	private static String change(int n, int b) {
		StringBuilder sb = new StringBuilder();

		// n 을 b 로 나눠 0이 될 때 까지
		// 2 / 16 ... 0
		// 2 / 8 ... 0
		// 2 / 4 ... 0
		// 2 / 2 ... 0
		// 2 / 1 ... 1

		int mok = n;
		int nam = 0;
		while (mok != 0) {
			nam = mok % b;
			mok = mok / b;
			if (nam < 10) {
				sb.insert(0, nam);
			} else if (nam == 10) {
				sb.insert(0, 'A');
			} else if (nam == 11) {
				sb.insert(0, 'B');
			} else if (nam == 12) {
				sb.insert(0, 'C');
			} else if (nam == 13) {
				sb.insert(0, 'D');
			} else if (nam == 14) {
				sb.insert(0, 'E');
			} else if (nam == 15) {
				sb.insert(0, 'F');
			}
		}

		return sb.toString();
	}

}