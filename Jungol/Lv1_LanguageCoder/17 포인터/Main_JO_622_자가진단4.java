import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_622_자가진단4 { // 제출일 2021-02-10 23:42

	static class TmpClass {
		int[] a;

		public TmpClass() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				if (i % 2 == 0) {
					sb.append(this.a[i]).append(' ');
				}
			}
			return sb.toString().trim();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5개짜리 정수형 배열을 선언하고 포인터 변수에 저장한 후
		// 포인터 변수를 이용하여 입력을 받은 후 홀수번째 입력값을 출력하는 프로그램을 작성하시오.
		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		st = new StringTokenizer(br.readLine());
		tmpClass.a = new int[st.countTokens()];
		for (int i = 0; i < tmpClass.a.length; i++) {
			tmpClass.a[i] = Integer.parseInt(st.nextToken());
		}
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}