import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_586_자가진단8 { // 제출일 2021-01-26 00:52

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수 두 개를 입력받고
		// 계산식을 매크로 함수로 작성하여
		// 두 수의 차를 제곱한 값과 합을 세제곱한 값을 각각 출력하는 프로그램을 작성하시오.
		// ('^'는 연산자가 아니고 거듭제곱을 뜻하는 표시이므로 거듭제곱은 별도로 계산해야함)

		// 5 10
		// (5 - 10) ^ 2 = 25
		// (5 + 10) ^ 3 = 3375

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		sb.append(String.format("(%d - %d) ^ 2 = %d\n", a, b, square(a - b)));
		sb.append(String.format("(%d + %d) ^ 3 = %d\n", a, b, cube(a + b)));

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static int cube(int i) {
		return i * i * i;
	}

	private static int square(int i) {
		return i * i;
	}
}