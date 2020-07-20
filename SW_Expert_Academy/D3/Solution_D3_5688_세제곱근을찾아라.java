import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1차 제출일 2020-07-20 04:01 17,144 kb 95 ms   a = (b+c)^3 	사용 100개 중 64개 통과 
// 2차 제출일 2020-07-20 04:09 20,572 kb 184 ms  brute-force 	사용 100개 중 100개 통과
// 3차 제출일 2020-07-20 04:18 19,464 kb 112 ms  Math.cbrt 함수 	사용 100개 중 100개 통과
// 4차 제출일 2020-07-20 15:22 20,204 kb 180 ms  cbrt64 구현 함수 	사용 100개 중 100개 통과
// 5차 제출일 2020-07-20 17:10 18,660 kb 111 ms  a = (b+c)^3 	사용 100개 중 100개 통과
public class Solution_D3_5688_세제곱근을찾아라 {

	static StringBuilder sb = new StringBuilder();
	static int len;
	static long a;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

//		Reader s = new Reader();

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// Java에는 unsigned 형이 없지만 C에는 있고
			// 그 때 최대 세제곱 수는 18 446724 184312 856125 이다.
			// 세제곱근은 2642245 이고
			//
			// Long.MAX_VALUE = 9 223372 036854 775807;
			// 10^18 이하 정수 1 000000 000000 000000;
			// 10^6 이 들어오면 딱 10^18
			// 역으로 입력 수의 길이로 시작과 끝을 지정해 계산
			// 4 : 1000 이상이면 10
			// 7 : 1000000 이상이면 100
			// 10 : 1000000000 이상이면 1000
			// 13 : 1000000000000 이상이면 10000
			// 16 : 1000000000000000 이상이면 100000
			// 19 : 1000000000000000000 이상이면 1000000

			String line = br.readLine();
			len = line.length();
			a = Long.parseLong(line);

			sol1();
//			sol2();
//			sol3(); 
//			sol4();

			sb.append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void sol4() {

		long cbrt = cbrt64(a);
		if (a == cbrt * cbrt * cbrt) {
			sb.append(cbrt);
		} else {
			sb.append(-1);
		}

	}

	private static int cbrt64(long x) {
		if (x >= 1000000000000000000L) {
			return 1000000;			
		}
		
		double dx = (double) x;
		// double과 int 형 간에 형변환
		int uy = ((int) dx) / 4;
		uy += uy / 4;
		uy += uy / 16;
		uy += uy / 256;
		uy += 0x2a5137a0; // 709965728
		double dy = (double) uy;

		dy = 0.33333333f * (dx / (dy * dy) + 2.0f * dy);
		int y0 = (int) (0.33333333f * (dx / (dy * dy) + 2.0f * dy));
		int y1 = (int) y0;

		long y2, y3;		
	
		if (y1 >= 1000000) {
			y1 = 1000000;
			y2 = 1000000000000L;
			y3 = 1000000000000000000L;
		} else {
			y2 = (long) y1 * y1;
			y3 = y2 * y1;
		}
		
		if (y3 > x) {
			y1 -= 1;
			y2 -= 2 * y1 + 1;
			y3 -= 3 * y2 + 3 * y1 + 1;
			while (y3 > x) {
				y1 -= 1;
				y2 -= 2 * y1 + 1;
				y3 -= 3 * y2 + 3 * y1 + 1;
			}
			return y1;
		}		
		
		do {
			y3 += 3 * y2 + 3 * y1 + 1;
			y2 += 2 * y1 + 1;
			y1 += 1;
		} while (y3 <= x);		
		
		return y1 - 1;
	}

	private static void sol3() {
		double b = Math.cbrt(a);

		if (b % 1 == 0) {
			sb.append((long) b);
		} else {
			sb.append(-1);
		}

	}

	private static void sol2() {

		// brute force
		// 100개 중 100개 pass

		long b = 0;
		long c = 0;
		if (len > 18) {
			b = 1000000;
			c = 1000001;
		} else if (len > 15) {
			b = 100000;
			c = 1000000;
		} else if (len > 12) {
			b = 10000;
			c = 100000;
		} else if (len > 9) {
			b = 1000;
			c = 10000;
		} else if (len > 6) {
			b = 100;
			c = 1000;
		} else if (len > 3) {
			b = 10;
			c = 100;
		} else {
			b = 1;
			c = 10;
		}

		boolean find = false;
		long i = 0;
		for (i = b; i < c; i++) {
			if (a == i * i * i) {
				find = true;
				break;
			}
		}
		if (find) {
			sb.append(i);
		} else {
			sb.append(-1);
		}

	}

	private static void sol1() {
		// a = (b+c)^3 을 이용하여 계산한다
		// 100개 중 64개 ? 왜 틀렸지
		// long을 double로 바꿔서 정확도를 높여 해결

		double b = 0;
		if (len > 18) {
			b = 1000000;
		} else if (len > 15) {
			b = 100000;
		} else if (len > 12) {
			b = 10000;
		} else if (len > 9) {
			b = 1000;
		} else if (len > 6) {
			b = 100;
		} else if (len > 3) {
			b = 10;
		} else {
			b = 1;
		}

		double c = 1.0;

		do {
			c = (a - b * b * b) / (double) (3 * b * b);
			b += Math.floor(c);
		} while (Math.abs(c) >= 1);

		if (a == b * b * b) {
			sb.append((int)b);
		} else {
			sb.append(-1);
		}
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