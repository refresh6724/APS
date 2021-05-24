import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1840_치즈 { // 제출일 2021-05-24 23:22

	static int n, m, time, airContact;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		time = 0;
		airContact = 0;
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void go() {
		while (findAirContact()) { // 공기접촉면을 2로 설정한다
			time++;
			countAirContact();// 2로 설정된 공기접촉면을 0으로 바꾸면서 숫자를 센다
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static boolean findAirContact() {
		// 공기접촉면이 없다면 false를 리턴한다
		boolean find = false;
		int nr = 0;
		int nc = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] p = q.poll();
			if (!visited[p[0]][p[1]]) {
				visited[p[0]][p[1]] = true;
				switch (map[p[0]][p[1]]) {
				case 0:
					for (int i = 0; i < 4; i++) {
						nr = p[0] + dr[i];
						nc = p[1] + dc[i];
						if (nr < 0 || nc < 0 || nr == n || nc == m || visited[nr][nc]) {
							continue;
						}
						q.add(new int[] { nr, nc });
					}
					break;
				case 1:
					map[p[0]][p[1]] = 2;
					find = true;
					break;
				case 2:
					break;
				}
			}
		}
		return find;
	}

	private static void countAirContact() {
		airContact = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					airContact++;
				}
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(time).append('\n').append(airContact);
		bw.write(sb.toString());
		bw.flush();
	}

}