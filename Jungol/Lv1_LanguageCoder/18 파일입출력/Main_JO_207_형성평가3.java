import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_207_형성평가3 { // 제출일 2021-02-14 20:48

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 정수와 한 개의 연산자(+, -, *, /, %)를 입력 받아
		// 입력 순서대로 계산하는 계산식을 출력하시오.

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		char c = st.nextToken().charAt(0);
		switch (c) {
		case '+':
			sb.append(String.format("%d + %d = %d", a, b, a + b));
			break;

		case '-':
			sb.append(String.format("%d - %d = %d", a, b, a - b));
			break;

		case '*':
			sb.append(String.format("%d * %d = %d", a, b, a * b));
			break;

		case '/':
			sb.append(String.format("%d / %d = %d", a, b, a / b));
			break;

		case '%':
			sb.append(String.format("%d %% %d = %d", a, b, a % b));
			break;
		}

		bw.write(sb.toString());
		bw.flush();
	}

}