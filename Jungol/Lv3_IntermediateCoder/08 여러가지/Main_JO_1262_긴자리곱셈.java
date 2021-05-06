import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1262_긴자리곱셈 { // 제출일 2021-05-06 23:00

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		String n = " ";
		String m = " ";
		String s = br.readLine();
		int negative = 0;
		int nlen = 0;
		int mlen = 0;
		int[] num;
		while (s.charAt(0) != '0') {
			st = new StringTokenizer(s);
			n = st.nextToken();
			m = st.nextToken();

			negative = 1;
			if (n.charAt(0) == '-') {
				negative *= -1;
				n = n.substring(1);
			} else if (n.charAt(0) == '0') {
				sb.append(0).append('\n');
				s = br.readLine();
				continue;
			}
			if (m.charAt(0) == '-') {
				negative *= -1;
				m = m.substring(1);
			} else if (m.charAt(0) == '0') {
				sb.append(0).append('\n');
				s = br.readLine();
				continue;
			}

			nlen = n.length();
			mlen = m.length();
			num = new int[nlen + mlen];

			for (int i = 0; i < nlen; i++) {
				for (int j = 0; j < mlen; j++) {
					num[nlen - 1 - i + mlen - 1 - j] += (n.charAt(i) - '0') * (m.charAt(j) - '0');
				}
			}

			if (negative == -1) {
				sb.append('-');
			}
			sb.append(calc(num)).append('\n');

			s = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static String calc(int[] num) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < num.length-1; i++) {
			num[i + 1] += num[i] / 10;
			num[i] %= 10;
		}

		int idx = num.length;
		while (num[--idx] == 0) {
			// 00123456 일 경우 앞의 00을 제거하고 리턴
		}
		for (int i = idx; i >= 0; i--) {
			sb.append(num[i]);
		}

		return sb.toString();
	}

}