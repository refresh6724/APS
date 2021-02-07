import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_237_형성평가9 { // 제출일 2021-02-07 23:25

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수, 실수, 문자열을 차례로 입력받아서
		// 새로운 문자열에 출력한 후 전체의 길이를 2등분하여 출력하는 프로그램을 작성하시오.
		// 실수는 반올림하여 소수 셋째자리까지 출력하는 것으로 하고,
		// 새로운 문자열의 길이가 홀수일 때는 첫 번째 줄에 한 개를 더 출력한다.
		// 각 문자열의 길이는 30자 이내이다.

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		String c = st.nextToken();
		sb.append(a).append(String.format("%.3f", b)).append(c);
		int len = sb.length();
		sb.insert((len + 1) / 2, '\n');

		bw.write(sb.toString());
		bw.flush();
	}

}