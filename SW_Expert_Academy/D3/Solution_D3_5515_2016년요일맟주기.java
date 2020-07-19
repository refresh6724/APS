import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution_D3_5515_2016년요일맟주기 { // 제출일 2020-07-19 21:07 18,696 kb 107 ms

	static int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	// 2016년은 4로 나뉘므로 윤년 2월 29일까지
	// 1,3,5,7,8,10,12 31일
	// 2 29일
	// 4,6,9,11 30일
	
	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Reader s = new Reader();

		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			int m = s.nextInt();
			int d = s.nextInt();
			
			int day = 0;
			for (int i = 1; i < m; i++) { // m-1 월 까지의 날짜를 더해준다
				day += days[i];
			}
			
			day += d+3;
			// 1월 1일은 금요일 4 이므로 3를 더해주고
			
			day %= 7; // 7로 나눈 나머지가 답이 된다.			

			sb.append(day).append('\n');

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