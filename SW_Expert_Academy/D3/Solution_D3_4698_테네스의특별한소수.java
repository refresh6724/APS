import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4698_테네스의특별한소수 { // 제출일 2020-07-13 23:31 102,284 kb 754 ms
	
	static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

//		Reader s = new Reader();
		
		// 1부터 100만까지의 소수를 미리 계산해 기록해 둘 경우 => int 4byte * 100만 = 4MB 
		primecheck:
		for (int i = 2; i < 999998; i++) {
			// i가 소수인지 sqrt i 까지 나눠보면서 확인
			for (int j = 2; j <= (int) Math.floor(Math.sqrt(i)); j++) {
				if(i%j==0) { // 나뉘면 소수가 아니다
					continue primecheck;
				}
			}
			// 나뉘지 않는다면 소수
			prime[i] = true;
		}
		
//		System.out.println(Arrays.toString(prime));

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
//		testcase: 
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			
			String special = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int res = 0;
			
			for (int i = start; i <= end; i++) {
				if(prime[i]) {
					if(Integer.toString(i).contains(special)) {
						res++;
					}
				}
			}	
			
			sb.append(res).append('\n');

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