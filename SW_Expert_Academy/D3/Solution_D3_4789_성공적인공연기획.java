import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_4789_성공적인공연기획 { // 제출일 2020-07-15 23:22 21,340 kb 121 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

//		Reader s = new Reader();

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
//		testcase: 
		for (int tc = 1; tc <= TC; tc++) {
			
			sb.append('#').append(tc).append(' ');
								
			int ans = 0; // 필요한 사람 수			
			int up = 0; // 현재 일어난 사람 수
						
			String input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				// i가 곧 해당 위치에서 필요한 사람 수이다
				if(up >= i) {
					// 현재 일어난 사람이 필요한 사람보다 많다면 
					up += input.charAt(i)-'0';
				} else {
					// 현재 일어난 사람 수가 모자라다면 필요한 사람수는 i-up명이다
					ans += i-up;
					up = i;
					up += input.charAt(i)-'0';
				}
			}
			
			sb.append(ans).append('\n');
			
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