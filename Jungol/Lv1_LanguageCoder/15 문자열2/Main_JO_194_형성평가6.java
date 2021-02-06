import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_194_형성평가6 { // 제출일 2021-02-06 23:39

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 개의 문자열 A와 B 한 개의 정수 n을 입력받아서 A에 B를 연결하고,
		// 변경된 문자열 A에서 n개의 문자를 B에 복사한 후
		// A와 B를 출력하는 프로그램을 작성하시오. (1≤n,A,B≤100)

		st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		a = a.concat(b);
		sb.append(a).append('\n');
		sb.append(a.substring(0, n));
		if (b.length() > n) {
			sb.append(b.substring(n));
		}

		bw.write(sb.toString());
		bw.flush();
	}

}