import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_624_자가진단6 { // 제출일 2021-02-10 23:49

	static class TmpClass {
		double[] a;
		double sum;

		public TmpClass() {

		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				sb.append(String.format(" %.2f", this.a[i]));
			}
			sb.append(String.format("\nhap : %.2f", this.sum));
			sb.append(String.format("\navg : %.2f", this.sum / this.a.length));
			return sb.toString().trim();
		}

		public void makeArr(int n) {
			this.a = new double[n];
			this.sum = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 배열의 크기를 입력받아 입력받은 크기만큼 실수 배열을 생성하고
		// 배열의 원소를 입력받은 후 입력받은 자료 및 합과 평균을
		// 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.

		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		tmpClass.makeArr(Integer.parseInt(br.readLine()));
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tmpClass.a.length; i++) {
			double input = Double.parseDouble(st.nextToken());
			tmpClass.a[i] = input;
			tmpClass.sum += input;
		}
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}