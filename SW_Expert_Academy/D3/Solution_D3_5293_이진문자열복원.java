import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution_D3_5293_이진문자열복원 { // 제출일 2020-07-17 11:58 27,792 kb 126 ms

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Reader s = new Reader();

		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			int a = s.nextInt(); // 00
			int b = s.nextInt(); // 01
			int c = s.nextInt(); // 10
			int d = s.nextInt(); // 11

			// 각 최대 20일때 경우의 수는 2^81
			// dfs로 풀 경우 스택오버플로우발생

			// 각 1인 경우 가능
			// ab 001 무조건 a 먼저
			// ac 100 무조건 c 먼저
			// ad 불가능
			// bc 010 cb 101
			// bd 011 무조건 b 먼저
			// cd 110 무조건 d 먼저

			// a가 여럿일 경우 0000000 이 되고
			// d가 여럿일 경우 1111111 이 된다
			// b가 홀수라면 c가 없어도 되지만 짝수라면 필수다
			// 반대인 경우도 마찬가지이므로
			// b와 c 개수 차이는 0 아니면 1이어야 한다

			if (Math.abs(b - c) > 1) {
				sb.append("impossible");
			} else if (b == 0 && c == 0) {
				if (a > 0 && d > 0) {
					sb.append("impossible");
				} else if (a > 0) { // a만 존재
					for (int i = 0; i <= a; i++) {
						sb.append("0");
					}
				} else if (d > 0) { // d만 존재
					for (int i = 0; i <= d; i++) {
						sb.append("1");
					}
				}
			} else if (b > c) { // b가 더 많은 경우 01이 먼저 나와야 한다
				for (int i = 0; i < a; i++) {
					sb.append("0");
				}
				for (int i = 0; i < b; i++) { // 0...0 0101...01 1...1
					sb.append("01");
				}
				for (int i = 0; i < d; i++) {
					sb.append("1");
				}
			} else if (b < c) { // c가 더 많은 경우 10이 먼저 나와야 한다
				for (int i = 0; i < d; i++) {
					sb.append("1");
				}
				for (int i = 0; i < c; i++) {
					sb.append("10");
				}
				for (int i = 0; i < a; i++) {
					sb.append("0");
				}
			} else if (b == c) {
				// 0...0 (a개) 1...1 (b 1개와 d개) 0(c 1개) 10101010 ... 10 (b, c 각 b-1개)
				// 1...1 (d개) 0...0 (c 1개와 a개) 1(b 1개) 01010101 ... 01
				for (int i = 0; i <= a; i++) {
					sb.append("0");
				}
				for (int i = 0; i < d; i++) {
					sb.append("1");
				}				
				for (int i = 0; i < b; i++) {
					sb.append("10");
				}
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