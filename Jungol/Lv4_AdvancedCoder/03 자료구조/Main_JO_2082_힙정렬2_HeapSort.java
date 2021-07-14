import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main_JO_2082_힙정렬2_HeapSort { // 제출일 2021-07-14 23:52

	static int n;

	static class MyMaxHeap {

		static int size;
		static int[] heapArr;

		public MyMaxHeap() {
			// TODO Auto-generated constructor stub
		}

		public MyMaxHeap(int n) {
			size = 0;
			heapArr = new int[n + 1];
		}

		public void push_heap(int p) {
			heapArr[++size] = p;
			int child = size;
			while (child > 1 && heapArr[child] > heapArr[child / 2]) {
				int tmp = heapArr[child];
				heapArr[child] = heapArr[child / 2];
				heapArr[child / 2] = tmp;
				child /= 2;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(heapArr[1]);
			for (int i = 2; i <= n; i++) {
				sb.append(' ').append(heapArr[i]);
			}
			sb.append('\n');
			return sb.toString();
		}

		public int pop_heap() {
			// 우선 pop할 값을 저장하고
			int pop = heapArr[1];
			heapArr[1] = heapArr[size];
			heapArr[size--] = pop;
			// 다시 최대힙으로 정렬시킨다
			int parent = 1;
			int child = 2;
			while (child <= size) {
				if (child < size && heapArr[child + 1] > heapArr[child]) {
					child++; // 왼쪽 자식인가 오른쪽 자식인가
				}
				if (heapArr[child] <= heapArr[parent]) {
					break;
				}
				int tmp = heapArr[child];
				heapArr[child] = heapArr[parent];
				heapArr[parent] = tmp;

				parent = child;
				child <<= 1;
			}
			return pop;
		}

	}

	public static void main(String[] args) throws Exception {
		FastReader fr = new FastReader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// max heap에 n개의 숫자를 넣어 내부 힙 배열을 출력하고
		// 최대값을 마지막 위치에 두고 전체를 다시 max heap으로 정렬하는 과정을 반복하여
		// 최종적으로 오름차순으로 정렬된 자료를 출력한다
		n = fr.nextInt(); // 최대 50만 개
		MyMaxHeap myheap = new MyMaxHeap(n);
		for (int i = 0; i < n; i++) {
			myheap.push_heap(fr.nextInt()); // 각 21억 이하 자연수
		}
		sb.append(myheap.toString());
		// 다 꺼내서 오름차순 정렬했다면 더 빨랐겠지만
		// 문제에 있는대로 pop_heap()을 통해서 heapArr 내부에서 정렬하도록 함
		for (int i = 0; i < n; i++) {
			myheap.pop_heap();
		}
		sb.append(myheap.toString());

		bw.write(sb.toString());
		bw.flush();
	}

	// https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	// 4.Using Reader Class:

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
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

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}