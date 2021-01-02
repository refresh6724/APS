import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_522_자가진단5 { // 제출일 2021-01-02 23:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if (a == b) {
			System.out.println("true");
			System.out.println("false");
		} else {
			System.out.println("false");
			System.out.println("true");
		}

	}

}