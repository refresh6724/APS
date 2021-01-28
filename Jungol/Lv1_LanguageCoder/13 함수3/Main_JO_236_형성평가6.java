import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_236_형성평가6 { // 제출일 2021-01-28 23:11

	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 3자리로 이루어진 자연수 3개를 입력받아 그 수들의 곱을 구한 후
		// 그 결과값의 각 자리 숫자들중 0을 제외한
		// 모든 수들의 곱을 구하여 출력하는 프로그램을 재귀함수로 작성하시오.

		// 100 123 111
		// 270
		// 입력예제의 세 수의 곱은 1365300이다.
		// 그러므로 1 * 3 * 6 * 5 * 3 = 270
		// 1의 자리수 * 1의 자리를 제외한 남은 자리수의 곱
		// (단 1의 자리수가 0이면 1로 바꾸어서 곱한다.)

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		recur(a * b * c, 1);

//		bw.write(sb.toString());
//		bw.flush();
	}

	private static void recur(int n, int i) {
		if (n == 0) {
			System.out.println(i);
			return;
		}
		recur(n / 10, i * ((n % 10 == 0) ? 1 : (n % 10)));
	}

}