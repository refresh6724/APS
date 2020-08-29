import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 정점과 간선 정보가 주어질때 negative cycle을 찾자
 */
public class NegativeCycle {

	public static void main(String[] args) throws Exception {

		Reader s = new Reader();

		int V = s.nextInt(); // vertices
		int E = s.nextInt();// edges

		int[][] map = new int[V][V];
		for (int i = 0; i < V; i++) {
			Arrays.fill(map[i], 1 << 10);
			map[i][i] = 0;
		}

		int f, t, w; // from to weight
		for (int i = 0; i < E; i++) {
			f = s.nextInt();
			t = s.nextInt();
			w = s.nextInt();
			map[f][t] = w;
		}

		boolean hasNegativeCycle = false;
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 0; i < V; i++) {
			if (map[i][i] < 0) {
				hasNegativeCycle = true;
				break;
			}
		}
		
		System.out.println(hasNegativeCycle?"Negative":"Positive");

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