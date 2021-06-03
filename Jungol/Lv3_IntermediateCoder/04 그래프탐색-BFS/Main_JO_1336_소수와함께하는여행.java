import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1336_소수와함께하는여행 { // 제출일 2021-06-03 23:10

	static int start, end, ans;
	static boolean[] isPrime;
	static List<List<Integer>> path;
	static boolean[] visited;
	static Queue<Node> q;

	static class Node {
		int num;
		int x;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int num, int x) {
			super();
			this.num = num;
			this.x = x;
		}

	}

	static void findPrime() {
		isPrime = new boolean[10000];

		for (int i = 2; i < 10000; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < 10000; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < 10000; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		path = new ArrayList<>(10000);
		for (int i = 0; i < 10000; i++) {
			path.add(new LinkedList<>());
		}

		visited = new boolean[10000];

	}

	// 1000 이상 9999 이하 소수 네자리 start에서 출발해
	// 해밍 길이가 1인 소수 경로를 통해 end에 도착하는 가장 빠른 경로찾기
	private static void go() {

		findPrime();

		findPath();

		bfs();

	}

	private static void findPath() {

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		for (int i = 1000; i < 10000; i++) {
			if (isPrime[i]) {
				a = i % 1000;
				b = (i / 1000) * 1000 + i % 100;
				c = (i / 100) * 100 + i % 10;
				d = (i / 10) * 10;

				int j = 0;
				int cnt = 0;
				for (j = a + 1000, cnt = 0; j < 10000 && cnt < 10; j += 1000, cnt++) {
					if (j != i && isPrime[j]) {
						path.get(i).add(j);
					}
				}
				for (j = b, cnt = 0; j < 10000 && cnt < 10; j += 100, cnt++) {
					if (j != i && isPrime[j]) {
						path.get(i).add(j);
					}
				}
				for (j = c, cnt = 0; j < 10000 && cnt < 10; j += 10, cnt++) {
					if (j != i && isPrime[j]) {
						path.get(i).add(j);
					}
				}
				for (j = d, cnt = 0; j < 10000 && cnt < 10; j += 1, cnt++) {
					if (j != i && isPrime[j]) {
						path.get(i).add(j);
					}
				}
			}
		}

	}

	private static void bfs() {

		q = new LinkedList<Node>();
		q.add(new Node(start, 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (!visited[node.num]) {
				visited[node.num] = true;
				if (node.num == end) {
					ans = node.x;
					return;
				}
				for (int next : path.get(node.num)) {
					if (!visited[next]) {
						q.add(new Node(next, node.x + 1));
					}
				}
			}
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}