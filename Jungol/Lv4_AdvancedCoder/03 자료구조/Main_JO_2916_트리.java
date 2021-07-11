import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 4차 시도 TLE(60) / 121,256 kb / max : 2906 ms / mean : 1241 ms
// 변경점 : getlca의 시간복잡도를 logn으로 줄이기 위해 2차원배열 parent2를 추가, 깊이 관리를 위해 tree를 추가하고 move 함수에서 depth 계산
public class Main { // 제출일 2021-07-12 01:01

	static int n, k;
	static List<Set<Integer>> tree;
	static int[] parent, color, depth;
	static int[][] parent2;

	public static void main(String[] args) throws Exception {

		FastReader fr = new FastReader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = fr.nextInt(); // 노드 개수 5 이상 10만 이하
		k = fr.nextInt(); // 연산 개수 1 이상 30만 이하

		tree = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			tree.add(new HashSet<>());
		}
		for (int i = 1; i < n; i++) {
			tree.get(0).add(i);
		}

		int r, a, b, c, prev;
		parent = new int[n];
		color = new int[n];
		depth = new int[n];
		Arrays.fill(depth, 1);
		depth[0] = 0;
		parent2 = new int[n][11];

		prev = 0;
		for (int i = 1; i <= k; i++) {
			r = fr.nextInt();
			a = fr.nextInt();
			b = fr.nextInt();
			if (r == 1) {
				if (prev == 2) {
					findParent();
				}
				c = fr.nextInt();
				paint(a, b, c);
			} else if (r == 2) {
				move(a, b);
			} else if (r == 3) {
				if (prev == 2) {
					findParent();
				}
				sb.append(count(a, b)).append('\n');
			}
			prev = r;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int count(int a, int b) {

		Set<Integer> colorSet = new HashSet<Integer>();
		int lca = getlca(a, b);
		while (a != lca) {
			colorSet.add(color[a]);
			a = parent[a];
		}
		while (b != lca) {
			colorSet.add(color[b]);
			b = parent[b];
		}
		return colorSet.size();
	}

	private static void move(int a, int b) {
		// move Subtree
		// 원래 a의 부모 p 에서 a를 제거하고 b에 a를 추가하고 깊이를 재계산
		tree.get(parent[a]).remove(a);
		tree.get(b).add(a);
		parent[a] = b;
		dfs(a, depth[b] + 1);
	}

	private static void dfs(int a, int d) {
		depth[a] = d;
		for (int child : tree.get(a)) {
			dfs(child, d + 1);
		}
	}

	private static void findParent() {
		for (int i = 1; i < n; i++) {
			parent2[i][0] = parent[i];
		}

		for (int j = 1; j < 11; j++) {
			for (int i = 1; i < n; i++) {
				parent2[i][j] = parent2[parent2[i][j - 1]][j - 1];
			}
		}
	}

	private static void paint(int a, int b, int c) {
		int lca = getlca(a, b);
		while (a != lca) {
			color[a] = c;
			a = parent[a];
		}
		while (b != lca) {
			color[b] = c;
			b = parent[b];
		}
	}

	private static int getlca(int a, int b) {
		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for (int i = 10; i >= 0; i--) {
			if (depth[b] - depth[a] >= (1 << i)) {
				b = parent2[b][i];
			}
		}
		if (a == b) {
			return a;
		}
		for (int i = 10; i >= 0; i--) {
			if (parent2[a][i] != parent2[b][i]) {
				a = parent2[a][i];
				b = parent2[b][i];
			}
		}
		return parent2[a][0];
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