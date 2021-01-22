import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_572_자가진단2 { // 제출일 2021-01-22 23:32

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		print_circle_area(n);
		// bw.write(sb.toString());
		// bw.flush();
	}

	private static void print_circle_area(int radius) {
		System.out.println(String.format("%.2f", 3.14 * radius * radius));
	}

}