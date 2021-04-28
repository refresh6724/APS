import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_JO_2255_섞기수열 { // 제출일 2021-04-28 23:33

	static int n, ans;
	static int[] order, ret;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();

		n = fr.nextInt(); // 1 이상 2만 이하
		order = new int[n];
		for (int i = 0; i < n; i++) {
			order[i] = fr.nextInt() - 1; // 1에서 n까지 한번씩
		}
//		ret = new int[n];
		set = new HashSet<Integer>();
		ans = 1;
	}

	private static void go() {
		// 각 자리가 제자리로 돌아오는 횟수의 공배수
		int cnt, next;
		for (int i = 0; i < order.length; i++) {
			cnt = 1;
			next = order[i];
			while (next != i) {
				next = order[next];
				cnt++;
			}
//			ret[i] = cnt;
			set.add(cnt);
		}

//		Arrays.parallelSort(ret);
//		ans = ret[0];		
//		for (int i = 1; i < ret.length; i++) {
//			if (ret[i - 1] != ret[i]) {
//				ans = lcm(ans, ret[i]);
//			}
//		}
		
		ans = 1;
		for(int a : set) {
			ans = lcm(ans, a);
		}
	}

	private static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	private static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, (a % b));
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
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