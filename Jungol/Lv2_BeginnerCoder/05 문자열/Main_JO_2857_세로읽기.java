import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2857_세로읽기 { // 제출일 2021-03-11 23:18

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		char[][] words = new char[5][15];
		for (int i = 0; i < words.length; i++) {
			Arrays.fill(words[i], ' ');
			String a = br.readLine();
			for (int j = 0; j < a.length(); j++) {
				words[i][j] = a.charAt(j);
			}
		}
		for (int col = 0; col < 15; col++) {
			for (int row = 0; row < 5; row++) {
				if (words[row][col] != ' ') {
					sb.append(words[row][col]);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}