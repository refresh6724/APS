import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_3282_01Knapsack { // 제출일 2020-06-27 23:30 21,480 kb 127 ms

	static int N, K, maxC;
	static int[][] memo = new int[101][1001];
	static int[] V = new int[100];
	static int[] C = new int[100];

	public static void main(String[] args) throws Exception {

		long begin = System.currentTimeMillis();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Reader s = new Reader();

		int T = s.nextInt();
		for (int i = 1; i <= T; i++) {

			N = s.nextInt(); // 물건 최대 100개
			K = s.nextInt(); // 가방 부피 1000

			for (int j = 0; j <= N; j++) {
				Arrays.fill(memo[j], 0, K + 1, -1);
			}

			for (int j = 0; j < N; j++) {
				V[j] = s.nextInt();
				C[j] = s.nextInt();
			}

			maxC = dp(0, K);

			sb.append('#').append(i).append(' ').append(maxC).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();

		long end = System.currentTimeMillis();
		System.out.printf("### 처리시간 : %.3f(sec)\n", (end - begin) / 1000.0);
	}

	private static int dp(int idx, int 남은부피) {

		if (idx == N) {
			return 0;
		}

		if (memo[idx][남은부피] != -1) {
			return memo[idx][남은부피];
		}

		memo[idx][남은부피] = dp(idx + 1, 남은부피);

		if (남은부피 >= V[idx]) {
			memo[idx][남은부피] = Math.max(memo[idx][남은부피], dp(idx + 1, 남은부피 - V[idx]) + C[idx]);
		}

		return memo[idx][남은부피];

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
