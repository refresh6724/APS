import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3106_진법변환 { // 제출일 2021-03-10 23:27

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		while (str.length() != 1) {
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken()); // 2~36진법 (0에서 'Z'까지)
			String n = st.nextToken(); // 2^63-1 이하 정수 == Long.MAX_VALUE
			int b = Integer.parseInt(st.nextToken()); //
			if(n.equals("0")) {
				sb.append(0).append('\n');
			} else {
				sb.append(change(toTen(a, n), b)).append('\n');				
			}
			str = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static long toTen(int a, String n) {
		// for 문을 사용하여 끝자리에서 되짚어 나가면 a^idx 계산이 추가로 필요하게 된다
		// Horner 알고리즘을 사용하여 해당 계산을 없앤다
		long sum = 0;
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) >= 'A') {
				sum = sum * a + (n.charAt(i) - 'A' + 10);
			} else {
				sum = sum * a + (n.charAt(i) - '0');
			}
		}
		return sum;
	}

	private static String change(long n, int b) {
		StringBuilder sb = new StringBuilder();

		long mok = n;
		int nam = 0;
		while (mok != 0) {
			nam = (int) (mok % b);
			mok = mok / b;
			if (nam < 10) {
				sb.insert(0, nam);
			} else {
				sb.insert(0, (char) (nam + 'A' - 10));
			}
		}

		return sb.toString();
	}

}