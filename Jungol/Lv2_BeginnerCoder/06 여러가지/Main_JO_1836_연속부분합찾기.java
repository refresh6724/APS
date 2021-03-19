import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1836_연속부분합찾기 { // 제출일 2021-03-19 22:39

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 연속부분합

		// 일반적인 해답 찾기
		// 1 2 -2 4
		// 1 3  1 5
		//   2  0 4
		//     -2 2
		//        4
		// O(n^2)

		// Kadane's Algorithm
		// O(n)

		int n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sb.append(max_subarray(arr));

		bw.write(sb.toString());
		bw.flush();
	}

	private static int max_subarray(int[] arr) {
		int best = 0;
		int current = 0;
		for (int x : arr) {
			current = Math.max(0, current + x);
			best = Math.max(best, current);
		}
		return best;
	}

}