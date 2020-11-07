import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/3009
 */
public class Main_BOJ_3009_네번째점 { // 제출일 2020-11-07 23:08

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 직사각형의 세 점이 주어질 때 네번째 점의 좌표를 출력
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");
			x[i] = Integer.parseInt(input[0]);
			y[i] = Integer.parseInt(input[1]);
		}
		int xx = 0;
		int yy = 0;
		if (x[0] == x[1]) {
			xx = x[2];
		} else if (x[0] == x[2]) {
			xx = x[1];
		} else if (x[1] == x[2]) {
			xx = x[0];
		}
		if (y[0] == y[1]) {
			yy = y[2];
		} else if (y[0] == y[2]) {
			yy = y[1];
		} else if (y[1] == y[2]) {
			yy = y[0];
		}
		System.out.println(String.format("%d %d", xx, yy));
	}
}
