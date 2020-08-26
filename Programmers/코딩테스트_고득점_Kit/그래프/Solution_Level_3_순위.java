import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_Level_3_순위 { // 제출일 2020-08-26 23:20

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } })); // 2
	}

	public static int solution(int n, int[][] results) {

		// n 은 100 이하
		// results 길이는 4500 이하
		// {a, b}는 a가 b를 이겼다는 의미

		int[][] score = new int[n + 1][n + 1];
		for (int i = 0; i < results.length; i++) {
			score[results[i][0]][results[i][1]] = 1; // win
			score[results[i][1]][results[i][0]] = -1; // lose
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (score[i][j] == 0 && score[i][k] == score[k][j]) {
						// 0 0 인 경우 0을 만드는 것을 방지
						score[i][j] = score[i][k];
					}
				}
			}
		}
		int ret = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (score[i][j] != 0) {
					cnt++;
				}
			}
			if (cnt == n - 1) {
				ret++;
			}
		}
		return ret;
	}

}