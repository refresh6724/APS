import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_620_자가진단2 { // 제출일 2021-02-10 23:35

	static class TmpClass {
		int num;

		public TmpClass() {
			// TODO Auto-generated constructor stub
		}

		public TmpClass(int num) {
			super();
			this.num = num;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.num / 10).append("...").append(this.num % 10);
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수형 포인터를 이용하여 값을 입력받고
		// 입력받은 값을 10으로 나눈 몫과 나머지를 출력하는 프로그램을 작성하시오.
		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		tmpClass.num = Integer.parseInt(br.readLine());
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}