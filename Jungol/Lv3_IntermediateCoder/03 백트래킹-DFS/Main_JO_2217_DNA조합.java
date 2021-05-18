import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2217_DNA조합 { // 제출일 2021-05-19 01:10

	static int n, ans;
	static char[][] dna;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim()); // 2 이상 7 이하
		dna = new char[n][];
		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine().toCharArray();
		}
		map = new int[n][n];
		visited = new boolean[n];
		ans = Integer.MAX_VALUE;
	}

	private static void go() {
		// 순서 선택에 따른 경로는 n! 이 된다
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					map[i][j] = dna[j].length - calc(i, j);
				}
			}
		}
		int[] order = new int[n];
		for (int start = 0; start < n; start++) {
			visited[start] = true;
			order[0] = start;
			dfs(1, start, dna[start].length, order);
			visited[start] = false;
		}
	}

	private static void dfs(int cnt, int v, int sum, int[] order) {

		if (sum > ans) {
			return;
		}

		if (cnt == n) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int next = 0; next < dna.length; next++) {
			if (!visited[next]) {
				visited[next] = true;
				order[cnt] = next;
				dfs(cnt + 1, next, sum + map[v][next], order);
				visited[next] = false;
			}
		}

	}

	/**
	 * dna i와 j의 겹치는 부분의 길이를 리턴한다
	 * 
	 * @param i
	 * @param j
	 * @return 0 이상 j 이하
	 */
	private static int calc(int i, int j) {
		int len = dna[i].length;
		int cnt = dna[j].length;
		boolean isSame = false;
		while (cnt > 0) {
			if (len >= cnt) {
				isSame = true;
				for (int k = 0; k < cnt; k++) {
					if (dna[i][len - cnt + k] != dna[j][k]) {
						isSame = false;
						break;
					}
				}
			}
			if (isSame) {
				break;
			}
			cnt--;
		}
		return cnt;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}