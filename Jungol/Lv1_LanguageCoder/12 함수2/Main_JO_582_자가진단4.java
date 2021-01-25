import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_582_자가진단4 { // 제출일 2021-01-25 23:21

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 원의 넓이를 입력받아 반지름의 길이를 소수 둘째자리까지 출력하는 프로그램을 작성하시오.
		// 원의 넓이 = 반지름 * 반지름 * 3.14 식을 이용하시오.

		double area = Double.parseDouble(br.readLine());
		sb.append(String.format("%.2f", radius(area)));

		bw.write(sb.toString());
		bw.flush();
	}

	private static double radius(double area) {
		return Math.sqrt(area / 3.14);
	}
}