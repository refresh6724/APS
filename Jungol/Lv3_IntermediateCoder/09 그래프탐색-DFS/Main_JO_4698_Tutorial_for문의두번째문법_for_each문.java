import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main_JO_4698_Tutorial_for문의두번째문법_for_each문 { // 제출일 2021-04-22 23:12

	// 크기 26의 문자형 배열을 선언하고
	// 고전문법으로 A~Z를 입력하고
	// for-each문으로 출력하라

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[] arr = new char[26];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ('A' + i);
		}
		for (char el : arr) {
			sb.append(el).append(' ');
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

}