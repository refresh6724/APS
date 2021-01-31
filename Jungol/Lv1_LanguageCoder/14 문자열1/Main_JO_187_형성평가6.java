import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_187_형성평가6 { // 제출일 2021-01-31 18:59

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자열(100자 이하)을 입력받은 후 정수를 입력받아 해당위치의 문자를 제거하고 출력하는 작업을 반복하다가 문자 1개가 남으면 종료하는
		// 프로그램을 작성하시오.
		// 첫 번째 문자의 위치는 1이며 만약 입력받은 번호가 문자열의 길이 이상이면 마지막 문자를 제거한다.
		// * 입출력예에서 진한글씨가 출력

		// word
		// 3
		// 1
		// 10

		// wod
		// od
		// o

		char[] a = br.readLine().toCharArray();
		char[] b = new char[100];
		while (a.length != 1) {
			int idx = Integer.parseInt(br.readLine());
			b = new char[a.length - 1];
			if (idx > a.length) {
				for (int i = 0; i < b.length; i++) {
					b[i] = a[i];
				}
			} else {
				for (int i = 0; i < idx - 1; i++) {
					b[i] = a[i];
				}
				for (int i = idx; i < a.length; i++) {
					b[i - 1] = a[i];
				}
			}
			a = b.clone();
			System.out.println(a);
		}

//		bw.write(sb.toString());
//		bw.flush();
	}

}