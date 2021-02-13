import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_631_자가진단6 { // 제출일 2021-02-13 23:27

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 원의 둘레의 길이를 입력받아 반지름의 길이를 출력하는 프로그램을 작성하시오.
		// 단, 원주율은 3.14로 하고 출력은 소수 세째자리에서 반올림하여 둘째자리까지 출력 한다.
		// 둘레의 길이가 0 이면 종료한다.

		double a = Double.parseDouble(br.readLine());
		while (a != 0) {
			sb.append(String.format("%.2f\n", a / 3.14 / 2));
			a = Double.parseDouble(br.readLine());
		}

		bw.write(sb.toString());
		bw.flush();
	}

}