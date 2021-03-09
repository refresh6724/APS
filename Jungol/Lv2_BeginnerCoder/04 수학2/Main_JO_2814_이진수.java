import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2814_이진수 { // 제출일 2021-03-09 23:27

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] a = br.readLine().toCharArray();
		int sum = 0;
		for (int idx = a.length - 1, two = 1; idx >= 0; idx--, two *= 2) {
			sum += (a[idx] - '0') * two;
		}
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
	}
}