import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2775
 */
public class Main_BOJ_2775_부녀회장이될테야 { // 제출일 2020-11-03 23:23

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] p = new int[15][15];
		for (int i = 1; i < 15; i++) {
			p[0][i] = i;
		}
		for (int floor = 1; floor < 15; floor++) {
			for (int room = 1; room < 15; room++) {
				p[floor][room] = p[floor][room - 1] + p[floor - 1][room];
			}
		}

		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(p[k][n]);
		}
	}
}
