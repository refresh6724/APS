import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution_D3_3032_홍준이의숫자놀이 { // 제출일 2020-06-24 00:46 27,540 kb 144 ms

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Reader s = new Reader();

		int T = s.nextInt();
		for (int i = 1; i <= T; i++) {
			sb.append('#').append(i);
			int A = s.nextInt(); // 10^9
			int B = s.nextInt(); // 10^9

			// 단, A와 B는 서로소이다
			// Ax+By=1 의 해를 출력
			// 유일한 해라면 x, y 출력
			// 유일하지 않다면 아무것이나 출력
			// 해가 없다면 -1 출력

			// A = r0 = s0A + t0B (이 때 s0 = 1, t0 = 0)
			// B = r1 = s1A + t1B ( s1 = 0, t1 = 1)

			egcd(A, B);

			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void egcd(int a, int b) { // ba xy uv qr mn
		int x, y, u, v, q, r, m, n;
		x = 0;
		y = 1;
		u = 1;
		v = 0;
		while (a != 0) {
			q = b / a;
			r = b % a;
			m = x - u * q;
			n = y - v * q;

			b = a;
			a = r;
			x = u;
			y = v;
			u = m;
			v = n;
		}

		// a, b가 서로소 이므로
		// gcd = b = 1 이 되고
		// x와 y가 결정된다
		sb.append(' ').append(x).append(' ').append(y);
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
