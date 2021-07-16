import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1190_모두더하기 { // 제출일 2021-07-16 23:21

	static int n;

	static class MyMinHeap {
		static int[] heapArr;
		static int heapSize;

		public MyMinHeap() {
			// TODO Auto-generated constructor stub
		}

		public MyMinHeap(int s) {
			heapArr = new int[s + 1];
			heapSize = 0;
		}

		public void push_heap(int num) {
			heapArr[++heapSize] = num;
			for (int child = heapSize; child > 1 && heapArr[child] < heapArr[child / 2]; child /= 2) {
				int tmp = heapArr[child];
				heapArr[child] = heapArr[child / 2];
				heapArr[child / 2] = tmp;
			}
		}

		public int pop_heap() {
			int ret = heapArr[1];
			heapArr[1] = heapArr[heapSize];
			heapArr[heapSize--] = ret;

			int parent = 1;
			int child = 2;
			while (child <= heapSize) {
				if (child < heapSize && heapArr[child + 1] < heapArr[child]) {
					child++;
				}
				if (heapArr[parent] <= heapArr[child]) {
					break;
				}

				int tmp = heapArr[parent];
				heapArr[parent] = heapArr[child];
				heapArr[child] = tmp;

				parent = child;
				child <<= 1;

			}
			return ret;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine().trim());
		MyMinHeap myheap = new MyMinHeap(n);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			myheap.push_heap(Integer.parseInt(st.nextToken()));
		}
		long tot = 0;
		for (int i = 0; i < n - 1; i++) {
			int plus = myheap.pop_heap() + myheap.pop_heap();
			tot += plus;
			myheap.push_heap(plus);
		}
		sb.append(tot);
		bw.write(sb.toString());
		bw.flush();
	}

}