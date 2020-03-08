import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9611_명진이와동휘의숫자맞추기 { // 제출일 2020-03-08 23:30

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, answer, numbers[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[10];
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				if (line[8] == 'Y') {
					numbers[line[0] - '0']++;
					numbers[line[2] - '0']++;
					numbers[line[4] - '0']++;
					numbers[line[6] - '0']++;
				} else {
					numbers[line[0] - '0']--;
					numbers[line[2] - '0']--;
					numbers[line[4] - '0']--;
					numbers[line[6] - '0']--;
				}
			}
			answer = 0;
			N *= -1;
			for (int i = 0; i < 10; i++) {
				if (numbers[i] > N) {
					N = numbers[i];
					answer = i;
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
