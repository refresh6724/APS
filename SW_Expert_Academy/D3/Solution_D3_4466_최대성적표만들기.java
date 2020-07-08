import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_4466_최대성적표만들기 { // 제출일 2020-07-08 23:42 19,680 kb 116 ms

	static class MyHeap {
		public int[] heapArr = new int[129];
		public int heapIdx;

		public MyHeap() {

		}

		public void init() {
			heapIdx = 0;
		}

		public int size() {
			return heapIdx;
		}

		public void push(int data) {
			heapArr[++heapIdx] = data;
			int child = heapIdx;
			int parent = child >> 1;
			while (child > 1 && heapArr[parent] < heapArr[child]) {
				swap(parent, child);
				child = parent;
				parent = child >> 1;
			}
		}

		private void swap(int parent, int child) {
			int tmp = heapArr[parent];
			heapArr[parent] = heapArr[child];
			heapArr[child] = tmp;
		}

		public int pop() {
			if (heapIdx == 0) {
				return -1;
			} else if (heapIdx == 1) {
				heapIdx = 0;
				return heapArr[1];
			}

			int ret = heapArr[1];

			swap(1, heapIdx);
			heapIdx--;
			int parent = 1;
			int child = compare(parent);

			while (child <= heapIdx && heapArr[parent] < heapArr[child]) {
				swap(parent, child);
				parent = child;
				child = compare(parent);
			}

			return ret;
		}

		private int compare(int parent) {
			int left = parent << 1;
			int right = left + 1;
			if (right <= heapIdx) {
				if (heapArr[left] > heapArr[right]) {
					return left;
				} else {
					return right;
				}
			}
			return left;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		MyHeap myheap = new MyHeap();
		Reader s = new Reader();

//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
//		testcase: 
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			int N = s.nextInt();
			int K = s.nextInt();

			// N개 성적 중 상위 K개를 더한 값을 출력

			myheap.init();

			for (int i = 0; i < N; i++) {
				myheap.push(s.nextInt());
			}

			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += myheap.pop();
			}

			sb.append(sum).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	/**
	 * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	 */
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
	}

}