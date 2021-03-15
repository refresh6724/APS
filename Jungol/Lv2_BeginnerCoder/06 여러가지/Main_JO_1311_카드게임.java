import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1311_카드게임 { // 제출일 2021-03-15 21:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		String a = "";
		int[] color = new int[5];
		int[] num = new int[5];
		for (int i = 0; i < 5; i++) {
			a = br.readLine();
			color[i] = a.charAt(0) - 'A';
			num[i] = a.charAt(2) - '0';
		}
		Arrays.parallelSort(color);
		Arrays.parallelSort(num);
		int score = 0;
		score = Math.max(score, condition_1(color, num) + 900);
		score = Math.max(score, condition_2(color, num) + 800);
		score = Math.max(score, condition_3(color, num) + 700);
		score = Math.max(score, condition_4(color, num) + 600);
		score = Math.max(score, condition_5(color, num) + 500);
		score = Math.max(score, condition_6(color, num) + 400);
		score = Math.max(score, condition_7(color, num) + 300);
		score = Math.max(score, condition_8(color, num) + 200);
		score = Math.max(score, condition_9(color, num) + 100);
		sb.append(score);

		bw.write(sb.toString());
		bw.flush();
	}

	private static int condition_9(int[] color, int[] num) {
		return num[4];
	}

	private static int condition_8(int[] color, int[] num) {
		if (num[0] == num[1]) {
			return num[0];
		} else if (num[1] == num[2]) {
			return num[1];
		} else if (num[2] == num[3]) {
			return num[2];
		} else if (num[3] == num[4]) {
			return num[3];
		}
		return -1000;

	}

	private static int condition_7(int[] color, int[] num) {
		// 00112 00122 01122
		if (num[0] == num[1]) {
			if (num[2] == num[3]) {
				return Math.max(num[0], num[2]) * 10 + Math.min(num[0], num[2]);
			} else if (num[3] == num[4]) {
				return Math.max(num[1], num[3]) * 10 + Math.min(num[1], num[3]);
			}
		}
		if (num[1] == num[2] && num[3] == num[4]) {
			return Math.max(num[1], num[3]) * 10 + Math.min(num[1], num[3]);
		}
		return -1000;
	}

	private static int condition_6(int[] color, int[] num) {
		// 00012 01112 01222
		if (num[0] == num[1] && num[1] == num[2]) {
			return num[0];
		}
		if (num[1] == num[2] && num[2] == num[3]) {
			return num[1];
		}
		if (num[2] == num[3] && num[3] == num[4]) {
			return num[2];
		}
		return -1000;
	}

	private static int condition_5(int[] color, int[] num) {
		if (isStraight(num)) {
			return num[4];
		}
		return -1000;
	}

	private static int condition_4(int[] color, int[] num) {
		if (isFlush(color)) {
			return num[4];
		}
		return -1000;
	}

	private static int condition_3(int[] color, int[] num) {
		// 풀하우스
		// 00111 00011
		if (num[0] == num[1] && num[1] != num[2] && num[2] == num[3] && num[3] == num[4]) {
			return num[2] * 10 + num[0];
		}
		if (num[0] == num[1] && num[1] == num[2] && num[2] != num[3] && num[3] == num[4]) {
			return num[0] * 10 + num[3];
		}
		return -1000;
	}

	private static int condition_2(int[] color, int[] num) {
		// 4장이 같다면 00001, 10000
		if (num[0] == num[1] && num[0] == num[2] && num[0] == num[3] && num[0] != num[4]) {
			return num[0];
		}
		if (num[0] != num[1] && num[1] == num[2] && num[1] == num[3] && num[1] == num[4]) {
			return num[1];
		}
		return -1000;
	}

	private static int condition_1(int[] color, int[] num) {
		if (isFlush(color) && isStraight(num)) {
			return num[4];
		}
		return -1000;
	}

	private static boolean isStraight(int[] num) {
		int a = num[0];
		for (int i = 1; i < num.length; i++) {
			if (a + i != num[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFlush(int[] color) {
		int a = color[0];
		for (int i = 1; i < color.length; i++) {
			if (a != color[i]) {
				return false;
			}
		}
		return true;
	}

}