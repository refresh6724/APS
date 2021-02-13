import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_630_자가진단5 { // 제출일 2021-02-13 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 100이하의 정수 N을 입력받은 후
		// 공백이 포함된 N행의 문장을 입력받아서 역순으로 출력하는 프로그램을 작성하시오.
		// 각 문장의 길이는 100이하이다.

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		for (int i = n - 1; i >= 0; i--) {
			sb.append(arr[i]).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}