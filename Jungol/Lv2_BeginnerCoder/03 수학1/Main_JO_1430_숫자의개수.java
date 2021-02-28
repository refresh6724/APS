import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1430_숫자의개수 { // 제출일 2021-02-28 19:15

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] arr = new int[10];

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int d = a * b * c;
		while (d != 0) {
			arr[d % 10]++;
			d /= 10;
		}

		for (int i = 0; i < 10; i++) {
			sb.append(arr[i]).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}