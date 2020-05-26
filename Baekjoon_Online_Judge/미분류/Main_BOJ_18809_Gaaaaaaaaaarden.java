import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


// 최초 제출일 2020-05-25 16:27 283560 kb 4204 ms
// 2차 제출일 2020-05-26 23:47 283772 kb 4316 ms 
// 3차 제출일 2020-05-27 00:30 282916 kb 1696 ms
// 4차 제출일 2020-05-27 00:34 281316 kb 764 ms
// 11차 제출일 2020-05-27 05:03 279256 kb 744 ms

public class Main {

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

	static int N, M, G, R, Y, max, flower;
	static int[] map, wmap, bmap, dm, Yellow = new int[10];
	static Queue<Integer> rq, gq;
	static char[] seedOrder;

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		// 첫쨰줄
		N = s.nextInt();
		M = s.nextInt() + 2;
		G = s.nextInt();
		R = s.nextInt();

		dm = new int[] { -M, M, -1, 1 }; // 상하좌우

		map = new int[N * M];
		int a = 0;
		Y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M - 1; j++) {
				a = s.nextInt();
				if (a == 2) { // 2500번 중 최대 10번
					Yellow[Y++] = i * M + j;
					map[i * M + j] = 1; // map에는 0과 1만 존재
				} else {
					map[i * M + j] = a;
				}
			}
		}

		// 사방이 얼마나 뚫려있는지 확인할 맵
		wmap = new int[N * M];
		for (int i = 0; i < N * M; i++) {
			for (int j = 0; j < 4; j++) {
				int ni = i + dm[j];
				if (ni < 0 || ni >= N * M) {
					continue;
				}
				if (map[ni] != 0) {
					wmap[i]++;
				}
			}
		}

		// 1단계 dfs
		seedOrder = new char[Y];
		Arrays.fill(seedOrder, 'X');
		// 최대 yellow n개중 땅 고르기가 R+G개
		// nCr * n-rCg 경우의 수
		max = 0;
		dfs(0, 0, 0, G + R);
		System.out.println(max);
	}

	private static void dfs(int idx, int red, int green, int rest) {
		if (red == R && green == G) {
			bfs();
			return;
		}
		if (idx == Y || idx > Y - rest || red > R || green > G) {// 남은개수 == (R - red) + (G - green)
			return;
		}

		// X-X-R-R-O

		seedOrder[idx] = 'R';
		dfs(idx + 1, red + 1, green, rest - 1);
		seedOrder[idx] = 'G';
		dfs(idx + 1, red, green + 1, rest - 1);
		seedOrder[idx] = 'X';
		dfs(idx + 1, red, green, rest);

	}

	private static void bfs() {
		bmap = map.clone();
		// bmap에서 0은 호수, 1은 통과 가능, 2를 green으로 간주하고 같은 턴에 red가 뿌려질때 2라면 f++ 하고 4로 변경
		flower = 0;
		// 다음턴에 사방탐색을 해야하는 배양액 위치
		rq = new LinkedList<Integer>();
		gq = new LinkedList<Integer>();

		// 배양액 초기 위치 설정
		int x = 0, nx = 0;
		for (int i = 0; i < Y; i++) {
			x = Yellow[i];
			if (seedOrder[i] == 'R') {
				rq.add(x);
				bmap[x] = 0; // 배양액이 뿌려진 곳은 사방 탐색에서 제외된다
			} else if (seedOrder[i] == 'G') {
				gq.add(x);
				bmap[x] = 0; // 배양액이 뿌려진 곳은 사방 탐색에서 제외된다
			}
		}

		while (!rq.isEmpty() && !gq.isEmpty()) { // rq가 비어있지 않아야 하고 && gq도 비어있지 않아야 한다

			int rsize = rq.size();
			int gsize = gq.size();

			for (int gs = 0; gs < gsize; gs++) {
				x = gq.poll();
				if (bmap[x] == 4) {
					continue; // 뿌려진곳에 꽃이 피었다면 스킵
				}
				bmap[x] = 0; // 이전에 배양액이 뿌려진 곳을 0처리
				nx = 0;
				// 사방 탐색
				for (int i = 0; i < 4; i++) {
					nx = x + dm[i];
					if (nx < 0 || nx >= N * M) {
						continue;
					}
					if (wmap[nx] == 1) {
						bmap[nx] = 0;
					} else if (bmap[nx] == 1) {
						bmap[nx] = 2;
						gq.add(nx);
					}
				}
			}

			for (int rs = 0; rs < rsize; rs++) {
				x = rq.poll();
				nx = 0;
				// 사방 탐색
				for (int i = 0; i < 4; i++) {
					nx = x + dm[i];
					if (nx < 0 || nx >= N * M) {
						continue;
					}
					if (wmap[nx] == 1) {
						bmap[nx] = 0;
					} else if (bmap[nx] == 1) {// 0이면 호수고 1이면 red 뿌리기 2라면 꽃이 핀다 4
						bmap[nx] = 0;
						rq.add(nx);
					} else if (bmap[nx] == 2) {
						bmap[nx] = 4;
						flower++;
					}
				}
			}
		}

		if (max < flower) {
			max = flower;
		}
	}
}