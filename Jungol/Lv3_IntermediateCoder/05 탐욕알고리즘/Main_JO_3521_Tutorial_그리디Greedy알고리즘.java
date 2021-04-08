import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3521_Tutorial_그리디Greedy알고리즘 { // 제출일 2021-04-08 23:17

	static int[] arr = { 16, 8, 4, 2, 1 };
	static int[] coin;
	static int n, answer;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		coin = new int[5];
		for (int i = 4; i >= 0; i--) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		n = Integer.parseInt(st.nextToken());
		answer = 0;
	}

	private static void go() {
		int cnt = 0;
		for (int i = 0; i <= 4; i++) {
			while (coin[i] > 0) {
				if (n >= arr[i]) {
					n -= arr[i];
					coin[i] -= 1;
					cnt += 1;
				} else {
					break;
				}
			}
		}

		// 다 끝나고 n이 남아있다면 imp
		if (n != 0) {
			return;
		}
		answer = cnt;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append((answer == 0) ? "impossible" : answer);
		bw.write(sb.toString());
		bw.flush();
	}

}