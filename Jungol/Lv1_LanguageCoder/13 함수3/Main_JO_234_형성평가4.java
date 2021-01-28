import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_234_형성평가4 { // 제출일 2021-01-28 23:05

	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 첫 번째는 1, 두 번째는 2,
		// 세 번째부터는 앞의 두 수의 곱을 100으로 나눈 나머지로 이루어진 수열이 있다.
		// 100 이하의 자연수 N을 입력받아 재귀함수를 이용하여 N번째 값을 출력하는 프로그램을 작성하시오.

		// 8
		// 92
		// 1 2 2 4 8 32 56 92 ...

		int a = Integer.parseInt(br.readLine());
		if (a == 1) {
			System.out.println(1);
		} else if (a == 2) {
			System.out.println(2);
		} else {
			recur(1, 2, 3, (1 * 2) % 100, a);
		}

//		bw.write(sb.toString());
//		bw.flush();
	}

	private static void recur(int i, int j, int step, int k, int n) {
		if (step == n) {
			System.out.println(k);
			return;
		}
		recur(j, k, step + 1, (j * k) % 100, n);
	}

}