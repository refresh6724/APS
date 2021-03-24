import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1146_선택정렬 { // 제출일 2021-03-24 23:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 단계별 출력
		for (int i = 0; i < n - 1; i++) {
			int min = arr[i];
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIdx = j;
				}
			}
			int tmp = min;
			arr[minIdx] = arr[i];
			arr[i] = tmp;
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