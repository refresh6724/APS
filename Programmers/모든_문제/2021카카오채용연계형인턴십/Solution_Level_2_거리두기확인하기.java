import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2021년 05월 08일 카카오 2021년 여름방학 인턴십 코딩테스트
public class Solution_Level_2_거리두기확인하기 { // 제출일 2021-07-11 23:58

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" }, { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
				{ "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" }, { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } }))); // {1,0,1,1,1}

	}

	/**
	 * 맨해튼 거리 2 이하 금지<br>
	 * 거리두기를 잘 지키고 있다면 1 아니면 0<br>
	 * 
	 * @param places 대기실 개수 5 고정, 열 길이 5 고정, 각 P, O, X
	 * @return 1과 0을 int[] 배열에 담아 리턴
	 */
	public static int[] solution(String[][] places) {

		int[] ret = new int[5];
		for (int i = 0; i < 5; i++) {
			ret[i] = check(places[i]);
		}
		return ret;

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int sr;
		int sc;
		int r;
		int c;
		int len;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int sr, int sc, int r, int c, int len) {
			this.sr = sr;
			this.sc = sc;
			this.r = r;
			this.c = c;
			this.len = len;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [sr=").append(sr).append(", sc=").append(sc).append(", r=").append(r).append(", c=").append(c).append(", len=").append(len).append("]");
			return builder.toString();
		}

	}

	private static int check(String[] s) {
		Queue<Node> q = new LinkedList<>();

		int[][] map = new int[7][7];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[6], -1);
		for (int i = 1; i < 6; i++) {
			map[i][0] = -1;
			map[i][6] = -1;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (s[i].charAt(j) == 'X') {
					map[i + 1][j + 1] = -1;
				} else if (s[i].charAt(j) == 'O') {
					map[i + 1][j + 1] = 0;
				} else {
					map[i + 1][j + 1] = 1;
					q.add(new Node(i + 1, j + 1, i + 1, j + 1, 0));
				}
			}
		}
		int nr = 0;
		int nc = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.len == 2) {
				if (node.sr == node.r && node.sc == node.c) {
					continue;
				}
				if (map[node.r][node.c] == 1) {
					return 0;
				}
			} else if (node.len == 1) {
				if (map[node.r][node.c] == 1) {
					return 0;
				} else if (map[node.r][node.c] == 0) {
					for (int i = 0; i < 4; i++) {
						nr = node.r + dr[i];
						nc = node.c + dc[i];
						q.add(new Node(node.sr, node.sc, nr, nc, node.len + 1));
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					nr = node.r + dr[i];
					nc = node.c + dc[i];
					q.add(new Node(node.sr, node.sc, nr, nc, node.len + 1));
				}
			}
		}

		return 1;
	}

}
