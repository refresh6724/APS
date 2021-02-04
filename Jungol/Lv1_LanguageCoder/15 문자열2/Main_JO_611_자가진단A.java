import java.io.*;
import java.util.*;

public class Main_JO_611_자가진단A { // 제출일 2021-02-04 23:23

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 20자 이하인 한 개의 문자열을 입력받아서
		// 첫 줄에는 정수로 변환하여 2배한 값을 출력하고,
		// 다음 줄에는 실수로 변환한 값을 반올림하여
		// 소수 둘째자리까지 출력하는 프로그램을 작성하시오.

		// 50.1*34
		// 100
		// 50.10

		// 규칙이 없다?

		char[] s = br.readLine().toCharArray();
		boolean dot = false;
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= '0' && s[i] <= '9') {
				sb.append(s[i]);
			} else if (s[i] == '.') {
				if (!dot) {
					dot = true;
					sb.append('.');
				} else {
					break;
				}
			} else {
				break;
			}
		}
		double a = Double.parseDouble(sb.toString());
		sb = new StringBuilder();
		sb.append((int) (a * 2)).append('\n');
		sb.append(String.format("%.2f", a));

		bw.write(sb.toString());
		bw.flush();
	}

}