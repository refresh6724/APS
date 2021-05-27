import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1065
 */
public class Main_BOJ_1065_한수 { // 제출일 2020-10-17 23:13

	static int[] hansu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hansu = new int[1001];
		fillHansu();
		System.out.println(hansu[Integer.parseInt(br.readLine())]);
	}

	private static void fillHansu() {
		int stack = 0;
		for (int i = 1; i <= 1000; i++) {
			if (isHansu(i)) {
				stack++;
			}
			hansu[i] = stack;
		}
	}

	private static boolean isHansu(int i) {
		// 각 자리가 등차수열이라면 한수다
		int prev = i % 10;
		i = i / 10;
		int last = i % 10;
		int d = prev - last; // 공차
		while (i != 0) {
			prev = last;
			i = i / 10;
			last = i % 10;
			if (i == 0) {
				break;
			}
			if (d != prev - last) {
				return false;
			}
		}
		return true;
	}
}
