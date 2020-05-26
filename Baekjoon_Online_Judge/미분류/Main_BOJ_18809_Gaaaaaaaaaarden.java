import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최초 제출일 2020-05-25 16:27 283560 kb 4204 ms
// 2차 제출일 2020-05-26 23:47 283772 kb 4316 ms 

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
	static int[][] map, bmap, rmap, gmap, fmap;
	static ArrayList<Node> Yellow;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		// 첫쨰줄
		N = s.nextInt();
		M = s.nextInt();
		G = s.nextInt();
		R = s.nextInt();

		Yellow = new ArrayList<>();

		map = new int[N][M];
		for (int i = 0; i < N; i++) { // row			
			for (int j = 0; j < M; j++) { // col
				int a = s.nextInt();
				map[i][j] = a;
				if (a == 2) {
					Yellow.add(new Node(i, j)); // row, col
				}
			}
		}

		// 1단계 dfs
		Y = Yellow.size();
		seedOrder = new char[Y];
		// 최대 yellow n개중 땅 고르기가 R+G개
		// nCr * n-rCg 경우의 수
		max = 0;
		dfs(0, 0, 0, R + G);
		System.out.println(max);
	}

	static char[] seedOrder;

	private static void dfs(int idx, int red, int green, int 남은개수) {
		if (red == R && green == G) {
			// 2단계 bfs
			bmap = new int[N][M];
			mapclone();
			bfs();
			return;
		}
		if (idx == Y || idx > Y - 남은개수 || red > R || green > G) {// 남은개수 == (R - red) + (G - green)
			return;
		}

		// X-X-R-R-O

		seedOrder[idx] = 'R';
		dfs(idx + 1, red + 1, green, 남은개수 - 1);
		seedOrder[idx] = 'G';
		dfs(idx + 1, red, green + 1, 남은개수 - 1);
		seedOrder[idx] = 'X';
		dfs(idx + 1, red, green, 남은개수);

	}

	private static void mapclone() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bmap[i][j] = map[i][j]; // 50*50번
			}
		}
	}

	static Queue<Node> rq, gq;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		flower = 0;
		fmap = new int[N][M];
		rmap = new int[N][M];
		gmap = new int[N][M];
		// 다음턴에 사방탐색을 해야하는 배양액 위치
		rq = new LinkedList<Node>();
		gq = new LinkedList<Node>();

		// 배양액 초기 위치 설정
		for (int i = 0; i < Y; i++) {
			int r = Yellow.get(i).r;
			int c = Yellow.get(i).c;
			if (seedOrder[i] == 'R') {
				rq.add(new Node(r, c));
				bmap[r][c] = 0; // 배양액이 뿌려진 곳은 사방 탐색에서 제외된다
			} else if (seedOrder[i] == 'G') {
				gq.add(new Node(r, c));
				bmap[r][c] = 0; // 배양액이 뿌려진 곳은 사방 탐색에서 제외된다
			}
		}

		//
		int thisTurn = 1;
		while (!rq.isEmpty() && !gq.isEmpty()) { // rq가 비어있지 않아야 하고 && gq도 비어있지 않아야 한다

			int rsize = rq.size();
			int gsize = gq.size();

			for (int gs = 0; gs < gsize; gs++) {
				Node node = gq.poll();
				int r = node.r;
				int c = node.c;
				if (fmap[r][c] != 0) {
					continue;
				}
				int nr = 0;
				int nc = 0;
				// 사방 탐색
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && bmap[nr][nc] != 0 // bmap이 호수나 꽃이 아니어야 하고
							&& gmap[nr][nc] == 0) { // 이전에 방문한 적이 없어야 한다.
						gmap[nr][nc] = thisTurn; // 방문 시각을 기록한다
					}
				}
			}

			for (int rs = 0; rs < rsize; rs++) {
				Node node = rq.poll();
				int r = node.r;
				int c = node.c;
				if (fmap[r][c] != 0) {
					continue;
				}
				int nr = 0;
				int nc = 0;
				// 사방 탐색
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && bmap[nr][nc] != 0 // 다음 방문 장소가 호수나 꽃이 아니어야 하고
							&& rmap[nr][nc] == 0) { // 기존에 방문한 적이 없어야 한다
						rmap[nr][nc] = thisTurn; // 방문시간을 기록하고
						if (gmap[nr][nc] == thisTurn) { // 만약 green이 같은 시간에 뿌려졌을때
							if (fmap[nr][nc] == 0) { // 꽃이 핀적이 없는 장소라면
								fmap[nr][nc] = 1; // 꽃을 피운다
								flower++;
							}
						} else {
							rq.add(new Node(nr, nc)); // green과 연관이 없다면 새로운 전파장소로 등록한다
						}

					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (gmap[i][j] == thisTurn) {
						gq.add(new Node(i, j));
					}
				}
			}

			thisTurn++;
		}

		if (max < flower) {
			max = flower;
		}
	}
}