import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14888_연산자끼워넣기 { // 제출일 2020-12-12 23:37

	static int n, max, min;
	static int[] a, op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		go(1, a[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void go(int idx, int sum) {
		if (idx == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i] -= 1;
				switch (i) {
				case 0:
					go(idx + 1, sum + a[idx]);
					break;
				case 1:
					go(idx + 1, sum - a[idx]);
					break;
				case 2:
					go(idx + 1, sum * a[idx]);
					break;
				case 3:
					go(idx + 1, sum / a[idx]);
					break;
				}
				op[i] += 1;
			}
		}
	}
}
