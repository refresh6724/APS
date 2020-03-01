import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D0_4008_숫자만들기 { // 제출일 2020-03-01 14:49
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int n;
	static int plus, minus, mul, div;
	static int[] numbers;
	static int max, min;
	static int base;

	public static void main(String[] args) throws IOException {

		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			n = Integer.parseInt(br.readLine());
			symbol();
			number();
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			//

			dfs(0, base);

			//

			System.out.println("#" + t + " " + (max - min));
		}

	}

	private static void dfs(int step, int value) {
		if (step == n - 1) {
			if (value < min)
				min = value;
			if (value > max)
				max = value;
			return;
		}

		if (plus > 0) {
			plus--;
			dfs(step + 1, value + numbers[step]);
			plus++;
		}
		if (minus > 0) {
			minus--;
			dfs(step + 1, value - numbers[step]);
			minus++;
		}
		if (mul > 0) {
			mul--;
			dfs(step + 1, value * numbers[step]);
			mul++;
		}
		if (div > 0) {
			div--;
			dfs(step + 1, value / numbers[step]);
			div++;
		}

	}

	private static void number() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[n - 1];
		base = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n - 1; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void symbol() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
	}

}
