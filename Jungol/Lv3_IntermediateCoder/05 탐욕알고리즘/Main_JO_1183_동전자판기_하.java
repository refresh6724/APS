import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1183_동전자판기_하 { // 제출일 2021-06-10 23:29

	static int w, t, ans;
	static int[] token, value, use, change;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		w = Integer.parseInt(br.readLine()); // 물건의 값
		t = 0;
		ans = 0;
		token = new int[6]; // 500원짜리 부터 100, 50, 10, 5, 1원의 개수, 각 10 이하 자연수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			token[i] = Integer.parseInt(st.nextToken());
			t += token[i];
		}
		value = new int[] { 500, 100, 50, 10, 5, 1 };
	}

	private static void go() {
		// 물건 구입에 사용할 최대 개수의 동전과 어떤 동전을 사용했는지 출력
		// 현재 동전으로 구할 수 있는 최댓값과 구해야 하는 값 w
		// 반대로 max - w 를 최소 동전으로 구한값의 반대 개수

		int max = 0;
		for (int i = 0; i < 6; i++) {
			max += token[i] * value[i];
		}
		max -= w;

		int idx = 0;
		while (max > 0 && idx < 6) {
			while (token[idx] > 0 && max - value[idx] >= 0) {
				token[idx] -= 1;
				max -= value[idx];
				ans += 1;
			}
			idx += 1;
		}

	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(t - ans).append('\n');
		sb.append(token[0]);
		for (int i = 1; i < 6; i++) {
			sb.append(' ').append(token[i]);
		}
		bw.write(sb.toString());
		bw.flush();
	}

}