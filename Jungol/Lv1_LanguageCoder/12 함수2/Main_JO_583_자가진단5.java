import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_583_자가진단5 { // 제출일 2021-01-25 23:45

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 세 개의 실수를 입력받아,
		// 가장 큰 수를 올림한 정수를 출력하고,
		// 가장 작은 수를 내림한 정수를 출력한 후,
		// 남은 수를 반올림한 정수를 출력하는 프로그램을 작성하시오.
		// 입력되는 실수는 -1000이상 1000이하이다.

		st = new StringTokenizer(br.readLine());
		double[] a = new double[3];
		for (int i = 0; i < a.length; i++) {
			a[i] = Double.parseDouble(st.nextToken());
		}
		Arrays.parallelSort(a);
		sb.append((int) Math.ceil(a[2])).append(' ');
		sb.append((int) Math.floor(a[0])).append(' ');
		sb.append((int) Math.round(a[1])).append(' ');

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static double radius(double area) {
		return Math.sqrt(area / 3.14);
	}
}