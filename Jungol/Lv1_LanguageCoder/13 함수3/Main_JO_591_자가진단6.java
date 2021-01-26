import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_591_자가진단6 { // 제출일 2021-01-26 17:28

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 첫 번째 수는 1이고 N번째 수는 (N/2)번째 수(파이썬인경우 N//2번째)와
		// (N-1)번째 수의 합으로 구성된 수열이 있다.
		// 50 이하의 자연수 N을 입력받아 재귀호출을 이용하여
		// 이 수열에서 N번째 수를 출력하는 프로그램을 작성하시오.
		// (1 2 3 5 7 10 13 18 …)

		// 8
		// 18
		// 8번째 수는 4번째(8/2) 수인 5와 7번째(8-1) 수인 13의 합이다.

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i / 2] + arr[i - 1];
		}
		sb.append(arr[n]);
		bw.write(sb.toString().trim());
		bw.flush();
	}

}