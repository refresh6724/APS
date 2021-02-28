import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1692_곱셈 { // 제출일 2021-02-28 19:11

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		sb.append(a * (b % 10)).append('\n');
		sb.append(a * ((b % 100) / 10)).append('\n');
		sb.append(a * (b / 100)).append('\n');
		sb.append(a * b);

		bw.write(sb.toString());
		bw.flush();
	}

}