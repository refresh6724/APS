import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1157_버블정렬 { // 제출일 2021-03-26 23:03

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 삽입정렬
		bubble_sort(arr);

	}

	private static void bubble_sort(int[] arr) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int end = arr.length - 1; end >= 1; end--) {

			for (int start = 0; start < end; start++) {
				if (arr[start] > arr[start + 1]) {
					int tmp = arr[start];
					arr[start] = arr[start + 1];
					arr[start + 1] = tmp;
				}
			}
			sb.append(print(arr));
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static String print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			sb.append(' ').append(arr[i]);
		}
		sb.append('\n');
		return sb.toString();
	}

}