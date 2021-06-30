import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_1274_2진수를10진수로 { // 제출일 2021-06-30 23:18

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력의 첫 줄에 8자리의 2진수가 들어온다
		// 2의 보수
		// 01111111 = 127
		// 11111111 = -1
		// 10000000 = -128
		char[] input = br.readLine().trim().toCharArray();
		// 출력의 첫 줄에 10진수로 변환한 값을 출력한다
		int output = 0;
		if (input[0] == '0') {

			for (int i = 7, j = 0; i >= 1; i--, j++) {
				if (input[i] == '1') {
					output += (1 << j);
				}
			}

		} else {

			int minus = -1;
			for (int i = 7, j = 0; i >= 1; i--, j++) {
				if (minus == -1) {
					if (input[i] == '1') {
						minus = 0;
						output += (1 << j);
					} else {
						continue;
					}
				} else {
					if (input[i] == '1') {
						continue;
					} else {
						output += (1 << j);
					}
				}
			}

			output *= -1;
		}

		System.out.println(output);
	}

}