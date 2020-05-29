import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution_D3_6808_규영이와인영이의카드게임 { // 제출일 2020-05-29 23:59 20,988 kb 2,133 ms

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

	static int[] a, b;
	static int win, lose;
	static boolean[] visited = new boolean[9];

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();

		int TC = s.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int[] num = new int[19];
			a = new int[9];
			for (int i = 0; i < 9; i++) {
				a[i] = s.nextInt();
				num[a[i]] = 1;
			}

			b = new int[9];
			for (int i = 1, j = 0; i <= 18; i++) {
				if (num[i] == 0) {
					b[j++] = i;
				}
			}

			Arrays.fill(visited, false);

			win = 0;
			lose = 0;
			for (int i = 0; i < 9; i++) { // 첫타자
				visited[i] = true;
				dfs(0, 0, 0, b[i]);
				visited[i] = false;
			}

			System.out.println(String.format("#%d %d %d", tc, win, lose));
		}

	}

	private static void dfs(int step, int scoreA, int scoreB, int nextB) {

		if (a[step] > nextB) {
			scoreA += a[step] + nextB;
		} else if (a[step] < nextB) {
			scoreB += a[step] + nextB;
		}

		if (step == 8) {
			// win lose 판단
			if (scoreA > scoreB) {
				win++;
			} else if (scoreA < scoreB) {
				lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(step + 1, scoreA, scoreB, b[i]);
				visited[i] = false;
			}
		}

	}

}