import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11054
 */
public class Main_BOJ_11054_가장긴바이토닉부분수열 { // 제출일 2020-12-27 23:10 176 ms => nlogn 으로 바꿀 경우 144 ms

	static int[] left, right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// LIS를 두 번 한다?
		// 정점 위치를 정하고 좌우로 한번씩 2*n^2 + n
		//
		int n = Integer.parseInt(br.readLine()); // 최대 1000
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		left = new int[n];
		Arrays.fill(left, 1);

		// i번째에 대해 0~i-1 번까지의 수보다 크고 가장 긴 값을 선택 => n^2
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (num[i] > num[j] && left[i] <= left[j]) {
					left[i] = left[j] + 1;
				}
			}
		}

		right = new int[n];
		Arrays.fill(right, 1);
		// i번째에 대해 i+1 ~ n-1 번까지의 수보다 크고 긴 값을 선택 => n^2
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (num[i] > num[j] && right[i] <= right[j]) {
					right[i] = right[j] + 1;
				}
			}
		}

		// 정점의 위치에 따라 n번
		int max = 0;
		for (int top = 0; top < n; top++) {
			max = Math.max(max, left[top] + right[top]);
		}

		System.out.println(max - 1);
	}
}
