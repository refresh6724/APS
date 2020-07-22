import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_6190_정곤이의단조증가하는수 { // 제출일 2020-07-22 22:30 22,708 kb 265 ms
	
	static int ans;
	static int[] A;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Reader s = new Reader();

//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			int N = s.nextInt(); // 1000 이하
			A = new int[N];
					
			for (int i = 0; i < N; i++) {
				A[i] = s.nextInt(); // 3만 이하
			}
			
			ans = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					check(A[i]*A[j]);
				}
			}

			sb.append(ans).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void check(int mul) {
		// A[i] * A[j]가 단조 증가하는 수라면 ans를 갱신한다
		
		int b = mul%10;
		int a = mul/10;
		int tmp = 0;
		while(a != 0) {
			tmp = a%10;
			if(b < tmp) {
				return;
			}
			b = tmp;
			a /= 10;
		}
		
		// 통과하면 ans 갱신
		
		ans = Math.max(ans, mul);
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