import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_233_형성평가3 { // 제출일 2021-01-27 23:17

	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 자연수 N과 M을 입력받아서
		// 주사위를 N번 던져서 나온 눈의 합이 M이 나올 수 있는 모든 경우를 출력하는 프로그램을 작성하시오.
		// 단, N은 10 이하의 정수이다.

		// 3 10
		// 1 3 6
		// 1 4 5
		// 1 5 4
		// 1 6 3
		// 2 2 6
		// 2 3 5
		// …
		// 6 2 2
		// 6 3 1

		// 6^10 = 2^10 * 3^10 = 1024 * 59049 = 60466176

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		for (int start = 1; start <= 6; start++) {
			arr[0] = start;
			dfs(start, 1, start);
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int now, int cnt, int sum) {
		if (sum > m) {
			return;
		} else if (cnt == n) {
			if (sum == m) {
				print();
			}
			return;
		}

		for (int next = 1; next <= 6; next++) {
			arr[cnt] = next;
			dfs(next, cnt + 1, sum + next);
		}

	}

	private static void print() {
		sb.append(arr[0]);
		for (int i = 1; i < n; i++) {
			sb.append(' ').append(arr[i]);
		}
		sb.append('\n');
	}

}