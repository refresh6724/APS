import java.util.Arrays;

public class Solution_Level_1_상호평가 { // 제출일 2021-08-11 23:55

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 70, 49, 90 }, { 68, 50, 38 }, { 73, 31, 100 } }));
	}

	public static String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		int len = scores.length;
		for (int col = 0; col < len; col++) {
			int self = scores[col][col];
			int[] score = new int[len];
			for (int row = 0; row < len; row++) {
				score[row] = scores[row][col];
			}
			Arrays.sort(score);
			int sum = Arrays.stream(score).sum();
			int mean = sum / len;
			if ((self == score[0] && score[0] != score[1]) || (self == score[len - 1] && score[len - 1] != score[len - 2])) {
				mean = (sum - self) / (len - 1);
			}
			sb.append(grade(mean));
		}
		return sb.toString();
	}

	private static String grade(int mean) {
		if (mean >= 90) {
			return "A";
		} else if (mean >= 80) {
			return "B";
		} else if (mean >= 70) {
			return "C";
		} else if (mean >= 50) {
			return "D";
		} else {
			return "F";
		}
	}
}
