import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_216_형성평가8 { // 제출일 2021-02-07 22:55

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 한 개의 단어를 입력받아서
		// 거꾸로 뒤집어 출력하는 작업을 반복하다가
		// "END"라고 입력이 되면 종료하는 프로그램을 작성하시오.
		// 입력받는 단어의 길이는 20이하이다.

		String a = br.readLine();
		while (!a.equals("END")) {
			for (int i = a.length() - 1; i >= 0; i--) {
				sb.append(a.charAt(i));
			}
			sb.append('\n');
			a = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
	}

}