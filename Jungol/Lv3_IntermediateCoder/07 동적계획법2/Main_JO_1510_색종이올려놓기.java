import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1510_색종이올려놓기 { // 제출일 2021-06-23 23:13

	static int n;
	static int[][] paper;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 종이의 수 1 이상 100 이하
		paper = new int[n + 1][3]; // 가로, 세로, 면적
		memo = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			paper[i][0] = Integer.parseInt(st.nextToken());
			paper[i][1] = Integer.parseInt(st.nextToken());
			if (paper[i][0] < paper[i][1]) {
				int tmp = paper[i][0];
				paper[i][0] = paper[i][1];
				paper[i][1] = tmp;
			}
			paper[i][2] = paper[i][0] * paper[i][1];
		}

		Arrays.sort(paper, (o1, o2) -> (o1[2] == o2[2]) ? (o1[0] - o2[0]) : (o1[2] - o2[2]));

	}

	// 변수가 2개인 LIS
	// 먼저 면적에 따라서 오름차순 나열
	// 가로가 세로보다 무조건 크도록 조정
	// 같은 크기라면 가로가 작은 종이가 먼저 나옴
	private static void go() throws Exception {

		for (int i = 1; i <= n; i++) {
			// j번째보다 i번째가 크기가 같거나 크다
			for (int j = 1; j < i; j++) {
				if (paper[j][0] <= paper[i][0] && paper[j][1] <= paper[i][1]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(Arrays.stream(memo).max().getAsInt() + 1);
		bw.write(sb.toString());
		bw.flush();

	}

}