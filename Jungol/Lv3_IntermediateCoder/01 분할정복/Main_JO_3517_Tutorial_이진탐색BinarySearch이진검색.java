import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main_JO_3517_Tutorial_이진탐색BinarySearch이진검색 { // 제출일 2021-04-04 21:10

	// Scanner 쓰면 3000 ms 이상
	// BufferedReader 쓰면 약 1500 ms
	// FastReader 쓰면 약 500 ms
	
	static int n, q;
	static int[] arr, ans;

	public static void main(String[] args) throws Exception {
		input();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();
		n = fr.nextInt(); // 100 이상 50만 이하
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fr.nextInt();
		}
		q = fr.nextInt();
		ans = new int[q];
		for (int i = 0; i < q; i++) {
			ans[i] = binarySearch(fr.nextInt());
		}
	}

	private static int binarySearch(int search) {
		int left = 0;
		int right = n - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] < search) {
				left = mid + 1;
			} else if (arr[mid] > search) {
				right = mid - 1;
			}
		}
		return -1;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(ans[0]);
		for (int i = 1; i < ans.length; i++) {
			sb.append(' ').append(ans[i]);
		}

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