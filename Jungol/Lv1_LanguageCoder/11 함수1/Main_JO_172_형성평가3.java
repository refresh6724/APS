import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_172_형성평가3 { // 제출일 2021-01-21 22:14

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 자연수를 입력받아 아래와 같은 사각형을 출력하는 프로그램을 작성하시오.
		// 주어지는 수는 100이하의 자연수이다.
		// 3
		// 1 2 3
		// 2 4 6
		// 3 6 9

		int n = Integer.parseInt(br.readLine());
		print_square(n);

	}

	private static void print_square(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
			for (int j = 2; j <= n; j++) {
				sb.append(' ').append(i * j);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}