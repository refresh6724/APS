import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Longest Common Subsequence 
 * https://www.youtube.com/watch?v=V5hZoJ6uK-s
 * https://hsp1116.tistory.com/37
 */

public class Solution_D3_3304_최장공통부분수열 { // 제출일 2020-06-29 23:25 25,108 kb 148 ms

	static int[][] memo = new int[1001][1001]; // 문자열 최대 길이 1000

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String[] line = br.readLine().split(" ");
			char[] left = line[0].toCharArray();
			char[] right = line[1].toCharArray();

			int ll = left.length;
			int rl = right.length;

			for (int i = 1; i <= ll; i++) {
				Arrays.fill(memo[i], 0);
			}

			for (int i = 1; i <= ll; i++) {
				for (int j = 1; j <= rl; j++) {
					if (left[i - 1] == right[j - 1]) {
						memo[i][j] = memo[i - 1][j - 1] + 1;
					} else {
						memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
					}
				}
			}

			answer.append('#').append(tc).append(' ').append(memo[ll][rl]).append("\n");
		}
		bw.write(answer.toString());
		bw.flush();
	}

}
