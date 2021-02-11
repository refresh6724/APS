import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_203_형성평가4 { // 제출일 2021-02-11 23:10

	static int[] arr = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 10개의 원소를 저장할 수 있는 배열을 선언한 후
		// 포인터 변수를 이용하여 자료를 입력받아
		// 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.

		int odd = 0;
		int even = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		sb.append(String.format("odd : %d\n", odd));
		sb.append(String.format("even : %d\n", even));

		bw.write(sb.toString());
		bw.flush();
	}

}