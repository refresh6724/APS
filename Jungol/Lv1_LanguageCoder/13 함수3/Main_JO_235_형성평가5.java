import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_235_형성평가5 { // 제출일 2021-01-28 23:07

	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 100만 이하의 자연수 N을 입력받아 짝수이면 2로 홀수이면 3으로 나누는 작업을 반복하다가
		// 그 값이 1이 되면 그때까지 나누었던 작업의 횟수를 출력하는 프로그램을 재귀함수로 작성하시오.

		// 100
		// 6
		// 100 → 50 → 25 → 8 → 4 → 2 → 1 횟수(level)도 함께 전달하고 n이 1이면 level을 출력하면 된다.
		// 함수(n/2 또는 n/3 level+1)

		int n = Integer.parseInt(br.readLine());
		recur(n, 0);

//		bw.write(sb.toString());
//		bw.flush();
	}

	private static void recur(int n, int i) {
		if (n == 1) {
			System.out.println(i);
			return;
		}
		recur((n % 2 == 0) ? (n / 2) : (n / 3), i + 1);
	}

}