import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_10059_유효기간 { // 제출일 2020-07-09 23:08 26,300 kb 129 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

//		Reader s = new Reader();

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
//		testcase: 
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			String line = br.readLine();

			int left = Integer.parseInt(line.substring(0, 2));
			int right = Integer.parseInt(line.substring(2, 4));

			boolean isLM = false;
			boolean isRM = false;
			// 앞 2자리가 YY면 1 MM 이면 2를 더한다
			// 00~99 모두 가능하므로 일단 1을 더한다
			// judge+=1;
			if (left >= 1 && left <= 12) {
				isLM = true;
			}
			// 뒤 2자리가 YY면 4 MM이면 8을 더한다
			// 00~99 모두 가능하므로 일단 4를 더한다
			// judge += 4;
			if (right >= 1 && right <= 12) {
				isRM = true;
			}

			//
			if (isLM && isRM) {
				sb.append("AMBIGUOUS");
			} else if (isRM) {
				sb.append("YYMM");
			} else if (isLM) {
				sb.append("MMYY");
			} else {
				sb.append("NA");
			}

			sb.append('\n');

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