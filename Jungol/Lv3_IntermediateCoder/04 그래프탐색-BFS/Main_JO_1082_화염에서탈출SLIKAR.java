import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1082_화염에서탈출SLIKAR { // 제출일 2021-04-07 23:57

	// 맵은 R행 C열
	// 시작 'S' 도착 'D'
	// 비어있는 칸 '.' 불 '*' 바위 'X'
	static class Node {
		int r;
		int c;
		char type;
		int step;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c, char type, int step) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			this.step = step;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [r=").append(r).append(", c=").append(c).append(", type=").append(type).append(", step=").append(step).append("]");
			return builder.toString();
		}
		
		

	}

	static int r, c, answer;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Node> move, fire;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		input();
		run();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;

		map = new char[r][];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[r][c];

		move = new LinkedList<>();
		fire = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S') {
					move.add(new Node(i, j, 'S', 0));
				} else if (map[i][j] == '*') {
					fire.add(new Node(i, j, '*', 0));
				}
			}
		}
		fire.add(move.poll());
//		int f = fire.size();
//		for (int i = 0; i < f; i++) {
//			move.add(fire.poll());
//		}
	}

	private static void run() {
		int nr = 0;
		int nc = 0;
		while (!move.isEmpty()) {
			Node node = move.poll();				
			if(node.type == '*') {
				if(map[node.r][node.c] == 'D') {
					continue;
				}
				map[node.r][node.c] = '*';					
			} else if(node.type == 'S') {
				if(map[node.r][node.c] == '*') {
					continue;
				}
				if (map[node.r][node.c] == 'D') {
					answer = node.step;
					return;
				}
				map[node.r][node.c] = 'S';
				visited[node.r][node.c] = true;
			}
						
			for (int i = 0; i < 4; i++) {
				nr = node.r + dr[i];
				nc = node.c + dc[i];
				if(nr < 0 || nc < 0 || nr == r || nc == c || map[nr][nc] == 'X' || map[nr][nc] == '*' || visited[nr][nc]) {
					continue;
				}				
				move.add(new Node(nr, nc, node.type, node.step+1));			
			}
		}
	}


	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append((answer == 0) ? "impossible" : answer);
		bw.write(sb.toString());
		bw.flush();
	}

}
