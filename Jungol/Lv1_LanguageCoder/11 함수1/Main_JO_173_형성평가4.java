import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_173_형성평가4 { // 제출일 2021-01-21 22:16

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 개의 음이 아닌 정수를 입력받아 큰 수의 제곱에서 작은 수의 제곱을 뺀 결과값을
		// 출력하는 프로그램을 작성하시오.
		// (두 정수를 전달받아 제곱의 차를 리턴하는 함수를 이용할 것)

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		System.out.println(square_diff(a, b));

	}

	private static int square_diff(int a, int b) {
		if (a > b) {
			return a * a - b * b;
		} else {
			return b * b - a * a;
		}
	}

}