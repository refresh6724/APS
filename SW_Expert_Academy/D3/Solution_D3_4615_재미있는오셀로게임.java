import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 { // 제출일 2020-07-11 23:42 25,712 kb 99 ms

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향으로
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

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

			int N = s.nextInt(); // 4, 6, 8
			int[][] map = new int[N + 2][N + 2]; // 겉 한바퀴를 감싼다

			// 백돌 2 흑돌 1
			// 가운데 21 12
			int hN = N >> 1;
			map[hN][hN] = 2;
			map[hN + 1][hN] = 1;
			map[hN][hN + 1] = 1;
			map[hN + 1][hN + 1] = 2;

			int M = s.nextInt();

			// 돌을 놓는다
			// col row 백2 흑1
			for (int i = 0; i < M; i++) {
				int col = s.nextInt();
				int row = s.nextInt();
				int dol = s.nextInt();
				map[row][col] = dol;
				// 가로 세로 대각선으로 바로 다음칸에 해당하는 곳에 dol과 다른 돌이 놓여있다면
				// 다음칸이 같은 색인지 확인하고 같은 색이라면 다시 그 다음칸으로 이동하고
				// 다음칸이 같은 색이 아니라면 지금까지 지나온 돌을 모두 뒤집는다
				// 다음칸이 0 이라면 아무것도 하지 않는다

				for (int j = 0; j < 8; j++) { // 8방 확인
					int nc = col + dc[j];
					int nr = row + dr[j];
					int nd = map[nr][nc];

					while (nd != 0 && nd != dol) { // 흑돌을 뒀다면 백돌만 나오다가 흑돌이 나오면 스탑
						nc += dc[j];
						nr += dr[j];
						nd = map[nr][nc];
					}
					// if(nd == 0) {} // 아무일도 없다
					if (nd == dol) { // 같은 돌이라면 row col 부터 nr nc까지 dol로 바꿔준다
						for (int tmpcol = col + dc[j], tmprow = row + dr[j]; (tmpcol != nc)
								|| (tmprow != nr); tmpcol += dc[j], tmprow += dr[j]) {
							map[tmprow][tmpcol] = dol;
						}
					}
				}
			}

			// 게임이 끝나면

			int black = 0;
			int white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1) {
						black++;
					} else if (map[i][j] == 2) {
						white++;
					}
				}
			}

			sb.append(black).append(' ').append(white).append('\n');

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