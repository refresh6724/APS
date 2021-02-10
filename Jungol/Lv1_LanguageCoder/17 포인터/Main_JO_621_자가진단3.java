import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_621_자가진단3 { // 제출일 2021-02-10 23:37

	static class TmpClass {
		int a;
		int b;

		public TmpClass() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%d + %d = %d\n", a, b, a + b));
			sb.append(String.format("%d - %d = %d\n", a, b, a - b));
			sb.append(String.format("%d * %d = %d\n", a, b, a * b));
			sb.append(String.format("%d / %d = %d\n", a, b, a / b));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 포인터 변수 두 개를 이용하여 두 수를 입력받고
		// 사칙 연산을 수행하여 출력하는 프로그램을 작성하시오.
		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		st = new StringTokenizer(br.readLine());
		tmpClass.a = Integer.parseInt(st.nextToken());
		tmpClass.b = Integer.parseInt(st.nextToken());
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}