import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_180_형성평가6 { // 제출일 2021-01-24 23:48

	static int[] arr = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 자료의 개수 7을 매크로 상수로 정의하여
		// 자료의 개수만큼 정수를 입력받아
		// 입력받은 순서대로 앞에서부터 마지막까지 가면서 바로 뒤의 숫자와 비교하여 크면 교환한다.
		// 이러한 작업을 세 번만 반복한 후
		// 그 결과를 하나의 행에 공백으로 구분하여 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 7; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			do_it();
		}

		for (int i = 0; i < 7; i++) {
			sb.append(arr[i]).append(' ');
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void do_it() {
		// 입력받은 순서대로?
		// 앞에서부터 마지막까지 가면서?
		// 바로 뒤의 숫자와 비교하여 크면 교환한다??
		for (int i = 0; i < 7 - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}
	}

}