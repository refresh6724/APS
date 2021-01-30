import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_182_형성평가1 { // 제출일 2021-01-30 23:35

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 영문자 두 개를 입력 받아서 각각의 아스키코드의 합과 차를 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		int a = st.nextToken().charAt(0);
		int b = st.nextToken().charAt(0);
		sb.append(String.format("%d %d", a + b, Math.abs(a - b)));
		bw.write(sb.toString());
		bw.flush();
	}

}