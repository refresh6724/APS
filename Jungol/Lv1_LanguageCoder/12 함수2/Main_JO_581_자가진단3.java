import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_581_자가진단3 { // 제출일 2021-01-25 23:18

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 개의 정수를 입력받아 절대값이 더 큰 수를 출력하고
		// 두 개의 실수를 입력받아 절대값이 작은 수를 출력하는 프로그램을 작성하시오.
		// 실수는 소수점 이하 2자리까지 출력한다.

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double c = Double.parseDouble(st.nextToken());
		double d = Double.parseDouble(st.nextToken());

		sb.append((Math.abs(a) > Math.abs(b)) ? a : b);
		sb.append('\n');
		sb.append(String.format("%.2f", (Math.abs(c) < Math.abs(d)) ? c : d));
		bw.write(sb.toString());
		bw.flush();
	}
}