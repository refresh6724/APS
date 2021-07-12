import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// KOI 2015 중등부 3번 / JO 2916 / BOJ 10838
// 5차 시도 TLE(95) / 46,821 kb / max : 2444 ms / mean : 420 ms
// 변경점 : 시간과 메모리를 많이 먹는 set을 hashtable로 변경
public class Main { // 제출일 2021-07-12 23:44

	static int n, k, cnt;
	static int[] parent, color, visited;
	// hash 사용
	static int coloridx;
	static int[] colortable;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {

		FastReader fr = new FastReader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = fr.nextInt(); // 노드 개수 5 이상 10만 이하
		k = fr.nextInt(); // 연산 개수 1 이상 30만 이하
		cnt = 0;

		int r, a, b, c;
		parent = new int[n];
		parent[0] = -1;
		color = new int[n];
		visited = new int[n];

		coloridx = 0;
		colortable = new int[300001];
		map = new HashMap<>();
		map.put(0, coloridx++);

		for (int i = 1; i <= k; i++) {
			r = fr.nextInt();
			a = fr.nextInt();
			b = fr.nextInt();
			if (r == 1) {
				c = fr.nextInt();
				paint(a, b, c);
			} else if (r == 2) {
				move(a, b);
			} else if (r == 3) {
				sb.append(count(a, b)).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int count(int a, int b) {
		if (a == b) {
			return 0;
		}

//      Set<Integer> colorSet = new HashSet<Integer>();
		int colorSet = 0;
		int tempcolor = 0;
		coloridx++;
		int lca = getlca(a, b);
		while (a != lca) {
//          colorSet.add(color[a]);
			tempcolor = color[a];
			if (colortable[tempcolor] != coloridx) {
				colortable[tempcolor] = coloridx;
				colorSet++;
			}
			a = parent[a];
		}
		while (b != lca) {
//          colorSet.add(color[b]);
			tempcolor = color[b];
			if (colortable[tempcolor] != coloridx) {
				colortable[tempcolor] = coloridx;
				colorSet++;
			}
			b = parent[b];
		}
//      return colorSet.size();
		return colorSet;
	}

	private static void move(int a, int b) {
		parent[a] = b;
	}

	private static void paint(int a, int b, int c) {
		if (a == b) {
			return;
		}

		int tempcolor = 0;
		if (map.get(c) != null) {
			tempcolor = map.get(c);
		} else {
			map.put(c, coloridx);
			tempcolor = coloridx++;
		}

		int lca = getlca(a, b);
		while (a != lca) {
			color[a] = tempcolor;
			a = parent[a];
		}
		while (b != lca) {
			color[b] = tempcolor;
			b = parent[b];
		}
	}

	private static int getlca(int a, int b) {

		cnt++;
		int limit = 0;
		while (a != 0 && limit < 1000) {
			visited[a] = cnt;
			a = parent[a];
			limit++;
		}
		while (b != 0) {
			if (visited[b] == cnt) {
				break;
			}
			b = parent[b];
		}
		return b;
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