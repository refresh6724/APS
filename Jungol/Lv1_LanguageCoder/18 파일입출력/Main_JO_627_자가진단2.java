import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_627_자가진단2 { // 제출일 2021-02-12 23:35

	public static void main(String[] args) throws IOException {

		// 10개의 실수를 입력받아 첫 번째 입력 값과 마지막 입력 값의 평균을 반올림하여, 
		// 소수 첫째자리까지 출력하는 프로그램을 작성하시오.
		// * 표준입출력방식으로 작성하세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[arr.length - 1]);

		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%.1f", (a + b) / 2));

		bw.write(sb.toString());
		bw.flush();
	}

}