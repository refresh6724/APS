import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1차 제출일 2020-07-26 23:55 19,908 kb 266 ms dfs
// 2차 제출일 2020-07-27 00:12 19,956 kb 115 ms dp

public class Solution_D3_5986_새샘이와세소수 { 

	static boolean[] isPrime = new boolean[1000];

	static void primeCheck() {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i < 1000; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < 1000; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	static int[] possibility = new int[1000];

	static void tripleNum() { // 중복조합을 방지하기 위해 x<=y<=z 조건
		for (int i = 2; i < 1000; i++) {
			if (isPrime[i]) {
				for (int j = i; i + j < 1000; j++) {
					if (isPrime[j]) {
						for (int k = j; i + j + k < 1000; k++) {
							if (isPrime[k]) {
								possibility[i + j + k]++;
							}
						}
					}
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
		primeCheck();
		tripleNum();

//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// 5보다 큰 홀수 N은 세 소수의 합으로 나타낼 수 있다
			// 999까지 경우의 수 체크

			// 1. 999까지 소수를 체크한다
			// 2. 모든 소수 조합의 경우에 대해서 3중 반복문으로 경우의 수를 체크한다

			sb.append(possibility[s.nextInt()]).append('\n');

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