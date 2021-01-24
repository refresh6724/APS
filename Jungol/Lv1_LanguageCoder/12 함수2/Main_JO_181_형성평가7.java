import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_181_형성평가7 { // 제출일 2021-01-24 23:51

	static double pi = 3.141592;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 원주율을 3.141592로 매크로 상수로 정의하고
		// 원의 넓이를 구하는 매크로 함수를 작성하여
		// 반지름을 입력받아 원의 넓이를 출력하는 프로그램을 작성하시오.
		// (소수 넷째자리에서 반올림)

		System.out.print("radius : ");
		double r = Double.parseDouble(br.readLine());

		sb.append("area = ").append(String.format("%.3f", area(r)));

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static double area(double r) {
		return pi * r * r;
	}

}