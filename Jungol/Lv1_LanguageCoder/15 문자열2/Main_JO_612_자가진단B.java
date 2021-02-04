import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_612_자가진단B { // 제출일 2021-02-04 23:39

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5개의 정수를 입력받아
		// 모두 붙여서 문자열로 저장한 후
		// 세 자씩 나누어서 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine(), " ");
		String s = "";
		for (int i = 0; i < 5; i++) {
			s = s.concat(st.nextToken());
		}
		int idx = 0;
		int cnt = 1;
		while (idx < s.length()) {
			sb.append(s.charAt(idx));
			if (cnt % 3 == 0) {
				sb.append('\n');
			}
			idx++;
			cnt++;
		}

		bw.write(sb.toString());
		bw.flush();
	}

}