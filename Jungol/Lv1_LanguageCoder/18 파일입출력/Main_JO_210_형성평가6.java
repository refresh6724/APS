import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_210_형성평가6 { // 제출일 2021-02-15 22:46

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 100 이하의 정수를 입력받아 예와 같이 출력하시오.
		// ‘*’는 옆으로만 1칸의 공백으로 분리한다.

		// 1
		// *

		// 2
		//   *
		// * * *
		//   *

		// 3
		//     *
		//   * * *
		// * * * * *
		//   * * *
		//     *

		int n = Integer.parseInt(br.readLine());
		int x = n * 2 - 2;
		int a = 0;
		int b = 0;
		for (int i = 1; i < n * 2; i++) {
			a = Math.abs(n - i) * 2;
			for (int j = 0; j < a; j++) {
				sb.append(' ');
			}
			sb.append('*');
			b = x - a;
			for (int j = 0; j < b; j++) {
				sb.append(" *");
			}
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}