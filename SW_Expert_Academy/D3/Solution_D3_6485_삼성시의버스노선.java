import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_6485_삼성시의버스노선 { // 제출일 2020-06-07 23:19 19,552 kb 117 ms

	static int[] map = new int[5001];
	/*
	 * 정류장 번호를 가로축 열로 노선번호를 세로축 행으로 하여 500 * 5000 크기의 맵을 그리고 각 노선번호에 해당하는 A ~ B 선을
	 * 그은 뒤 P개 만큼의 정류장번호 C 에 해당하는 세로선에 수직으로 교차하는 점의 개수를 구한다 개수만 세면 되므로 나열할 필요 없이
	 * 입력되는 대로 더하고 출력한다
	 */

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = s.nextInt();
		int N, A, B, P;
		for (int tc = 1; tc <= TC; tc++) {

			// 지도 초기화
			Arrays.fill(map, 0);
//			map = new int[5001];

			N = s.nextInt();
			for (int i = 0; i < N; i++) {
				A = s.nextInt();
				B = s.nextInt();
				// 노선 표기
				for (int j = A; j <= B; j++) {
					map[j]++;
				}
			}
//			System.out.println(Arrays.toString(map));

			P = s.nextInt();
			sb.append('#').append(tc);
			for (int i = 0; i < P; i++) {
				sb.append(' ').append(map[s.nextInt()]);
			}
			sb.append('\n');
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