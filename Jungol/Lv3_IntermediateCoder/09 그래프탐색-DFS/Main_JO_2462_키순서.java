import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_2462_키순서 { // 제출일 2021-05-26 23:41

	static int n, m, ans;
	static List<List<Integer>> smaller, bigger;
	static boolean[][] big, small;
	static boolean[] visited;
	static int[] visit, cnt;

	public static void main(String[] args) throws Exception {
		input();
//		run_1(); // 중복 계산으로 인해 시간 초과 < 2초
//		run_2(); // 중복 계산으로 인해 시간 초과 < 2초
//		run_3(); // up과 down을 한번에 하도록 압축
		run_4(); // 변수를 하나로 압축
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생들의 수 2 이상 500 이하
		m = Integer.parseInt(st.nextToken()); // 비교횟수 0 이상 n(n-1)/2 이하
//		n = Integer.parseInt(br.readLine().trim()); // 학생들의 수 2 이상 500 이하
//		m = Integer.parseInt(br.readLine().trim()); // 비교횟수 0 이상 n(n-1)/2 이하
		smaller = new ArrayList<>(n + 1);
		bigger = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			smaller.add(new ArrayList<>());
			bigger.add(new ArrayList<>());
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			// a번 학생이 b번 학생보다 키가 작다 a<b a=>b
			smaller.get(a).add(b); // a is smaller than b
			bigger.get(b).add(a);
		}
		ans = 0;
		big = new boolean[n + 1][n + 1];
		small = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		visit = new int[n + 1];
		cnt = new int[n + 1];
	}

	private static void run_4() {
		for (int start = 1; start <= n; start++) {
			dfs_4(start, start);
		}
		for (int start = 1; start <= n; start++) {
			if (cnt[start] == n - 1) {
				ans++;
			}
		}
	}

	private static void dfs_4(int start, int now) {
		visit[now] = start;
		for (int next : smaller.get(now)) {
			if (visit[next] < start) { // start 이전에 방문했다면 추가로 방문
				cnt[start]++;
				cnt[next]++;
				dfs_4(start, next);
			}
		}
	}

	private static void run_3() {
		for (int start = 1; start <= n; start++) {
			visited = new boolean[n + 1];
			dfs_3(start, start);
		}
		for (int start = 1; start <= n; start++) {
			countupdown(start);
		}
	}

	private static void dfs_3(int start, int now) {
		visited[now] = true;
		for (int next : smaller.get(now)) {
			small[start][next] = true;
			big[next][start] = true;
			dfs_3(start, next);
		}
	}

	private static void run_2() {
		for (int start = 1; start <= n; start++) {
			for (int child : smaller.get(start)) {
				dfs_down(start, child);
			}
			for (int parent : bigger.get(start)) {
				dfs_up(start, parent);
			}
			countupdown(start);
		}
	}

	private static void dfs_up(int start, int child) {
		big[start][child] = true;
		for (int parent : bigger.get(child)) {
			dfs_up(start, parent);
		}
	}

	private static void dfs_down(int start, int parent) {
		small[start][parent] = true;
		for (int child : smaller.get(parent)) {
			dfs_down(start, child);
		}
	}

	private static void run_1() {
		// 특정 노드 a에 대해 a보다 작은 사람과 큰 사람을 합한 수가 n-1 이면 자신의 키가 몇 번째인지 알 수 있다
		LinkedList<Integer> li = new LinkedList<>();
		for (int i = 0; i <= n; i++) {
			li.add(i);
			down(li, i);
			up(li, i);
			li.pollLast();
		}

		for (int i = 1; i <= n; i++) {
			countupdown(i);
		}
	}

	private static void countupdown(int i) {

		int s = 0;
		int b = 0;
		for (int j = 1; j <= n; j++) {
			if (small[i][j]) {
				s++;
			}
			if (big[i][j]) {
				b++;
			}
		}

//		System.out.println(String.format("%d보다 작은 수는 %d, 큰 수는 %d 개 이다\n", i, b, s));

		if (s + b == n - 1) {
			ans++;
		} else if (s + b > n - 1) {
			System.out.println("error");
		}
	}

	private static void up(LinkedList<Integer> li, int a) {

		for (int b : bigger.get(a)) {
			for (int in : li) {
				big[in][b] = true;
			}
			li.add(b);
			up(li, b);
			li.pollLast();
		}
	}

	private static void down(LinkedList<Integer> li, int a) {

		for (int b : smaller.get(a)) {
			for (int in : li) {
				small[in][b] = true;
			}
			li.add(b);
			down(li, b);
			li.pollLast();
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