import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_625_자가진단7 { // 제출일 2021-02-10 23:54

	static class TmpClass {
		int[] a;

		public TmpClass() {

		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				sb.append(a[i]).append(' ');
			}
			return sb.toString().trim();
		}

		public void makeArr(int n) {
			this.a = new int[n];
		}

		public void reverseSort() {
			this.a = Arrays.stream(this.a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 배열의 크기를 입력받아 입력받은 크기만큼 배열에 정수를 입력받고
		// 내림차순으로 정렬하여 출력하는 프로그램을 작성하시오.

		// Java에는 Call by Value만 존재한다
		// 참조 ) http://blog.devez.net/117

		TmpClass tmpClass = new TmpClass();
		tmpClass.makeArr(Integer.parseInt(br.readLine()));
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tmpClass.a.length; i++) {
			tmpClass.a[i] = Integer.parseInt(st.nextToken());
		}
		tmpClass.reverseSort();
		sb.append(tmpClass);

		bw.write(sb.toString());
		bw.flush();
	}

}