import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_523_자가진단6 { // 제출일 2021-01-02 23:12

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(String.format("%d > %d --- %s", a, b, ((a > b) ? "true" : "false")));
		System.out.println(String.format("%d < %d --- %s", a, b, ((a < b) ? "true" : "false")));
		System.out.println(String.format("%d >= %d --- %s", a, b, ((a >= b) ? "true" : "false")));
		System.out.println(String.format("%d <= %d --- %s", a, b, ((a <= b) ? "true" : "false")));

	}

}