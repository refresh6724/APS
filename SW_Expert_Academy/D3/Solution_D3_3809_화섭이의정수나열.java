import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_3809_화섭이의정수나열 { // 제출일 2020-07-03 23:32 18,640 kb 113 ms

	static boolean[] visited = new boolean[1001];

	public static void main(String[] args) throws Exception {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = null;

		Reader s = new Reader();

//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			// 1000 자로 만들 수 없는 가장 작은 정수
			// 순서대로 이므로 1~9까지 9자
			// 10에서 99까지 180자
			// 100에서 999까지 2700자
			// 따라서 정답은 최대 3자리 숫자이다.

			Arrays.fill(visited, false);

//			int N = Integer.parseInt(br.readLine());
			int N = s.nextInt();

			int a = 0;
			int b = 0;
			int c = 0;

//			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
//				c = Integer.parseInt(st.nextToken());
				c = s.nextInt();
				b *= 10;
				b += c;
				a *= 10;
				a += c;

				visited[a] = true;
				visited[b] = true;
				visited[c] = true;

				a = b;
				b = c;
				c = 0;
			}

			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < 1001; i++) {
				if (!visited[i]) {
					sb.append(i).append('\n');
					break;
				}
			}

		}
		bw.write(sb.toString());
		bw.flush();
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