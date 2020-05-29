import java.io.DataInputStream;
import java.io.IOException;

// 최초 제출일 2020-05-29 23:59 20,988 kb 2,133 ms
// 3차 제출일 2020-05-30 01:24 20,704 kb 993 ms
public class Solution_D3_6808_규영이와인영이의카드게임 {

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

	static final int CARD = 9;
	static int[] a = new int[CARD];
	static int[] b = new int[CARD];
	static int[] fact = new int[CARD + 1];
	static int win, lose;

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();

		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i <= CARD; i++) {
			fact[i] = i * fact[i - 1];
		}

		int TC = s.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int[] num = new int[CARD << 1 + 1];

			for (int i = 0; i < CARD; i++) {
				a[i] = s.nextInt();
				num[a[i]] = 1;
			}

			for (int i = 1, j = 0; i <= CARD << 1; i++) {
				if (num[i] == 0) {
					b[j++] = i;
				}
			}

			win = 0;
			lose = 0;
			dfs(0, 0, 0, 0);

			System.out.println(String.format("#%d %d %d", tc, win, lose));
		}

	}

	private static void dfs(int visited, int step, int scoreA, int scoreB) {

		if (scoreA > (171 / 2)) {
			win += fact[CARD - step];
			return;
		} else if (scoreB > (171 / 2)) {
			lose += fact[CARD - step];
			return;
		}

		for (int next = 0; next < CARD; next++) {
			if ((visited & (1 << next)) == 0) {

				int plus = a[step] + b[next];
				if (a[step] > b[next]) {
					dfs(visited | (1 << next), step + 1, scoreA + plus, scoreB);
				} else if (a[step] < b[next]) {
					dfs(visited | (1 << next), step + 1, scoreA, scoreB + plus);
				}

			}
		}

	}

}