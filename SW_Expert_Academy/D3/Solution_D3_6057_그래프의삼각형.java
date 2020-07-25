import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_6057_그래프의삼각형 { // 제출일 2020-07-25 23:38 23,992 kb 154 ms
	
	static int[][] map;
	static int ans;
		
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

			// 정점이 N개 간선이 M개
			int N = s.nextInt();
			int M = s.nextInt();
			
			// 이차원 배열
			map = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				map[x][y] = map[y][x] = 1;
			}
			
			// 3번 이동해서 제자리로 돌아오면 삼각형
			// 단, 시작 위치가 3번 이동하고 역방향이 있으므로 전체/6 이 삼각형의 개수가 된다
			ans = 0;
			for (int first = 1; first <= N; first++) {
				for (int second = 1; second <= N; second++) {
					for (int third = 1; third <= N; third++) {
						if(map[first][second] == 1
							&& map[second][third] == 1
							&& map[third][first] == 1){
								ans++;
							}
					}
				}			
			}
			
			sb.append(ans/6).append('\n');

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