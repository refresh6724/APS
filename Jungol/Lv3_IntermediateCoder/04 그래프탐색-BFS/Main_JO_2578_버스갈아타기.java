import java.io.*;
import java.util.*;

// v1 일반 입출력 Time Limit Exceed(75) 1944 ms
// v2 FastReader Time Limit Exceed(80) 1948 ms
// v3 List<List<Integer 를 Path next로 수정 Time Limit Exceed(95) 1949 ms
// v4 버스 번호는 의미가 없다. 수직, 수평을 나누지 않고 k = 5000 개를 모두 순회 Time Limit Exceed(40)
// v5 Bus 생성자 내부의 비교를 밖으로 꺼내고 반복되는 static 변수 호출을 제거, visited 배열을 int 배열로 수정, 큐의 노드를 제거하고 int로 단순화 Time Limit Exceed(45)
// v6 c의 swap과 다르게 자바는 항상 pass by value로 swap을 위해서는 다른 방법을 써야한다. 기본적인 것을 실수했다 Success(100) 411 ms
public class Main_JO_2578_버스갈아타기 { // 제출일 2021-06-05 23:59

	static class Bus {
		int x1;
		int y1;
		int x2;
		int y2;

		boolean visit(int x, int y) {
			return (x1 <= x && x <= x2 && y1 <= y && y <= y2);
		}

		boolean visit(Bus bus) {
			// 상호 교차 조건, 이 문제에서는 수평과 수직만 존재
            // https://heechan3006.github.io/problemsolving/2020/03/09/BOJ_2536.html
            // https://crazyj.tistory.com/140 <= X 겹치는 경우가 빠짐
            // https://gaussian37.github.io/math-algorithm-line_intersection/
            // https://junho0956.tistory.com/175
            // https://bowbowbow.tistory.com/17
			return (bus.x1 <= x2 && bus.x2 >= x1 && bus.y1 <= y2 && bus.y2 >= y1);
		}

		public Bus() {
			// TODO Auto-generated constructor stub
		}

		public Bus(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static int[] visited;
	static Bus[] buses;
	static int m, n, k, sx, sy, dx, dy;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		m = fr.nextInt();
		n = fr.nextInt();
		k = fr.nextInt();
		visited = new int[k + 1];
		buses = new Bus[k + 1];
		int b, x1, y1, x2, y2;
		for (int i = 0; i < k; i++) {
			b = fr.nextInt();
			x1 = fr.nextInt();
			y1 = fr.nextInt();
			x2 = fr.nextInt();
			y2 = fr.nextInt();
			if (x1 > x2) {
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			if (y1 > y2) {
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			buses[i] = new Bus(x1, y1, x2, y2);
		}
		sx = fr.nextInt();
		sy = fr.nextInt();
		dx = fr.nextInt();
		dy = fr.nextInt();
		System.out.println(bfs());
	}

	private static int bfs() {

		q = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			if (buses[i].visit(sx, sy)) {
				q.add(i);
				visited[i] = 1;
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			if (buses[now].visit(dx, dy)) {
				return visited[now];
			}
			for (int i = 0; i < k; i++) {
				if (visited[i] == 0) {
					if (buses[now].visit(buses[i])) {
						q.add(i);
						visited[i] = visited[now] + 1;
					}
				}
			}
		}

		return -1;
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