import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_193_형성평가5 { // 제출일 2021-02-06 22:43

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5개의 단어(각 단어는 100자 이하)를 입력받은 후
		// 문자와 문자열(100자 이하)을 한 개씩 입력받아
		// 나중에 입력받은 문자나 문자열이 포함된 단어를 모두 출력하는 프로그램을 작성하시오.
		// 찾는 단어가 없으면 “none”이라고 출력한다.

		String[] arr = new String[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		String a = br.readLine();
		String b = br.readLine();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(a) || arr[i].contains(b)) {
				cnt++;
				sb.append(arr[i]).append('\n');
			}
		}
		if (cnt == 0) {
			sb.append("none");
		}

		bw.write(sb.toString());
		bw.flush();
	}

}