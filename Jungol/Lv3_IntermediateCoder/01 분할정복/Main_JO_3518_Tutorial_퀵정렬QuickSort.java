import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3518_Tutorial_퀵정렬QuickSort { // 제출일 2021-04-15 23:18

	// 퀵소트는 토니 호어(찰스 엔터니 리처드 호어 - Charles Antony Richard Hoare)가 개발한 알고리즘이다.
	// 원소들간의 비교와 교환을 통하여 정렬하는 비교기반정렬 알고리즘이다.
	// 원소들 중에 같은 값이 있는 경우 정렬후에 이들의 순서가 달라질 수 있어 불안정 정렬에 속한다.
	// N개의 데이터를 정렬할 때, ​시간복잡도는 ​평균 O(N * logN), 최악의 경우 O(N2) 이 소요된다.
	// 매 단계에서 적어도 1개의 원소가 자기 자리를 찾게 되므로 이후 정렬할 개수가 줄어든다.
	// 분할정복 알고리즘 중 하나로 합병정렬과는 다르게 비대칭 분할이 이루어지며 분할과 정복 과정은 있으나 합병과정이 없다.

	static int n;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void go() {

		// 퀵소트의 각 재귀호출에서 분할과정 이후 배열전체를 행으로 구분하여 출력한다.

		quickSort(0, n - 1);

	}

	private static void quickSort(int low, int high) {

		// divide
		if (low < high) {
			int i = low - 1;
			int pivot = arr[high];
			for (int j = low; j < high; j++) {
				if (arr[j] < pivot) {
					swap(++i, j);
				}
			}
			// pivot 자리 찾기
			swap(++i, high);

			// 문제 요구
			print();

			// conquer
			quickSort(low, i - 1);
			quickSort(i + 1, high);
		}
	}

	private static void print() {
		StringBuilder curr = new StringBuilder();
		curr.append(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			curr.append(' ').append(arr[i]);
		}
		sb.append(curr.toString()).append('\n');
	}

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();
	}

}