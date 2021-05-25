import java.io.*;
import java.util.*;

// ver1 평범한 dfs : Runtime Error(20) stack over flow 
// ver2 while + stack으로 전환 : Time Limit Exceed(50) max : 1847 ms
// ver3 arraylist에서 값을 가져오는 것을 get에서 remove로 전환하여 dfs처럼 중복계산없이 이어지도록 함 : Time Limit Exceed(60) max : 1704 ms
// ver4 입력을 더욱 빠르게 하기 위해 FastReader 클래스 사용 : Time Limit Exceed(70) max : 1540 ms
// ver5 arraylist size를 별도의 배열에 저장 : Time Limit Exceed(70) max : 1402 ms
// ver6 n일 때 정렬하지 않았던 버그를 수정 : Time Limit Exceed(90) max : 1356 ms
// ver7 finished 배열을 추가해 while문을 한번 덜 돌도록 수정 : 위와 같음
// ver8 지역 변수를 정적 변수로 수정 : 위와 같음
// ver9 ArrayList 정렬 시간을 줄이기 위해 PriorityQueue로 수정 : Time Limit Exceed(90) max : 1041 ms
// ver10 stack을 배열과 sidx로 전환 : Time Limit Exceed(90) max : 1022 ms
// ver11 클래스 import 부분을 *로 전환하고 주석을 제거 : Success(100) max : 940ms	

public class Main_JO_1912_미로탐색 { // 제출일 2021-05-25 23:56

	static int n, m, cnt, start, next, sidx;
	static List<PriorityQueue<Integer>> graph;
	static boolean[] visited;
	static int[] size, order, stk;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();
		n = fr.nextInt(); // 방의 수 2 이상 10만 이하
		m = fr.nextInt(); // 문의 수 1 이상 50만 이하
		cnt = 0;
		graph = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			graph.add(new PriorityQueue<Integer>());
		}
		for (int i = 0; i < m; i++) {
			start = fr.nextInt();
			next = fr.nextInt();
			graph.get(start).add(next);
			graph.get(next).add(start);
		}
		visited = new boolean[n + 1];
		size = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			size[i] = graph.get(i).size();
		}
		order = new int[n];
		sidx = 0;
		stk = new int[n << 1];
	}

	/*
	 * 10만개로 stackoverflow, 메모리 초과, 시간 초과
	 */
	private static void dfs(int v) {
		if (cnt == n) {
			return;
		}
		visited[v] = true;
		order[cnt++] = v;
		for (int next : graph.get(v)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	/*
	 * dfs를 while + stack으로 바꾸어 stackoverflow를 피함
	 */
	private static void go() {
		// 1번 방에서 출발해 N개 방을 모두 탐색하고 다시 1번 방으로 돌아오는 경우를 출력
		start = 1;

		visited[start] = true;
		order[cnt++] = start;
		boolean backtrack = false;
		while (cnt < n) {
			if (!backtrack) {
				stk[sidx++] = start;
				backtrack = true;
			}
			next = -1;
			int siz = size[start];
			for (int idx = 0; idx < siz; idx++) {
				next = graph.get(start).poll();
				size[start]--;
				if (!visited[next]) {
					visited[next] = true;
					order[cnt++] = next;
					stk[sidx++] = start;
					stk[sidx++] = next;
					backtrack = false;
					break;
				}
			}
			start = stk[--sidx];
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(order[0]);
		for (int i = 1; i < n; i++) {
			sb.append(' ').append(order[i]);
		}
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