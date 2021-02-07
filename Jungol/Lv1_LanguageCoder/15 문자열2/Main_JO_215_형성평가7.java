import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_215_형성평가7 { // 제출일 2021-02-07 22:45

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		StringTokenizer st;

		// 두 개의 문자열을 입력받아 앞에서부터
		// 정수로 변환 가능한 부분을 변환한 후 두 수의 곱을 출력하는 프로그램을 작성하시오.
		// 각 문자열의 길이는 100이하이다.

		st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();

		sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			if (Character.isDigit(a[i])) {
				sb.append(a[i]);
			} else {
				break;
			}
		}
		int aa = Integer.valueOf(sb.toString());
		sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			if (Character.isDigit(b[i])) {
				sb.append(b[i]);
			} else {
				break;
			}
		}
		int bb = Integer.valueOf(sb.toString());
		sb = new StringBuilder();
		sb.append(aa * bb);
		bw.write(sb.toString());
		bw.flush();
	}

}