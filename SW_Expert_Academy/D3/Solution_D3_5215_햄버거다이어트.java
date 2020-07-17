import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 기존 제출일 2019-07-17 10:55 25,892 kb 210 ms
// 2차 제출일 2020-07-16 22:36 21,324 kb 167 ms dfs
// 3차 제출일 2020-07-17 05:09 25,936 kb 115 ms dp
public class Solution_D3_5215_햄버거다이어트 {

	static int N, L;
	static int[] score;

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Reader s = new Reader();

		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// 특정 칼로리 이하 조합에서 최대 점수 찾기
			N = s.nextInt(); // 재료 개수
			L = s.nextInt(); // 칼로리 제한
			score = new int[L + 1]; // 해당 칼로리에서 가질 수 있는 가장 큰 값을 dp로 계산

			int t, k;
			for (int i = 0; i < N; i++) {
				t = s.nextInt();
				k = s.nextInt();
				for (int calSum = L; calSum >= k; calSum--) {
					// L 칼로리부터 최소 k 칼로리까지
					// 지금 i번째 재료가 들어갔을 때와 들어가지 않았을 때의 점수를 비교해 더 큰 값을 저장
					score[calSum] = (score[calSum] > score[calSum - k] + t) ? score[calSum] : score[calSum - k] + t;
				}
			}
			sb.append(score[L]).append('\n');

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