import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_179_형성평가5 { // 제출일 2021-01-24 23:42

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 세 개의 실수를 입력받아
		// 합계와 평균을 구하여 평균을 반올림한 정수를 출력하고,
		// 다음은 입력받은 수를 각각 먼저 반올림한 후
		// 합계와 평균을 구하여 평균을 반올림한 한 결과를 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());

		sb.append(median(a, b, c));
		sb.append('\n');
		sb.append(median(Math.round(a), Math.round(b), Math.round(c)));
		bw.write(sb.toString());
		bw.flush();
	}

	private static int median(double a, double b, double c) {
		double sum = a + b + c;
		return (int) Math.round(sum / 3);
	}

}