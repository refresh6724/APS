import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_4579_세상의모든팰린드롬2 { // 제출일 2020-07-10 22:58 16,076 kb 95 ms

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

			char[] str = br.readLine().toCharArray(); // 최대 20자

			int len = str.length;
			
			boolean isPalindrome = true;
			
			for (int left = 0, right = len-1; left < right; left++, right--) {
				// 0글자 이상 와일드 카드 * 
				// 좌우 끝을 제외하고 *가 중간에 삽입되어있다면 무조건 팰린드롬이 성립한다
				// 
				if(str[left] != '*' && str[right] != '*') {
					if(str[left] != str[right]) {
						isPalindrome = false;
						break;
					}
				} else {
					break;
				}
			}
			
			sb.append(isPalindrome?"Exist":"Not exist").append('\n');

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