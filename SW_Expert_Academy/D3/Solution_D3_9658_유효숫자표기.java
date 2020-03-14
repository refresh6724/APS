import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9658_유효숫자표기 { // 제출일 2020-03-14 23:15

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			char[] number = br.readLine().toCharArray();
			// 주어진 숫자가 3자리가 될 때 까지 없애고 1의 자리에서 반올림
			int len = number.length - 3 + 2;
			int n1 = number[0] - '0';
			int n2 = number[1] - '0';
			int n3 = number[2] - '0';

			if (n3 >= 5) {
				n2++;
			}
			if (n2 == 10) {
				n2 = 0;
				n1++;
			}
			if (n1 == 10) {
				n1 = 1;
				len++;
			}

			sb.append("#" + t + " " + n1 + "." + n2 + "*10^" + len + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
