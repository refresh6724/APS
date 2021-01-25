import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_579_자가진단1 { // 제출일 2021-01-25 23:07

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 10 이하의 자연수 n을 입력받고
		// n개의 정수를 입력받아 내림차순으로 정렬하여 출력하는 프로그램을 작성하시오.
		// (배열을 전달하는 함수를 이용한다.)

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] rev = reverse(arr);

		for (int i = 0; i < n; i++) {
			sb.append(rev[i]).append(' ');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int[] reverse(int[] arr) {
		Arrays.sort(arr);
		int[] ret = new int[arr.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = arr[arr.length - 1 - i];
		}
		return ret;
	}

}