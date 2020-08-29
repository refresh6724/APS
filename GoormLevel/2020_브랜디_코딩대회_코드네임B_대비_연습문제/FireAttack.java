import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 쥐가 불에 타죽지 않으려면 
 * 땅을 파서 불이 닿지 않게 해야한다 
 * 어디를 파야 제일 좋을까?
 */
public class FireAttack {

	static final int NONE = 0;
	static final int WATER = 1;
	static final int FIRE = 2;
	static final int MOUSE = 3;

	static int[][] ground;
	static int[][] mapSave;
	static int[][] mapLoad;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		/* step 1 */
		int n = Integer.parseInt(br.readLine());
		ground = new int[n + 2][n + 2];
		Arrays.fill(ground[0], 1);
		Arrays.fill(ground[n + 1], 1);
		for (int i = 1; i <= n; i++) {
			ground[i][0] = 1;
			ground[i][n + 1] = 1;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mapSave = deepCopy(ground);

		/* step 2 */
		// 이 부분은 불과 쥐로 나누어 2번 돌리고
		// 쥐가 불보다 빠른 장소만 li에 넣어도 같은 결과를 얻을 수 있다.
		LinkedList<Node> li = new LinkedList<>();
		Node node;
		int row, col, type;
		int nr, nc;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 1, FIRE));
		q.add(new Node(n, n, MOUSE));
		while (!q.isEmpty()) {
			node = q.poll();
			if (node.type == FIRE) {
				switch (ground[node.row][node.col]) {
				case FIRE:
					continue;
				case MOUSE:
					li.add(node); // break; 쓰지 않는다
				case NONE:
					ground[node.row][node.col] = FIRE;
				}
			} else { // node.type == MOUSE &&
				switch (ground[node.row][node.col]) {
				case FIRE:
					continue;
				case MOUSE:
					continue;
				case NONE:
					ground[node.row][node.col] = MOUSE;
				}
			}

			for (int i = 0; i < 4; i++) {
				nr = node.row + dr[i];
				nc = node.col + dc[i];
				if (ground[nr][nc] != WATER) {
					q.add(new Node(nr, nc, node.type));
				}
			}
		}

		/* step 3 */
		int safe = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (ground[i][j] == MOUSE || ground[i][j] == NONE) {
					cnt++;
				}
			}
		}
		safe = Math.max(safe, cnt);

		/* step 4 */
		for (Node c : li) {
			mapLoad = deepCopy(mapSave);
			mapLoad[c.row][c.col] = 1;

			row = 1;
			col = 1;
			type = FIRE;

			node = new Node(row, col, type);
			q.add(node);

			while (!q.isEmpty()) {
				node = q.poll();
				if (mapLoad[node.row][node.col] != FIRE) {
					mapLoad[node.row][node.col] = FIRE;
					for (int i = 0; i < 4; i++) {
						nr = node.row + dr[i];
						nc = node.col + dc[i];
						if (mapLoad[nr][nc] != WATER) {
							q.add(new Node(nr, nc, node.type));
						}
					}
				}
			}

			cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (mapLoad[i][j] == MOUSE || mapLoad[i][j] == NONE) {
						cnt++;
					}
				}
			}
			safe = Math.max(safe, cnt);
		}

		System.out.println(safe);
	}

	static <T> int[][] deepCopy(int[][] matrix) {
		return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
	}

	static class Node {
		int row;
		int col;
		int type;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int row, int col, int type) {
			super();
			this.row = row;
			this.col = col;
			this.type = type;
		}

	}

}