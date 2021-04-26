import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main_JO_3136_const구간의합구하기_2D { // 제출일 2021-04-26 23:20

	static long[][] sum = new long[1001][1001];
	static OutputStream out = new BufferedOutputStream(System.out);

	public static void main(String[] args) throws Exception {
		FastReader fr = new FastReader();
		int n = fr.nextInt(); // 1000
		for (int row = 1; row <= n; row++) { // 1000 * 1000 = 1백만
			for (int col = 1; col <= n; col++) {
				// 1,1 에서 row,col 까지의 합
				sum[row][col] = sum[row - 1][col] + sum[row][col - 1] - sum[row - 1][col - 1] + fr.nextInt();
			}
		}

		int m = fr.nextInt();
		int sr, sc, er, ec;
		long ans = 0;
		for (int i = 0; i < m; i++) {
			sr = fr.nextInt();
			sc = fr.nextInt();
			er = fr.nextInt();
			ec = fr.nextInt();
			ans = sum[er][ec] - sum[sr - 1][ec] - sum[er][sc - 1] + sum[sr - 1][sc - 1];
			out.write((ans + "\n").getBytes());
		}
		out.flush();
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