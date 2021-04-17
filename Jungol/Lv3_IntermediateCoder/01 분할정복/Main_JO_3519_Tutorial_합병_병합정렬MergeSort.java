import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3519_Tutorial_합병_병합정렬MergeSort { // 제출일 2021-04-17 23:28

	static int n;
	static int[] arr, temp;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // 10 이상 1천 이하
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 0 이상 10만 이하
		}
		temp = new int[n];
		sb = new StringBuilder();

	}

	private static void go() {
		// 합병정렬의 매 과정에서 복사 단계 이후 전체 A[]의 상태를 행단위로 출력한다.

		mergeSort(0, n - 1);
	}

	private static void mergeSort(int low, int high) {
		// 1. base condition
		if (low >= high) {
			return;
		}

		// 2. divide
		int mid = (low + high) / 2;

		// 3. conquer
		mergeSort(low, mid);
		mergeSort(mid + 1, high);

		// 4. merge
		int left = low;
		int right = mid + 1;
		for (int t = low; t <= high; t++) {
			if (right > high) {
				temp[t] = arr[left++];
			} else if (left > mid) {
				temp[t] = arr[right++];
			} else if (arr[left] <= arr[right]) {
				temp[t] = arr[left++];
			} else {
				temp[t] = arr[right++];
			}
		}

		// 5. copy
		for (int i = low; i <= high; i++) {
			arr[i] = temp[i];
		}

		// 6. print
		print();
	}

	private static void print() {
		sb.append(arr[0]);
		for (int i = 1; i < n; i++) {
			sb.append(' ').append(arr[i]);
		}
		sb.append('\n');
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();
	}

}