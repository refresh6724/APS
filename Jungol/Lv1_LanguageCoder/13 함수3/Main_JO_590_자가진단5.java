import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_590_자가진단5 { // 제출일 2021-01-26 16:54

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 10 이하의 자연수 N을 입력받아 주사위를 N번 던져서 나올 수 있는 모든 경우를 출력하되 중복되는 경우에는 앞에서부터 작은 순으로 1개만
		// 출력하는 프로그램을 작성하시오.

		n = Integer.parseInt(br.readLine());
		// 3
		arr = new int[n];

		for (int next = 1; next <= 6; next++) {
			dfs(next, 1);
		}
//		1 1 1
//		1 1 2
//		...
//		1 1 6
//		1 2 2
//		1 2 3
//		...
//		5 6 6
//		6 6 6

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void dfs(int now, int step) {
		if (step == n) {
			for (int i = 0; i < n - 1; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append(now).append('\n');
			return;
		}

		arr[step - 1] = now;

		for (int next = now; next <= 6; next++) {
			dfs(next, step + 1);
		}
	}

}