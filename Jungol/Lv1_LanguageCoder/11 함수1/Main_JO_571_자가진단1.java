import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_571_자가진단1 { // 제출일 2021-01-22 23:29

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			print();
		}
		// bw.write(sb.toString());
		// bw.flush();
	}

	private static void print() {
		System.out.println("~!@#$^&*()_+|");

	}

}