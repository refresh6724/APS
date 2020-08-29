import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * 고스트로 n*n 사이즈의 저그 진영에 반경 m인 핵을 날리려고 한다
 * 가장 많은 적을 죽일 수 있는 경우는?
 */
public class NuclearLaunchDetected {
	
	static final int EMPTY = 0;
	static final int ENEMY = 1;

	public static void main(String[] args) throws Exception {
		Reader s = new Reader();
		int n = s.nextInt();
		int m = s.nextInt();

		ArrayList<Target> proposedSites = new ArrayList<>();
		int[][] input, save, load;
		input = new int[n][n];
		int detect = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				detect = s.nextInt();
				if (detect == ENEMY) {
					proposedSites.add(new Target(i, j));
				}
				input[i][j] = detect;
			}
		}
		save = deepCopy(input);

		//
		int killCnt, nr, nc;
		int maxKill = 0;
		for (Target target : proposedSites) {
			load = deepCopy(save);
			Queue<Target> q = new LinkedList<>();
			q.add(new Target(target.row, target.col, m));
			killCnt = 0;
			while (!q.isEmpty()) {
				target = q.poll();				
				if (target.len < 0 || load[target.row][target.col] == EMPTY) {
					continue;
				}
				killCnt++;
				load[target.row][target.col] = EMPTY;
				for (int i = 0; i < 4; i++) {
					nr = target.row + dr[i];
					nc = target.col + dc[i];
					if (nr < 0 || nr == n || nc < 0 || nc == n) {
						continue;
					}
					q.add(new Target(nr, nc, target.len - 1));
				}
			}
			maxKill = Math.max(maxKill, killCnt);
		}
		System.out.println(maxKill);
	}

	static <T> int[][] deepCopy(int[][] matrix) {
		return Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Target {
		int row;
		int col;
		int len;

		public Target() {
			// TODO Auto-generated constructor stub
		}

		public Target(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public Target(int row, int col, int len) {
			super();
			this.row = row;
			this.col = col;
			this.len = len;
		}

	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream dis;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			dis = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		private void fillBuffer() throws IOException {
			bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) {
				buffer[0] = -1;
			}
		}

		public byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				fillBuffer();
			}
			return buffer[bufferPointer++];
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length가 64자 인 것으로 가정
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					break;
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return ret;
		}
	}

}