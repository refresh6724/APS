import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 사이클 탐색을 처음으로 배웠다
// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// https://kim6394.tistory.com/228
// https://yabmoons.tistory.com/415

public class Solution_D4_5684_Professional_운동 { // 제출일 2020-07-27 23:48 22,132 kb 131 ms

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Reader s = new Reader();

	static class Node {
		int destination;
		int length;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int destination, int length) {
			super();
			this.destination = destination;
			this.length = length;
		}

	}

	static int N, M, ans;
	static List<List<Node>> adj;
	static boolean[] visited;
	static int[] end;

	public static void main(String[] args) throws Exception {

		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			input();
			solve();
			output(tc);
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void output(int tc) {
		sb.append('#').append(tc).append(' ').append((ans == Integer.MAX_VALUE) ? -1 : ans).append('\n');
	}

	private static void solve() {
		// TODO Auto-generated method stub
		for (int startNode = 0; startNode < N; startNode++) {
			if (end[startNode] != 0) {
				visited = new boolean[N];
				dfs(startNode, 0, startNode);
			}
		}
	}

	private static void dfs(int recursive, int sum, int startNode) {
		// TODO Auto-generated method stub
		visited[recursive] = true;
		for (int i = 0; i < adj.get(recursive).size(); i++) {
			int nextNode = adj.get(recursive).get(i).destination;
			int length = adj.get(recursive).get(i).length;

			if (visited[nextNode]) {
				if (nextNode == startNode) {
					ans = Math.min(ans, sum + length);
				}
			} else {
				if (sum + length < ans) {
					dfs(nextNode, sum + length, startNode);
				}
			}
		}
	}

	private static void input() throws IOException {
		// 건물의 수 N 도로의 수 M (2 ≤ N ≤ 400, 2 ≤ M ≤ N*(N-1))
		N = s.nextInt();
		M = s.nextInt();
		ans = Integer.MAX_VALUE;

		adj = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		visited = new boolean[N];
		end = new int[N];

		for (int i = 0; i < M; i++) {
			int S = s.nextInt() - 1;
			int E = s.nextInt() - 1;
			int C = s.nextInt(); // 일방통행 최대 1만이하 자연수이므로 음수 없음
			adj.get(S).add(new Node(E, C));
			end[E]++;
		}
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream dis;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			dis = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		private void fillBuffer() throws IOException {
			bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) {
				buffer[0] = -1;
			}
		}

		public byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				fillBuffer();
			}
			return buffer[bufferPointer++];
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length가 64자 인 것으로 가정
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					break;
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
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return ret;
		}
	}

}