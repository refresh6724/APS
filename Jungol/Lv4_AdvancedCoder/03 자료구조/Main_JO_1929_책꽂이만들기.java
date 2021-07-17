import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1929_책꽂이만들기 { // 제출일 2021-07-17 23:50

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

		n = Integer.parseInt(br.readLine().trim());
		MyMinHeap myheap = new MyMinHeap(n);

		for (int i = 0; i < n; i++) { // 50000 * 20000 = 10 0000 0000, 10억
			int l = Integer.parseInt(br.readLine().trim());
			myheap.push_heap(l);
		}
		long ans = 0;
		for (int i = 0; i < n - 1; i++) {
			int s = myheap.pop_heap() + myheap.pop_heap();
			ans += s;
			myheap.push_heap(s);
		}
		System.out.println(ans);

	}

}