import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1009_각자리수의역과합NumberReverse { // 제출일 2021-03-03 23:10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] a = br.readLine().toCharArray();
		char[] b;
		while (a[0] != '0') {
			int sum = 0;
			b = new char[a.length];
			for (int i = a.length - 1; i >= 0; i--) {
				sum += a[i] - '0';
				b[a.length - 1 - i] = a[i];
			}
			sb.append(Integer.valueOf(String.valueOf(b))).append(' ').append(sum).append('\n');
			a = br.readLine().toCharArray();
		}

		bw.write(sb.toString());
		bw.flush();
	}

}