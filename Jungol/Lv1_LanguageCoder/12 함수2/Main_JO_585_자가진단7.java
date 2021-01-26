import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_585_자가진단7 { // 제출일 2021-01-26 00:47

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 10개의 정수를 입력받아
		// 버블정렬로 내림차순 정렬을 하면서
		// 하나의 단계가 끝날 때마다
		// 그 정렬결과를 출력하는 프로그램을 작성하시오.

		int[] arr = new int[10];
		// 15 93 26 8 43 10 25 88 75 19
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int end = 10 - 1; end >= 1; end--) {
			// 가장 작은 수를 찾아 맨 마지막에 갖다 놓는다
			for (int start = 0; start < end; start++) {
				if (arr[start] < arr[start + 1]) {
					int tmp = arr[start];
					arr[start] = arr[start + 1];
					arr[start + 1] = tmp;
				}
			}
			sb.append(arr[0]);
			for (int i = 1; i < 10; i++) {
				sb.append(' ').append(arr[i]);
			}
			sb.append('\n');
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}
}