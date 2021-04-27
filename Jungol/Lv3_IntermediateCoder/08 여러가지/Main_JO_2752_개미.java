import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_2752_개미 { // 제출일 2021-04-27 23:38

	static int w, h, p, q, t, size;
	static List<Node> coord;
	static StringBuilder sb = new StringBuilder();

	static class Node {
		int r;
		int c;
		int ud;
		int lr;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c, int ud, int lr) {
			this.r = r;
			this.c = c;
			if (r == 0 || r == w) {
				this.ud = -ud;
			} else {
				this.ud = ud;
			}
			if (c == 0 || c == h) {
				this.lr = -lr;
			} else {
				this.lr = lr;
			}
		}

		@Override
		public String toString() {
			return String.format("%d %d\n", this.r, this.c);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		// greedy();
		xysplit();
		output();
	}

	private static void xysplit() {
		
		int x = (p+t)%(w*2);
		if(x > w) {
			x -= w*2;
			x *= -1;
		}
		int y = (q+t)%(h*2);
		if(y > h) {
			y -= h*2;
			y *= -1;
		}
		sb.append(x).append(' ').append(y).append('\n');
		
	}

	// 왼쪽 아래 좌표가 0,0
	// 오른쪽 위 좌표가 w,h
	// 시작 위치 p,q에서 오른쪽 위 45도 방향으로 출발
	// 벽에 닿으면 반대 방향으로 굴절

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken()); // 2 이상 4만 이하
		h = Integer.parseInt(st.nextToken()); //
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken()); // 1 이상 w 미만
		q = Integer.parseInt(st.nextToken()); // 1 이상 h 미만
		t = Integer.parseInt(br.readLine()); // 1 이상 20억 이하
		coord = new LinkedList<>();
	}

	private static void greedy() {
		Node node = new Node(p, q, 1, 1);
		coord.add(node);
		Node next = new Node(node.r + node.ud, node.c + node.lr, node.ud, node.lr);
		while (nextNodeisNotStartNode(next)) {
			coord.add(next);
			next = new Node(next.r + next.ud, next.c + next.lr, next.ud, next.lr);
		}
		size = coord.size();
		sb.append(coord.get(t % size));
	}

	private static boolean nextNodeisNotStartNode(Node next) {
		if (next.r != p || next.c != q || next.ud != 1 || next.lr != 1) {
			return true;
		}
		return false;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();
	}

}