import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_3431_개구리점프_frogjump { // 제출일 2021-06-14 22:56

	static int n, q;
	static int[][] log;
	static int[] group;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		log = new int[n + 1][4];
		int x1, x2, y;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			log[i] = new int[] { x1, x2, y, i };
		}
		group = new int[n + 1];

		Arrays.sort(log, (o1, o2) -> o1[0] - o2[0]);
		int num = 0;
		int cnt = 0; // 그룹 번호
		for (int i = 1; i <= n; i++) {
			if (num < log[i][0]) {
				group[log[i][3]] = ++cnt; // 연결이 끊기면 다른 번호를 사용한다
				num = log[i][1];
			} else {
				group[log[i][3]] = cnt; // 서로 연결되는 그룹은 같은 번호를 갖는다
				num = Math.max(num, log[i][1]);
			}
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			if (group[q1] == group[q2]) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();

	}
}