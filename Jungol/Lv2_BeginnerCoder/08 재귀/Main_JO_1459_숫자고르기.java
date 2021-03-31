import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1459_숫자고르기 { // 제출일 2021-03-31 00:44

	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		check();
		output();
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				ans++;
			}
		}
		sb.append(ans).append('\n');
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				sb.append(i).append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static void check() {
		// 시작 숫자에서 꼬리물기가 발생하면 == 다시 돌아오면 체크
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				follow(i);
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 최대 100
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void follow(int i) {
		// 개선방향 : follow 중 만난 숫자를 모두 true로 체크하고
		// true로 리턴될 경우 바로 전에 visited에 기록하기
		// follow 시작 전에 visited인 경우 넘어가기
		int start = i;
		int next = arr[i];
		for (int j = 0; j < n; j++) { // 무한루프 방지용 최대 n번만 따라가기
			if (start == next) {
				// 되돌아왔을 경우 다시 next가 start가 될 때까지 visited를 true로 체크
				next = arr[i];
				for (int j2 = 0; j2 < n; j2++) {
					if (start == next) {
						visited[start] = true;
						break;
					}
					visited[next] = true;
					next = arr[next];
				}
				return;
			}
			next = arr[next];
		}
	}

}