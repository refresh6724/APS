import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 기존 제출일 2020-05-13 23:10 92,272 kb 267 ms
// 개선 제출일 2020-05-17 14:25 21,772 kb 135 ms
public class Solution_D3_9940_순열1 {
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

	static String yes = " Yes\n";
	static String no = " No\n";

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Reader s = new Reader();

		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc);
			int n = s.nextInt();
			boolean is = true;
			int[] arr = new int[n + 1];
			for (int i = 0; i < n; i++) {
				int num = s.nextInt();
				if (is && arr[num] != 0) {
					is = false;
				}
				arr[num]++;
			}
			if (is) {
				sb.append(yes);
			} else {
				sb.append(no);
			}

		}
		bw.write(sb.toString());
		bw.flush();
	}
}