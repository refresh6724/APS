import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_1144_줄세우기 { // 제출일 2021-06-22 23:44

	static int n;
	static int[] arr, memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim()); // 아이들의 수 2 이상 200 이하
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		memo = new int[n + 1];
	}

	// 최소 이동으로 정렬하기
	private static void go() throws Exception {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		int max = -1;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, memo[i]);
		}
		int ans = n - 1 - max;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}