import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 기존 제출일 2019-07-17 10:55 25,892 kb 210 ms
// 개선 제출일 2020-07-16 22:36 21,324 kb 167 ms
public class Solution_D3_5215_햄버거다이어트 {

	static int N, L, ans;
	static int[] score, calory;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		Reader s = new Reader();

//		int TC = Integer.parseInt(br.readLine());
		int TC = s.nextInt();
//		testcase: 
		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// 특정 칼로리 이하 조합에서 최대 점수 찾기
			N = s.nextInt(); // 재료 개수
			L = s.nextInt(); // 칼로리 제한
			score = new int[N];
			calory = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = s.nextInt();
				calory[i] = s.nextInt();
			}
			ans = 0;
			dfs(0, 0, 0);
			sb.append(ans).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int idx, int cal, int sco) {

		if (cal > L) {
			return;
		}

		if (idx == N) {
			ans = Math.max(ans, sco);
			return;
		}

		dfs(idx + 1, cal, sco); // 선택하지 않은 경우
		dfs(idx + 1, cal + calory[idx], sco + score[idx]);
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