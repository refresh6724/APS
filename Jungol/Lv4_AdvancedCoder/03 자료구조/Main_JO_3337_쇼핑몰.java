import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_JO_3337_쇼핑몰 { // 제출일 2021-07-23 00:01

	static class Node {
		int k;
		int id;
		int w;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int k, int id, int w) {
			super();
			this.k = k;
			this.id = id;
			this.w = w;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [k=").append(k).append(", id=").append(id).append(", w=").append(w).append("]");
			return builder.toString();
		}

	}

	public static void main(String[] args) throws Exception {

		FastReader fr = new FastReader();

		int n = fr.nextInt(); // 고객 1 이상 10만 이하
		int k = fr.nextInt(); // 계산대 1 이상 10만 이하

		PriorityQueue<Node> empty = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// 비어있다면 k가 작은 것을 먼저
				return o1.k - o2.k;
			}
		});

		PriorityQueue<Node> wait = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// 비어있지 않다면 시간이 작은 것, 시간이 같다면 k가 큰 것
				if (o1.w == o2.w) {
					return o2.k - o1.k;
				}
				return o1.w - o2.w;
			}
		});

		for (int i = 1; i <= k; i++) {
			empty.add(new Node(i, 0, 0));
		}

		long cnt = 0;
		long ans = 0;
		int id, w, now;
		for (int i = 0; i < n; i++) {
			id = fr.nextInt(); // 회원번호 1 이상 1백만 이하
			w = fr.nextInt(); // 구매 물품 = 걸리는 시간 1 이상 20 이하

			while (true) {
				if (empty.isEmpty()) {
					now = wait.peek().w;
					while (!wait.isEmpty() && wait.peek().w == now) {
						Node node = wait.poll();
						ans += ++cnt * node.id;
						empty.add(new Node(node.k, 0, now));
					}
				} else {
					Node node = empty.poll();
					wait.add(new Node(node.k, id, node.w + w));
					break;
				}
			}
		}

		while (!wait.isEmpty()) {
			Node node = wait.poll();
			ans += ++cnt * node.id;
		}

		System.out.println(ans);

		// n명이 계산하고 나오는 순서
		// 들어갈때는 계산대 앞번호부터
		// 나올때는 계산대 뒷번호부터
		// 순서*회원번호의 합을 출력

		// 예제 n = 10, k = 3
		// 1번 계산대, 2번 계산대, 3번 계산대
		// 123번 4분, 21번 5분, 34번 14분
		// 56번 1분(5분)
		// 45번 7분(12분), 723번 5분(10분), 34번 14분
		// 55번 7분(17분)
		// 13번 5분(17분), , 910번 10분(24분)
		// 73번 3분(20분)

		// 순서
		// 1*123 + 2*21 + 3*56 + 4*723 + 5*45 + 6*34
		// + 7*55 + 8*13 + 9*73 + 10*910

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