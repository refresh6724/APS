import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 최초 제출일 2020-05-29 23:59 20,988 kb 2,133 ms
// 3차 제출일 2020-05-30 01:24 20,704 kb 993 ms
// 7차 제출일 2020-06-01 03:41 55,100 kb 208 ms
// 13차 제출일 2020-06-01 04:34 21,696 kb 158 ms

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

	static int[] a = new int[9];
	static int[] b = new int[9];
	static int[] fact = new int[10];
	static int[][] memo = new int[121][1 << 9];

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i <= 9; i++) {
			fact[i] = i * fact[i - 1];
		}

		int TC = s.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc).append(' ');

			int[] num = new int[19];
			for (int i = 0; i < 9; i++) {
				a[i] = s.nextInt();
				num[a[i]] = 1;
			}

			for (int i = 1, j = 0; i <= 18; i++) {
				if (num[i] == 0) {
					b[j++] = i;
				}
			}

			for (int i = 0; i < 121; i++) {
				Arrays.fill(memo[i], -1);
			}

			dfs(0, 0, 0, 0);
			
			sb.append(memo[0][0]).append(' ').append(fact[9] - memo[0][0]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int dfs(int visited, int step, int scoreA, int scoreB) {

		if (memo[scoreA][visited] != -1) {
			return memo[scoreA][visited];
		}

		if (scoreA > 85) {
			return memo[scoreA][visited] = fact[9 - step];
		} else if (scoreB > 85) {
			return memo[scoreA][visited] = 0;
		}

		int ret = 0;
		for (int next = 0; next < 9; next++) {
			if ((visited & (1 << next)) == 0) {
				int plus = a[step] + b[next];
				if (a[step] > b[next]) {
					ret += dfs(visited | (1 << next), step + 1, scoreA + plus, scoreB);
				} else if (a[step] < b[next]) {
					ret += dfs(visited | (1 << next), step + 1, scoreA, scoreB + plus);
				}

			}
		}
		return memo[scoreA][visited] = ret;
	}

}