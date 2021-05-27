import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// BOJ 17616 문제와 같음
// ver1 x보다 큰 것과 작은 것을 따로 계산 Time Limit Exceed(52) max 1950 ms
// ver2 빠른 입력을 위해 FastReader 클래스 사용  Time Limit Exceed(61) max 1966 ms
// ver3 visited 처리 위치를 for문 내부로 이동 Time Limit Exceed(65) max 1921 ms
// ver4 변수를 줄이고 LinkedList를 ArrayList로 수정 Time Limit Exceed(65) max 1702 ms
// ver5 노드 내부의 업 다운을 밖으로 내어 이차원 배열로 수정 Success(100) 540 ms

public class Main_JO_3428_등수찾기ranking { // 제출일 2021-05-27 21:36

	static final int LOW = 0;
	static final int HIGH = 1;
	static int n, m, x, u, v;
	static Node[][] students;
	static boolean[] visited;

	static class Node {
		int idx;
//		ArrayList<Integer> lower;
//		ArrayList<Integer> higher;
		Node next;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int idx, Node next) {
			super();
			this.idx = idx;
			this.next = next;
//			this.lower = new ArrayList<Integer>();
//			this.higher = new ArrayList<Integer>();
		}

//		public void isBetterThan(int other) {
//			this.lower.add(other);
//		}
//
//		public void isWorseThan(int other) {
//			this.higher.add(other);
//		}
	}

	public static void main(String[] args) throws Exception {
		input();
		findRangeOfX();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();

		n = fr.nextInt(); // 2 이상 10만 이하
		m = fr.nextInt(); // 1 이상 min(n(n-1)/2, 50만) 이하
		x = fr.nextInt(); // 1 이상 n 이하

		students = new Node[n + 1][2]; // 1번부터 n번까지

		for (int i = 0; i < m; i++) {
			// a가 b보다 잘했다
			u = fr.nextInt();
			v = fr.nextInt();
//			students[u].isBetterThan(v);
//			students[v].isWorseThan(u);
			students[v][LOW] = new Node(u, students[v][LOW]);
			students[u][HIGH] = new Node(v, students[u][HIGH]);
		}

		visited = new boolean[n + 1];
	}

	private static void findRangeOfX() {

//		u = 1;
//		v = n;
//		findup(x);
//		finddown(x);

		u = dfs(x, LOW);
		v = n - dfs(x, HIGH) + 1;
	}

	private static int dfs(int now, int updown) {
		visited[now] = true;
		int ret = 1;
		for (Node next = students[now][updown]; next != null; next = next.next) {
			if (!visited[next.idx]) {
				ret += dfs(next.idx, updown);
			}
		}
		return ret;
	}

//	private static void finddown(int now) {
////		ver3
////		v = n+1;
////		if (!visited[now]) {
////			visited[now] = true;
////			v--;
////		}
//
//		for (int low : students[now].lower) {
//			if (!visited[low]) {
//				visited[low] = true;
//				v--;
//				finddown(low);
//			}
//		}
//	}
//
//	private static void findup(int now) {
//		for (int high : students[now].higher) {
//			if (!visited[high]) {
//				visited[high] = true;
//				u++;
//				findup(high);
//			}
//		}
//	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(u).append(' ').append(v).append('\n');
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