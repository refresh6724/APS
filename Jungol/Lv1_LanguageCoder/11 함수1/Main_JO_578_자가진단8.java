import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_578_자가진단8 { // 제출일 2021-01-22 23:53

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		multiplication_table(a, b);

		bw.write(sb.toString());
		bw.flush();
	}

	private static void multiplication_table(int a, int b) {
		int start = a;
		int end = b;
		if (start > end) {
			start = b;
			end = a;
		}

		for (int i = start; i <= end; i++) {
			table(i);
		}

	}

	private static void table(int i) {
		sb.append(String.format("== %ddan ==\n", i));
		for (int j = 1; j <= 9; j++) {
			sb.append(String.format("%d * %d = %2d\n", i, j, i * j));
		}
		sb.append('\n');
	}

}