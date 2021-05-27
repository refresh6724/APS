import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/5622
 */
public class Main_BOJ_5622_다이얼 { // 제출일 2020-10-25 23:14

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 알파벳 대문자 2~15문자
		// ABC : 2
		// DEF : 3
		// GHI : 4
		// JKL : 5
		// MNO : 6
		// PQRS : 7
		// TUV : 8
		// WXYZ : 9

		// UNUCIC : 868242 : 36 => 979353
		char[] dial = br.readLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < dial.length; i++) {
			switch (dial[i]) {
			case 'A':
			case 'B':
			case 'C':
				sum += 3;
				break;

			case 'D':
			case 'E':
			case 'F':
				sum += 4;
				break;

			case 'G':
			case 'H':
			case 'I':
				sum += 5;
				break;

			case 'J':
			case 'K':
			case 'L':
				sum += 6;
				break;

			case 'M':
			case 'N':
			case 'O':
				sum += 7;
				break;

			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				sum += 8;
				break;

			case 'T':
			case 'U':
			case 'V':
				sum += 9;
				break;

			default:
				sum += 10;
				break;
			}
		}
		System.out.println(sum);

	}
}
