import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5986_새샘이와세소수 { // 제출일 2020-07-26 23:55 19,908 kb 266 ms
	
	static boolean[] isPrime;
	static int[] primeNum = new int[1000];
	static int cnt;

	static void primecheck() {
		cnt = 0;
		isPrime = new boolean[1000];
		isPrime[0] = isPrime[1] = true;
		for (int i = 2; i < 1000; i++) {
			if (!isPrime[i]) {
				primeNum[cnt++] = i;
				for (int j = i + i; j < 1000; j += i) {
					isPrime[j] = true;
				}
			}
		}
	}	
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Reader s = new Reader();
		primecheck();
		
//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// 5보다 큰 홀수 N은 세 소수의 합으로 나타낼 수 있다
			// 999까지 경우의 수 체크
			
			// 1. 999까지 소수를 체크한다
			// 2. 홀수 N을 
		
			
			sb.append(solve(s.nextInt(),0,0)).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int solve(int n, int idx, int depth) {
		if (depth == 3) {
            if (n == 0) {
                return 1;
            } else {
                return 0;
            }
        }
         
        int count = 0;
         
        for (int i = idx; i < cnt; i++) {
            if (n >= primeNum[i]) {
                count += solve(n - primeNum[i], i, depth + 1);
            } else {
                break;
            }
        }
         
        return count;
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