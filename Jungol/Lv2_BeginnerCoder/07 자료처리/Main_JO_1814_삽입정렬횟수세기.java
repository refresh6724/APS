import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1814_삽입정렬횟수세기 { // 제출일 2021-03-26 23:06

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
		insertion_sort(arr);

	}

	private static void insertion_sort(int[] arr) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			// i번째 값을 정렬된 i 이전 값들과 비교하면서 앞으로 보낸다
			int cmp = arr[i];
			int cmpIdx = 0;
			for (cmpIdx = i - 1; cmpIdx >= 0 && arr[cmpIdx] > cmp; cmpIdx--) {
				arr[cmpIdx + 1] = arr[cmpIdx];
				cnt++;
			}
			arr[cmpIdx + 1] = cmp;
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
	}
}