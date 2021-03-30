import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1459_숫자고르기 { // 제출일 2021-03-30 23:55

	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		n = Integer.parseInt(br.readLine()); // 최대 100
		// 넣는다 넣지 않는다 이지선다 2^100 가지 경우의 수
		arr = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 시작 숫자에서 꼬리물기가 발생하면 == 다시 돌아오면 체크
		for (int i = 1; i <= n; i++) {
			if (follow(i)) {
				visited[i] = visited[arr[i]] = true;
			}
		}

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

	private static boolean follow(int i) {
		int start = i;
		int next = arr[i];
		for (int j = 0; j < n; j++) { // 무한루프 방지용 최대 n번만 따라가기
			if (start == next) {
				return true;
			}
			next = arr[next];
		}
		return false;
	}

}