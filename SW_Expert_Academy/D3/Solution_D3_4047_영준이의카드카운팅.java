import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_4047_영준이의카드카운팅 { // 제출일 2020-07-05 21:51 18,584 kb 105 ms

	static char[] cards;
	static boolean[][] deck = new boolean[4][14];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = null;

//		Reader s = new Reader();

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
		testcase:
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc);

			cards = br.readLine().toCharArray();
			for (int i = 0; i < 4; i++) {
				Arrays.fill(deck[i], false);
				deck[i][0] = true;
			}

			for (int i = 0; i < cards.length; i += 3) {

				if (check(cards[i], i + 1, i + 2)) {
					sb.append(' ').append("ERROR").append('\n');
					continue testcase;
				}
				
			}

			int cnt;
			for (int i = 0; i < 4; i++) {
				cnt = 0;
				for (int j = 0; j < 14; j++) {
					if (!deck[i][j]) {
						cnt++;
					}
				}
				sb.append(' ').append(cnt);
			}

			sb.append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static boolean check(char c, int i, int j) {
		// 중복이라면 true를 리턴한다

		int C = (c == 'S') ? 0 : (c == 'D') ? 1 : (c == 'H') ? 2 : 3;

		int O = (cards[i] - '0') * 10 + (cards[j] - '0');

		if (deck[C][O]) {
			return true;
		}
		deck[C][O] = true;
		return false;
	}

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

}