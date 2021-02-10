import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_623_자가진단5 { // 제출일 2021-02-10 23:44

	static class TmpClass {
		double[] a;

		public TmpClass() {
			a = new double[5];
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				sb.append(String.format("%.1f ", this.a[i]));
			}
			return sb.toString().trim();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 실수 5개를 원소로 하는 배열을 선언하고
		// 포인터 변수를 이용하여 입력과 출력을 실행하는 프로그램을 작성하시오
		// 출력은 반올림하여 소수 첫째자리까지 출력하는 것으로 한다.
		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			tmpClass.a[i] = Double.parseDouble(st.nextToken());
		}
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}